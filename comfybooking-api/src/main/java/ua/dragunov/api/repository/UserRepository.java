package ua.dragunov.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.dragunov.api.model.HotelServiceUser;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<HotelServiceUser, Long> {
    Optional<HotelServiceUser> findByEmail(String email);
}
