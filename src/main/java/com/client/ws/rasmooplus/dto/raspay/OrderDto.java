package com.client.ws.rasmooplus.dto.raspay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private String id;

    private String customerId;

    private String discount;

    private String productAcronym;
}
