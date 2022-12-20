package ua.dragunov.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.dragunov.api.data.reservation.ReservationResponse;
import ua.dragunov.api.data.reservation.CreateReservationRequest;

public interface ReservationOperations {

    ReservationResponse createReservation(CreateReservationRequest request);

    void deleteReservation(long id);

    ReservationResponse getReservationById(long id);

    Page<ReservationResponse> listReservation(Pageable pageable);
}
