package com.greenbus.GreenBus.service.impl;

import com.greenbus.GreenBus.dao.BusDao;
import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import com.greenbus.GreenBus.data.model.dto.BusDto;
import com.greenbus.GreenBus.data.model.entities.Bus;
import com.greenbus.GreenBus.data.model.entities.Seat;
import com.greenbus.GreenBus.data.model.enums.Gender;
import com.greenbus.GreenBus.data.model.enums.Status;
import com.greenbus.GreenBus.service.BusService;
import com.greenbus.GreenBus.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BusServiceImpl implements BusService {
    private final BusDao busDao;
    private final ModelMapper modelMapper;
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
        bus.setSeats(seats);
        bus.createEntity();
        return ResponseUtil.getCreatedResponse(busDao.saveBus(bus));
    }
}
