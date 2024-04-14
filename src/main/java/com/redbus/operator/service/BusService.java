package com.redbus.operator.service;

import com.redbus.operator.entity.BusOperator;
import com.redbus.operator.payload.BusOperatorDto;

public interface BusService {
    public BusOperator createBus(BusOperatorDto busOperatorDto);
}
