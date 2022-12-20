package ua.dragunov.api.data.hotel;

import org.springframework.web.multipart.MultipartFile;

public record HotelPreviewResponse(
        long id,
        String name,
        MultipartFile picture,
        String city,
        String street,
        String houseNumber
) {
}
