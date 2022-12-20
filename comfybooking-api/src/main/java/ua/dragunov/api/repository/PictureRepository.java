package ua.dragunov.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.dragunov.api.model.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
}
