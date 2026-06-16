package nl.pluralsight.stagepass.dto;

import java.math.BigDecimal;

// FEAT-04: summary of seats sold, seats remaining, and total revenue for a concert
public record ConcertSummary(
        Long concertId,
        String concertTitle,
        int totalSeats,
        int seatsBooked,
        int availableSeats,
        BigDecimal totalRevenue
) {
}
