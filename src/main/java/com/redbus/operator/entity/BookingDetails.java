package com.redbus.operator.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booking_datails")
public class BookingDetails {
    @Id
    @Column(name = "booking_id")
    private String bookingId;
    @Column(name = "bus_id")
    private String busId;
    @Column(name = "ticket_id")
    private String ticketId;
    @Column(name = "ticket_cost")
    private Double ticketCost;
//    @Column(name = "bus_company")
//    private String busCompany;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "dob")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "from_city")
    private String fromCity;
    @Column(name = "to_city")
    private String toCity;
}
