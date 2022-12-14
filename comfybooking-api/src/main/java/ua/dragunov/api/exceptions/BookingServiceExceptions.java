
package ua.dragunov.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public final class BookingServiceExceptions {

    private BookingServiceExceptions() {
    }

    public static ResponseStatusException authorityNotFound(String value) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "User authority " + value + " not defined");
    }

    public static ResponseStatusException userNotFound(String email) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "User with email " + email + " not found");
    }

    public static ResponseStatusException userNotFound(long id) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + id + " not found");
    }


    public static ResponseStatusException duplicateEmail(String email) {
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email " + email + " already taken");
    }



    public static ResponseStatusException hotelNotFound(long id) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel with id " + id + " not found");
    }



    public static ResponseStatusException wrongPassword() {
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password is incorrect");
    }

}
