package ua.dragunov.api.service.implementation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dragunov.api.data.room.CreateRoomRequest;
import ua.dragunov.api.data.room.RoomResponse;
import ua.dragunov.api.model.Picture;
import ua.dragunov.api.model.Room;
import ua.dragunov.api.repository.HotelRepository;
import ua.dragunov.api.repository.PictureRepository;
import ua.dragunov.api.repository.RoomRepository;
import ua.dragunov.api.service.RoomOperations;

import java.util.Optional;

@Service
public class RoomService implements RoomOperations {
    private final RoomRepository repository;
    private final HotelRepository hotelRepository;
    private final PictureRepository pictureRepository;

    public RoomService(RoomRepository repository, HotelRepository hotelRepository, PictureRepository pictureRepository) {
        this.repository = repository;
        this.hotelRepository = hotelRepository;
        this.pictureRepository = pictureRepository;
    }


    @Override
    @Transactional
    public long createRoom(CreateRoomRequest request) {
        Room room = new Room();
        Picture picture = new Picture();

        picture.setName(request.picture().getName());

        room.setName(request.name());
        room.setPicture(picture);
        room.setHotel(hotelRepository.findById(request.hotelId()).get());
        room.setPrice(request.price());
        room.setPlaces(request.places());
        room.setRoomNumber(request.roomNumber());

        repository.save(room);

        return request.id();
    }

    @Override
    public Optional<RoomResponse> getById(long id) {
        return repository.findById(id).map(RoomResponse::fromRoom);
    }

    @Override
    public void deleteRoom(long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<RoomResponse> list(Pageable pageable) {
        return repository.findAll(pageable).map(RoomResponse::fromRoom);
    }
}
