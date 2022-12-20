package ua.dragunov.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.dragunov.api.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
