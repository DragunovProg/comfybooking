package ua.dragunov.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.dragunov.api.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
