package com.redbus.user.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.redbus.operator.entity.BusTicket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalTime;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusListDto {
    private String busId;

    @Positive(message = "Bus number must be a positive integer")
    private int busNumber;
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

    private BusTicket busTicket;
}
