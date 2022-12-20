package ua.dragunov.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.dragunov.api.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
