package com.redbus.operator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bus_Ticket")
public class BusTicket {
    @Id
    @Column(name = "ticket_id")
    private String ticketId;
    @Column(name = "bus_id")
    private String busId;
    @Column(name="ticket_cost")
    private Double ticketCost;
    @Column(name = "ticket_code")
    private String ticketCode;
    @Column(name = "discount_amount")
    private double discountAmount;

    @OneToOne(mappedBy = "busTicket" ,cascade = CascadeType.ALL)
    private BusOperator busOperator;

}
