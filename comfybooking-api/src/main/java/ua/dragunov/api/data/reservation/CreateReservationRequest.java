package ua.dragunov.api.data.reservation;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record CreateReservationRequest(
        String userEmail,
        OffsetDateTime checkIn,
        OffsetDateTime checkOut,
        long roomId
) {
}
