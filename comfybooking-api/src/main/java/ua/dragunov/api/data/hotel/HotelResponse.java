package ua.dragunov.api.data.hotel;

import org.springframework.web.multipart.MultipartFile;
import ua.dragunov.api.data.room.RoomPreviewResponse;
import ua.dragunov.api.model.Hotel;

import java.util.List;

public record HotelResponse(
        long id,
        MultipartFile picture,
        String name,
        String city,
        String street,
        String houseNumber,
        List<RoomPreviewResponse> rooms) {

    public static HotelResponse fromHotel(Hotel hotel) {
        return new HotelResponse(
                hotel.getId(),
                null,
                hotel.getLocation().getCity(),
                hotel.getLocation().getStreet(),
                hotel.getLocation().getHouseNumber(),
                hotel.getLocation().getPostcode(),
                null);
    }
}
