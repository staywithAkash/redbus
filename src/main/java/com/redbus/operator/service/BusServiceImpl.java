package com.redbus.operator.service;

import com.redbus.operator.entity.BusOperator;
import com.redbus.operator.entity.BusTicket;
import com.redbus.operator.payload.BusOperatorDto;
import com.redbus.operator.repository.BusOperatorRepository;
import com.redbus.operator.repository.BusTicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BusServiceImpl implements BusService{

    private BusTicketRepository busTicketRepository;
    private BusOperatorRepository busOperatorRepository;
    private ModelMapper modelMapper;

    public BusServiceImpl(BusTicketRepository busTicketRepository, BusOperatorRepository busOperatorRepository, ModelMapper modelMapper) {
        this.busTicketRepository = busTicketRepository;
        this.busOperatorRepository = busOperatorRepository;
        this.modelMapper = modelMapper;
    }

    //    private BusOperatorRepository busOperatorRepository;
//
//    public BusServiceImpl(BusOperatorRepository busOperatorRepository) {
//        this.busOperatorRepository = busOperatorRepository;
//    }
    @Override
    public BusOperator createBus(BusOperatorDto busOperatorDto) {
        //BusTicket
        BusTicket busTicket=new BusTicket();
        busTicket.setBusId(busOperatorDto.getBusId());
        busTicket.setTicketCode(busOperatorDto.getBusTicket().getTicketCode());
        busTicket.setTicketCost(busOperatorDto.getBusTicket().getTicketCost());
        busTicket.setDiscountAmount(busOperatorDto.getBusTicket().getDiscountAmount());
        String ticketId=UUID.randomUUID().toString();
        busTicket.setTicketId(ticketId);
        busTicketRepository.save(busTicket);

        BusOperator mappedToEntity= mapToEntity(busOperatorDto);
        String busId= UUID.randomUUID().toString();
        mappedToEntity.setBusId(busId);
        mappedToEntity.setBusTicket(busTicket);

        return busOperatorRepository.save(mappedToEntity);
    }

    private BusOperator mapToEntity(BusOperatorDto busOperatorDto) {
        BusOperator mappedToEntity=modelMapper.map(busOperatorDto,BusOperator.class);
        return mappedToEntity;
    }
}
