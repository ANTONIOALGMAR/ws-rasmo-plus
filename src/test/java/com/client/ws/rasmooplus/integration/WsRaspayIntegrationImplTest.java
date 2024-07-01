package com.client.ws.rasmooplus.integration;

import com.client.ws.rasmooplus.dto.raspay.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WsRaspayIntegrationImplTest {

    @Autowired
    private WsRaspayIntegration wsRaspayIntegration;

    @Test
    void createCustomerWhenDtoOK(){
        CustomerDto dto = new CustomerDto(null, "27121495058", "teste@teste", "Antonio", "Carvalho");
        wsRaspayIntegration.createCustomer(dto);
    }
}
