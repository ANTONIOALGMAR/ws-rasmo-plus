package com.client.ws.rasmooplus.integration.impl;

import com.client.ws.rasmooplus.dto.raspay.CustomerDto;
import com.client.ws.rasmooplus.dto.raspay.OrderDto;
import com.client.ws.rasmooplus.dto.raspay.PaymentDto;
import com.client.ws.rasmooplus.integration.WsRaspayIntegration;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Component
public class WsRaspayIntegrationImpl implements WsRaspayIntegration {

    private final RestTemplate restTemplate;
    private final HttpHeaders headers;

    public WsRaspayIntegrationImpl(){

        restTemplate = new RestTemplate();
        headers = getHttpHeaders();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto dto) {
        try {
            HttpHeaders headers = new HttpHeaders();
            String credential = "rasmoplus:root";
            String base64 = Base64.encodeBase64String(credential.getBytes(StandardCharsets.UTF_8));
            headers.add("Authorization", "Basic "+ base64);
            HttpEntity<CustomerDto> request = new HttpEntity<>(dto, headers);
            ResponseEntity<CustomerDto> response =
                    restTemplate.exchange("http://localhost:8082/ws-raspay/v1/customer",
                            HttpMethod.POST, request, CustomerDto.class);

            return response.getBody();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public OrderDto createOrder(OrderDto dto) {
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<OrderDto> request = new HttpEntity<>(dto, headers);
            ResponseEntity<OrderDto> response =
                    restTemplate.exchange("http://localhost:8082/ws-raspay/v1/order", HttpMethod.POST, request, OrderDto.class);
            return response.getBody();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Boolean processPaymentDto(PaymentDto dto) {
        return null;
    }


    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        String credential = "rasmooplus:r@sm00";
        String base64 = new String(Base64.encodeBase64(credential.getBytes(), false));
        headers.add("Authorization", "Basic " + base64);
        return headers;
    }

}
