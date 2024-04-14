package com.redbus.operator.controller;

//import com.redbus.operator.payload.BusOperatorDto;
//import com.redbus.operator.repository.BusOperatorRepository;
//import com.redbus.operator.service.BusService;
//import com.redbus.operator.service.BusServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


import com.redbus.operator.payload.BusOperatorDto;
import com.redbus.operator.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/redbus/api/")
@Validated
public class BusOperatorController {
    @Autowired
    BusService busService;
    //http://localhost:8080/redbus/api/createBus
    @PostMapping("/createBus")
    public ResponseEntity<String> createBus(
            @Valid @RequestBody BusOperatorDto busOperatorDto
            ){
        busService.createBus(busOperatorDto);
        return new ResponseEntity<>("bus is created", HttpStatus.CREATED);
    }
}
