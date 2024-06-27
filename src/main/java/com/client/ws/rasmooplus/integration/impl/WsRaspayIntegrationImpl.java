package com.client.ws.rasmooplus.integration.impl;

import com.client.ws.rasmooplus.dto.raspay.CustomerDto;
import com.client.ws.rasmooplus.dto.raspay.OrderDto;
import com.client.ws.rasmooplus.dto.raspay.PaymentDto;
import com.client.ws.rasmooplus.integration.WsRaspayIntegration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WsRaspayIntegrationImpl implements WsRaspayIntegration {

    private RestTemplate restTemplate;

    public WsRaspayIntegrationImpl(){

        restTemplate = new RestTemplate();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto dto) {
        return null;
    }

    @Override
    public OrderDto createOrder(OrderDto dto) {
        return null;
    }

    @Override
    public Boolean processPaymentDto(PaymentDto dto) {
        return null;
    }
}
