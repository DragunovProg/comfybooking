package ua.dragunov.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.dragunov.api.data.room.CreateRoomRequest;
import ua.dragunov.api.data.room.RoomResponse;

import java.util.Optional;

public interface RoomOperations {

    public long createRoom(CreateRoomRequest request);

    public Optional<RoomResponse> getById(long id);

    public void deleteRoom(long id);

    public Page<RoomResponse> list(Pageable pageable);
}
