package ua.dragunov.api.data.user;

import ua.dragunov.api.model.HotelServiceUser;

public record SaveUserRequest(
        long id,
        String firstName,
        String lastName,
        String email,
        String password,
        String phone
) {

}
