package com.client.ws.rasmooplus.integration;

import com.client.ws.rasmooplus.dto.raspay.CustomerDto;
import com.client.ws.rasmooplus.dto.raspay.OrderDto;
import com.client.ws.rasmooplus.dto.raspay.PaymentDto;

public interface WsRaspayIntegration {

    CustomerDto createCustomer(CustomerDto dto);

    OrderDto createOrder (OrderDto dto);

    Boolean processPaymentDto(PaymentDto dto);
}
