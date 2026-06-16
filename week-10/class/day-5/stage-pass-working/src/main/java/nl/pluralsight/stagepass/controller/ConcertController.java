package nl.pluralsight.stagepass.controller;

import jakarta.validation.Valid;
import nl.pluralsight.stagepass.dto.ConcertSummary;
import nl.pluralsight.stagepass.model.Concert;
import nl.pluralsight.stagepass.service.BookingService;
import nl.pluralsight.stagepass.service.ConcertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/concerts")
public class ConcertController {

    private final ConcertService concertService;
    private final BookingService bookingService;

    public ConcertController(ConcertService concertService, BookingService bookingService) {
        this.concertService = concertService;
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<Concert>> getAllConcerts() {
        return ResponseEntity.ok(concertService.getAllConcerts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Concert> getConcertById(@PathVariable Long id) {
        return concertService.getConcertById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // FEAT-02: concerts for a specific artist (empty array if the artist has none)
    @GetMapping("/artist/{artistId}")
    public ResponseEntity<List<Concert>> getConcertsByArtist(@PathVariable Long artistId) {
        return ResponseEntity.ok(concertService.getConcertsByArtist(artistId));
    }

    // FEAT-03: only future concerts, sorted by date ascending
    @GetMapping("/upcoming")
    public ResponseEntity<List<Concert>> getUpcomingConcerts() {
        return ResponseEntity.ok(concertService.getUpcomingConcerts());
    }

    // FEAT-04: booking summary for a concert (404 if it doesn't exist)
    @GetMapping("/{id}/summary")
    public ResponseEntity<ConcertSummary> getConcertSummary(@PathVariable Long id) {
        return concertService.getConcertSummary(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Concert> createConcert(@Valid @RequestBody Concert concert) {
        Concert created = concertService.createConcert(concert);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Concert> updateConcert(@PathVariable Long id, @RequestBody Concert concert) {
        return concertService.updateConcert(id, concert)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConcert(@PathVariable Long id) {
        if (concertService.deleteConcert(id)) {
            // BUG-03: successful delete with no body returns 204 No Content
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
