package com.client.ws.rasmooplus.dto.raspay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDto {

    private Long cvv;

    private String documentNumber;

    private Long installments;

    private Long month;

    private String number;

    private Long year;
}
