package com.redbus.operator.payload;

//import com.fasterxml.jackson.annotation.JsonFormat;
//import jakarta.persistence.Column;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.antlr.v4.runtime.misc.NotNull;
//
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
//import java.time.LocalTime;
//import java.util.Date;
//package com.redbus.operator.payload;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.validation.constraints.*;

import com.redbus.operator.entity.BusTicket;
import lombok.Data;


import javax.validation.constraints.*;
import java.time.LocalTime;
import java.util.Date;

@Data
public class BusOperatorDto {
    private String busId;

    @Positive(message = "Bus number must be a positive integer")
    private int busNumber;

    @NotBlank(message = "Driver name is required")
    private String driverName;

    @Positive(message = "Number of seats must be a positive integer")
    private int numberOfSeats;

    @NotBlank(message = "Departure city is required")
    private String departureCity;

    @NotBlank(message = "Arrival city is required")
    private String arrivalCity;

    @NotNull(message = "Departure time is required")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime departureTime;

    @NotNull(message = "Arrival time is required")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime arrivalTime;

    @NotNull(message = "Departure date is required")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date departureDate;

    @NotNull(message = "Arrival date is required")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date arrivalDate;

    @Positive(message = "Total travel time must be a positive number")
    @JsonFormat(pattern =  "HH:mm:ss")
    private double totalTravelTime;

    @NotBlank(message = "Bus type is required")
    private String busType;

    @NotBlank(message = "Amenities are required")
    private String aminities;

    private BusTicket busTicket;
}
//    private String busId;
//
//    @Positive(message = "Bus number must be a positive integer")
//    private int busNumber;
//
//    @NotBlank(message = "Driver name is required")
//    @Size(min = 2, max = 100, message = "Driver name must be between {min} and {max} characters")
//    private String driverName;
//
//    @Positive(message = "Number of seats must be a positive integer")
//    private int numberOfSeats;
//
//    @NotBlank(message = "Departure city is required")
//    private String departureCity;
//
//    @NotBlank(message = "Arrival city is required")
//    private String arrivalCity;
//
//    @NotNull(message = "Departure time is required")
//    @JsonFormat(pattern = "HH:mm:ss")
//    private LocalTime departureTime;
//
//    @NotNull(message = "Arrival time is required")
//    @JsonFormat(pattern = "HH:mm:ss")
//    private LocalTime arrivalTime;
//
//    @NotNull(message = "Departure date is required")
//    @JsonFormat(pattern = "dd/MM/yyyy")
//    private Date departureDate;
//
//    @NotNull(message = "Arrival date is required")
//    @JsonFormat(pattern = "dd/MM/yyyy")
//    private Date arrivalDate;
//
//    @Positive(message = "Total travel time must be a positive number")
//    private double totalTravelTime;
//
//    @NotBlank(message = "Bus type is required")
//    private String busType;
