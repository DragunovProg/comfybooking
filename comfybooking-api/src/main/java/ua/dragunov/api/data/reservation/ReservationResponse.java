package ua.dragunov.api.data.reservation;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record ReservationResponse(
        long id,
        OffsetDateTime checkIn,
        OffsetDateTime checkOut,
        BigDecimal fullPrice,
        String roomName,
        String userEmail
) {
}
