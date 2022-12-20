package ua.dragunov.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.dragunov.api.data.user.MergeUserRequest;
import ua.dragunov.api.data.user.SaveUserRequest;
import ua.dragunov.api.data.user.UserResponse;

public interface UserOperations {

    UserResponse findById(long id);

    UserResponse mergeById(long id, MergeUserRequest request);

    UserResponse mergeByEmail(String email, MergeUserRequest request);
    UserResponse create(SaveUserRequest saveUserRequest);
    UserResponse findUserByEmail(String email);

    void deleteByEmail(String email);

    void deleteById(long id);

    Page<UserResponse> list(Pageable pageable);
}