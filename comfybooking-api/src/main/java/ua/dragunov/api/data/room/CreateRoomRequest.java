package ua.dragunov.api.data.room;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public record CreateRoomRequest(
        long id,
        String name,
        MultipartFile picture,
        int roomNumber,
        long hotelId,
        int places,
        BigDecimal price,
        String description) {


}
