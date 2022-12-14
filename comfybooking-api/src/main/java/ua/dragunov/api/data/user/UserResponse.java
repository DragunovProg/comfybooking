package ua.dragunov.api.data.user;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ua.dragunov.api.model.HotelServiceUser;

import java.util.Collections;
import java.util.Set;

public record UserResponse(
        long id,
        String email,
        String password,
        String firstName,
        String lastName,
        String phone,
        Set<SimpleGrantedAuthority> roles
) {

    public static UserResponse fromUser(HotelServiceUser user) {
        return new UserResponse(user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                Collections.singleton(new SimpleGrantedAuthority(user.getRole().getName())));
    }
}
