package com.redbus.user.controller;

import com.redbus.operator.entity.BusOperator;
import com.redbus.user.payload.BusListDto;
import com.redbus.user.service.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")

public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private ModelMapper modelMapper;
    //http://localhost:8080/api/user/searchBus?departureCity="San Antonio"&arrivalCity="Austin"&departureDate="2023/12/28 05:30:00.000000"
    @GetMapping("/searchBus")
    public ResponseEntity<List<BusListDto>> searchBuses(
            @RequestParam String departureCity,
            @RequestParam String arrivalCity,
            @RequestParam @DateTimeFormat(pattern = "yyyy/MM/dd") Date departureDate
    ){
        List<BusOperator> busOperators = userServiceImpl.searchBus(departureCity, arrivalCity, departureDate);
        List<BusListDto> busDto = busOperators.stream().map(bus -> mapToDto(bus)).collect(Collectors.toList());
        return new ResponseEntity<>(busDto, HttpStatus.OK);
    }

    private BusListDto mapToDto(BusOperator bus) {
//        BusListDto busListDto=new BusListDto();
//        busListDto.setBusId(bus.getBusId());
//        busListDto.setBusNumber(bus.getBusNumber());
//        busListDto.setArrivalDate(bus.getArrivalDate());
//        busListDto.setArrivalTime(bus.getArrivalTime());
//        busListDto.setDepartureDate(bus.getDepartureDate());
//        busListDto.setDepartureTime(bus.getDepartureTime());
//        return busListDto;
        BusListDto map = modelMapper.map(bus, BusListDto.class);
        return map;

    }
}
