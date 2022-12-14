package ua.dragunov.api.service.implementation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.dragunov.api.data.user.MergeUserRequest;
import ua.dragunov.api.data.user.SaveUserRequest;
import ua.dragunov.api.data.user.UserResponse;
import ua.dragunov.api.model.HotelServiceUser;
import ua.dragunov.api.repository.UserRepository;
import ua.dragunov.api.service.UserOperations;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService, UserOperations {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HotelServiceUser hotelServiceUser = userRepository.findByEmail(username).orElseThrow();
        return new User(hotelServiceUser.getEmail()
                , hotelServiceUser.getPassword()
                , Collections.singleton(new SimpleGrantedAuthority(hotelServiceUser.getRole().getName())));
    }

    @Override
    public UserResponse findById(long id) {
        return null;
    }

    @Override
    public UserResponse mergeById(long id, MergeUserRequest request) {
        return null;
    }

    @Override
    public UserResponse mergeByEmail(String email, MergeUserRequest request) {
        return null;
    }

    @Override
    public UserResponse create(SaveUserRequest saveUserRequest) {
        return null;
    }

    @Override
    public UserResponse findUserByEmail(String email) {
        return null;
    }

    @Override
    public void deleteByEmail(String email) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Page<UserResponse> list(Pageable pageable) {
        return null;
    }
}
