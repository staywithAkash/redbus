package com.redbus.operator.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusOperator {
    @Id
    private String busId;
    @Column(name = "bus_number")
    private int busNumber;
    @Column(name="driver_name")
    private String driverName;
    @Column(name="number_of_seats")
    private int numberOfSeats;
    @Column(name="departure_city")
    private String departureCity;
    @Column(name="arrival_city")
    private String arrivalCity;
    @Column(name = "departure_time")
    private LocalTime departureTime;
    @Column(name = "arrival_time")
    private LocalTime arrivalTime;
    @Column(name="departure_date")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date departureDate;
    @Column(name="arrival_date")
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;
    @Column(name = "total_travel_time")
    private double totalTravelTime;
    @Column(name = "bus_type")
    private String busType;
    @Column(name = "aminities")
    private String aminities;

    @OneToOne
    @JoinColumn(name = "bus_ticket")
    private BusTicket busTicket;
}
