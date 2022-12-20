package ua.dragunov.api.service.implementation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.dragunov.api.data.reservation.ReservationResponse;
import ua.dragunov.api.data.reservation.CreateReservationRequest;
import ua.dragunov.api.service.ReservationOperations;

@Service
public class ReservationService implements ReservationOperations {


    @Override
    public ReservationResponse createReservation(CreateReservationRequest request) {
        return null;
    }

    @Override
    public void deleteReservation(long id) {

    }

    @Override
    public ReservationResponse getReservationById(long id) {
        return null;
    }

    @Override
    public Page<ReservationResponse> listReservation(Pageable pageable) {
        return null;
    }
}
