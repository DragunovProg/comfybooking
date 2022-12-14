package ua.dragunov.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ua.dragunov.api.data.reservation.CreateReservationRequest;
import ua.dragunov.api.data.reservation.ReservationResponse;
import ua.dragunov.api.data.user.MergeUserRequest;
import ua.dragunov.api.data.user.SaveUserRequest;
import ua.dragunov.api.data.user.UserResponse;
import ua.dragunov.api.service.ReservationOperations;
import ua.dragunov.api.service.UserOperations;

import javax.validation.Valid;

@RestController
@RequestMapping(path = {"api/v1/users"})
public class UserController {
    private final UserOperations userOperations;
    private final ReservationOperations reservationOperations;

    public UserController(UserOperations userOperations, ReservationOperations reservationOperations) {
        this.userOperations = userOperations;
        this.reservationOperations = reservationOperations;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse register(@RequestBody @Valid SaveUserRequest request) { return userOperations.create(request); }

    @GetMapping("/me")
    public UserResponse getCurrentUser(@AuthenticationPrincipal String email) {
        return userOperations.findUserByEmail(email);
    }

    @PutMapping("/me")
    public UserResponse mergeCurrentUser(@AuthenticationPrincipal String email, MergeUserRequest request) {
        return userOperations.mergeByEmail(email, request);
    }


    @DeleteMapping("/me")
    public void deleteCurrentUser(@AuthenticationPrincipal String email) {
        userOperations.deleteByEmail(email);
    }

    @GetMapping("/me/reservations/{id}")
    public ReservationResponse reservation(@PathVariable long id) { return reservationOperations.getReservationById(id); }

    @GetMapping("/me/reservations")
    public Page<ReservationResponse> reservationList(Pageable pageable) { return reservationOperations.listReservation(pageable); }

    @PostMapping("/me/reservations")
    public ReservationResponse reservationList(CreateReservationRequest request) { return reservationOperations.createReservation(request); }



}
