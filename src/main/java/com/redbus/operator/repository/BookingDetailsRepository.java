package com.redbus.operator.repository;

import com.redbus.operator.entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails,String> {
}
