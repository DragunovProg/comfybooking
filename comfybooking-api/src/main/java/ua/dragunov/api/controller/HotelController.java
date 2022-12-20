package ua.dragunov.api.controller;

import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ua.dragunov.api.data.hotel.CreateHotelRequest;
import ua.dragunov.api.data.hotel.HotelPreviewResponse;
import ua.dragunov.api.data.hotel.HotelResponse;
import ua.dragunov.api.exceptions.BookingServiceExceptions;
import ua.dragunov.api.service.HotelOperations;

import javax.validation.Valid;

@RestController
@RequestMapping(path = {"api/v1/hotels"})
public class HotelController {
    private final HotelOperations hotelService;

    public HotelController(HotelOperations hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping(path = {"/hotels"}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createHotel(@Valid @ModelAttribute CreateHotelRequest createHotelRequest,
                                            UriComponentsBuilder ucb) {

        long hotelId = hotelService.create(createHotelRequest);

        return ResponseEntity.created(ucb.path("/hotels/{id}").build(hotelId)).build();
    }

    @GetMapping(path = {"/hotels"})
    @PageableAsQueryParam
    public Page<HotelPreviewResponse> hotels(Pageable pageable) {
        return hotelService.list(pageable);
    }

    @GetMapping(path = {"/hotels{id}"})
    public HotelResponse getHotel(@PathVariable long id) {

        return hotelService.getById(id).orElseThrow(() -> BookingServiceExceptions.hotelNotFound(id));
    }
}
