package ua.dragunov.api.data.room;

import java.math.BigDecimal;

public record RoomPreviewResponse(long id, String name, BigDecimal price, String description) {
}
