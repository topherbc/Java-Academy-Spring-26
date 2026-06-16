package nl.pluralsight.stagepass.service;

import nl.pluralsight.stagepass.exception.InsufficientSeatsException;
import nl.pluralsight.stagepass.model.Booking;
import nl.pluralsight.stagepass.model.Concert;
import nl.pluralsight.stagepass.repository.BookingRepository;
import nl.pluralsight.stagepass.repository.ConcertRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ConcertRepository concertRepository;

    public BookingService(BookingRepository bookingRepository, ConcertRepository concertRepository) {
        this.bookingRepository = bookingRepository;
        this.concertRepository = concertRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    // BUG-05: filter by concert instead of returning every booking
    public List<Booking> getBookingsByConcert(Long concertId) {
        return bookingRepository.findByConcertId(concertId);
    }

    @Transactional
    public Booking createBooking(Booking booking) {
        Concert concert = concertRepository.findById(booking.getConcert().getId())
                .orElseThrow(() -> new RuntimeException("Concert not found"));

        // FEAT-01: overbooking protection — reject if not enough seats remain
        if (concert.getAvailableSeats() < booking.getNumberOfTickets()) {
            throw new InsufficientSeatsException(
                    "Not enough seats available. Requested: " + booking.getNumberOfTickets()
                            + ", available: " + concert.getAvailableSeats());
        }

        // BUG-04: compute total price = ticketPrice * numberOfTickets using BigDecimal
        BigDecimal totalPrice = concert.getTicketPrice()
                .multiply(BigDecimal.valueOf(booking.getNumberOfTickets()));
        booking.setTotalPrice(totalPrice);

        // Set booking date and concert reference
        booking.setBookingDate(LocalDate.now());
        booking.setConcert(concert);

        // Update the concert's available seats to reflect this booking
        concert.setAvailableSeats(concert.getAvailableSeats() - booking.getNumberOfTickets());
        concertRepository.save(concert);

        return bookingRepository.save(booking);
    }

    public boolean cancelBooking(Long id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
