package ua.dragunov.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.dragunov.api.data.hotel.CreateHotelRequest;
import ua.dragunov.api.data.hotel.HotelPreviewResponse;
import ua.dragunov.api.data.hotel.HotelResponse;

import java.util.Optional;

public interface HotelOperations {

    long create(CreateHotelRequest request);

    void delete(long id);

    Page<HotelResponse> list(Pageable pageable);

    Optional<HotelResponse> getById(long id);
}
