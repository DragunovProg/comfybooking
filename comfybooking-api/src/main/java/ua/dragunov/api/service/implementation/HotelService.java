package ua.dragunov.api.service.implementation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dragunov.api.data.hotel.CreateHotelRequest;
import ua.dragunov.api.data.hotel.HotelResponse;
import ua.dragunov.api.model.Hotel;
import ua.dragunov.api.model.Location;
import ua.dragunov.api.model.Picture;
import ua.dragunov.api.repository.HotelRepository;
import ua.dragunov.api.repository.LocationRepository;
import ua.dragunov.api.repository.PictureRepository;
import ua.dragunov.api.service.HotelOperations;

import java.util.Optional;

@Service
public class HotelService implements HotelOperations {
    private final HotelRepository hotelRepository;
    private final PictureRepository pictureRepository;
    private final LocationRepository locationRepository;

    public HotelService(HotelRepository hotelRepository, PictureRepository pictureRepository, LocationRepository locationRepository) {
        this.hotelRepository = hotelRepository;
        this.pictureRepository = pictureRepository;
        this.locationRepository = locationRepository;
    }

    @Transactional
    @Override
    public long create(CreateHotelRequest request) {
        Hotel hotel = new Hotel();
        Picture picture = new Picture();
        Location location = new Location();

        location.setCity(request.city());
        location.setStreet(request.street());
        location.setHouseNumber(request.houseNumber());
        location.setPostcode(request.postcode());

        picture.setName(request.picture().getName());

        hotel.setName(request.name());
        hotel.setLocation(location);
        hotel.setPicture(picture);

        locationRepository.save(location);
        pictureRepository.save(picture);
        hotelRepository.save(hotel);

        return request.id();
    }

    @Override
    public void delete(long id) {

        hotelRepository.deleteById(id);
    }

    @Override
    public Page<HotelResponse> list(Pageable pageable) {

        return hotelRepository.findAll(pageable).map(HotelResponse::fromHotel);
    }

    @Override
    public Optional<HotelResponse> getById(long id) {
        return hotelRepository.findById(id).map(HotelResponse::fromHotel);
    }
}
