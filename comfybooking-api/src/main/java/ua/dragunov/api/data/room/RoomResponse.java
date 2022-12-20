package ua.dragunov.api.data.room;

import org.springframework.web.multipart.MultipartFile;
import ua.dragunov.api.model.Room;

import java.math.BigDecimal;

public record RoomResponse(
        long id,
        String name,
        MultipartFile picture,
        int roomNumber,
        int places,
        BigDecimal price) {

    public static RoomResponse fromRoom(Room room) {
        return new RoomResponse(
                room.getId(),
                room.getName(),
                null,
                room.getRoomNumber(),
                room.getPlaces(),
                room.getPrice());
    }
}
