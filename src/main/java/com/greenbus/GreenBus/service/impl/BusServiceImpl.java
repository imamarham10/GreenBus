package com.greenbus.GreenBus.service.impl;

import com.greenbus.GreenBus.dao.BusDao;
import com.greenbus.GreenBus.dao.PlaceDao;
import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import com.greenbus.GreenBus.data.model.dto.BusDto;
import com.greenbus.GreenBus.data.model.entities.Bus;
import com.greenbus.GreenBus.data.model.entities.Place;
import com.greenbus.GreenBus.data.model.entities.Seat;
import com.greenbus.GreenBus.data.model.enums.Gender;
import com.greenbus.GreenBus.data.model.enums.Status;
import com.greenbus.GreenBus.service.BusService;
import com.greenbus.GreenBus.util.CommonConstants;
import com.greenbus.GreenBus.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusServiceImpl implements BusService {
    private final BusDao busDao;
    private final ModelMapper modelMapper;
    private final PlaceDao placeDao;
    @Override
    public ResponseEntity<ApiResponse> createBus(BusDto busDto) {
        Bus bus = modelMapper.map(busDto, Bus.class);
        List<Seat> seats = new ArrayList<>();
        for(int i=1; i<=busDto.getNumberOfSeats(); i++){
            Seat seat = new Seat();
            seat.setSeatNumber("S"+i);
            seat.setSeatStatus(Status.AVAILABLE);
            seat.setPassengerGender(Gender.NOT_SELECTED);
            seat.setBus(bus);
            seat.createEntity();
            seats.add(seat);
        }
        Place source = placeDao.getPlaceById(busDto.getSource());
        Place destination = placeDao.getPlaceById(busDto.getDestination());
        bus.setSource(source);
        bus.setDestination(destination);
        bus.setSeats(seats);
        bus.createEntity();
        return ResponseUtil.getCreatedResponse(busDao.saveBus(bus));
    }

    @Override
    public ResponseEntity<ApiResponse> getAllBuses() {
        return ResponseUtil.getOkResponse(busDao.getAllBuses());
    }

    @Override
    public ResponseEntity<ApiResponse> getAllBusesBySourceAndDestination(String sourceName, String destinationName) {
        Place source = placeDao.getPlaceByName(sourceName);
        Place destination = placeDao.getPlaceByName(destinationName);

        if(source == null || destination == null) {
            return ResponseUtil.getBadRequestResponse(null);
        }
        return ResponseUtil.getOkResponse(busDao.getAllBusesBySourceAndDestination(source,destination));

    }

    @Override
    public ResponseEntity<ApiResponse> getAllBusesBySourceDestinationDate(String sourceName, String destinationName, String date) {
        Place source = placeDao.getPlaceByName(sourceName);
        Place destination = placeDao.getPlaceByName(destinationName);
        LocalDate requestedDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);

        List<Bus> buses = busDao.getAllBusesBySourceAndDestination(source, destination);
        List<Bus> filteredBuses = buses.stream()
                .filter(bus -> bus.isRecurring() || bus.getDepartureDate().toLocalDate().equals(requestedDate))
                .toList();

        if (filteredBuses.isEmpty()) {
            return ResponseUtil.getNotFoundResponse("No buses found for the given source, destination, and date");
        }
        return ResponseUtil.getOkResponse(filteredBuses);
    }
}
