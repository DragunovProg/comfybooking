package ua.dragunov.api.data.hotel;

import org.springframework.web.multipart.MultipartFile;

public record CreateHotelRequest(
        long id,
        String name,
        String city,
        String street,
        String houseNumber,
        String postcode,
        MultipartFile picture
) {
}
