package com.redbus.user.service;

import com.redbus.operator.entity.BookingDetails;
import com.redbus.operator.entity.BusOperator;
import com.redbus.operator.entity.BusTicket;
import com.redbus.operator.payload.BookingDetailsDto;
import com.redbus.operator.repository.BookingDetailsRepository;
import com.redbus.operator.repository.BusOperatorRepository;
import com.redbus.user.payload.PersonalDetailDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl {

    private BusOperatorRepository busOperatorRepository;
    private ModelMapper mapper;
    private BookingDetailsRepository bookingDetailsRepository;

    public UserServiceImpl(BusOperatorRepository busOperatorRepository, ModelMapper mapper, BookingDetailsRepository bookingDetailsRepository) {
        this.busOperatorRepository = busOperatorRepository;
        this.mapper = mapper;
        this.bookingDetailsRepository = bookingDetailsRepository;
    }

    public List<BusOperator> searchBus(
            String departureCity,
            String arrivalCity,
            Date departureDate
    ){
        List<BusOperator> buses=busOperatorRepository.searchByDepartureCityAndArrivalCityAndDepartureDate(
                departureCity,
                arrivalCity,
                departureDate
        );
        return buses;
    }

    public BookingDetailsDto createBooking(
            String busId,
            PersonalDetailDto personalDetailDto) {
        BusOperator busOperator = busOperatorRepository.findById(busId).get();
        BusTicket busTicket = busOperator.getBusTicket();
        String ticketId1 = busTicket.getTicketId();
        Double ticketCost = busTicket.getTicketCost();
        BookingDetails bookingDetails = mapToEntity(personalDetailDto);
        String bookingId = UUID.randomUUID().toString();
        bookingDetails.setBookingId(bookingId);
        bookingDetails.setTicketId(ticketId1);
        bookingDetails.setTicketCost(busTicket.getTicketCost());
        bookingDetails.setBusId(busId);
        bookingDetailsRepository.save(bookingDetails);
        BookingDetailsDto bookingDetailsDto1 = mapToDto(bookingDetails);
        return bookingDetailsDto1;
    }

    private BookingDetailsDto mapToDto(BookingDetails bookingDetails) {
        BookingDetailsDto mappedToDto = mapper.map(bookingDetails, BookingDetailsDto.class);
        return mappedToDto;
    }

    public BookingDetails mapToEntity(PersonalDetailDto personalDetailDto){
        BookingDetails mappedToEntity = mapper.map(personalDetailDto, BookingDetails.class);
        return mappedToEntity;
    }
}
