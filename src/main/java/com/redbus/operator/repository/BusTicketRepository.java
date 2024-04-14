package com.redbus.operator.repository;

import com.redbus.operator.entity.BusTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusTicketRepository extends JpaRepository<BusTicket,String> {
}
