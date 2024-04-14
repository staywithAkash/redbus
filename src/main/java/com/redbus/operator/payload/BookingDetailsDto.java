package com.redbus.operator.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetailsDto {
    private String bookingId;
    private String busId;
    private String ticketId;
    private String ticketCost;
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dob;
    private String email;
    private String mobile;
    private String fromCity;
    private String toCity;
}
