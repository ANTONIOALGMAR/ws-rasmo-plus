package com.client.ws.rasmooplus.mapper;

import com.client.ws.rasmooplus.dto.SubscriptionsTypeDto;
import com.client.ws.rasmooplus.model.SubscriptionsType;

public class SubscriptionTypeMapper {

    public static SubscriptionsType fromDtoToEntity(SubscriptionsTypeDto dto){
        return SubscriptionsType.builder()

                .id(dto.getId())
                .name(dto.getName())
                .accessMonths(dto.getAcessMonths())
                .price(dto.getPrice())
                .productKey(dto.getProductKey())
                .build();
    }
}
