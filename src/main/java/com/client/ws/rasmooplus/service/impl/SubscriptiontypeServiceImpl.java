package com.client.ws.rasmooplus.service.impl;

import com.client.ws.rasmooplus.dto.SubscriptionsTypeDto;
import com.client.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.rasmooplus.exception.handler.BadRequestException;
import com.client.ws.rasmooplus.model.SubscriptionsType;
import com.client.ws.rasmooplus.repository.SubscriptionsTypeRepository;
import com.client.ws.rasmooplus.service.SubscriptionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SubscriptiontypeServiceImpl implements SubscriptionTypeService {

    private final SubscriptionsTypeRepository subscriptionsTypeRepository;

    SubscriptiontypeServiceImpl(SubscriptionsTypeRepository subscriptionsTypeRepository){
        this.subscriptionsTypeRepository = subscriptionsTypeRepository;

    }

    @Override
    public List<SubscriptionsType> findAll() {
        return subscriptionsTypeRepository.findAll();
    }

    @Override
    public SubscriptionsType findById(Long id) {
        Optional<SubscriptionsType> optionalSubscriptionsType = subscriptionsTypeRepository.findById(id);
        if (optionalSubscriptionsType.isEmpty()) {
            throw new NotFoundException("SubscriptionType não encontrado");
        }

        return optionalSubscriptionsType.get();
    }

    @Override
    public SubscriptionsType create(SubscriptionsTypeDto dto) {
        if (Objects.nonNull(dto.getId())) {
            throw new BadRequestException("Id deve ser nulo");
        }
        return subscriptionsTypeRepository.save(SubscriptionsType.builder()

                        .id(dto.getId())
                        .name(dto.getName())
                        .accessMonth(dto.getAcessMonth())
                        .price(dto.getPrice())
                        .productKey(dto.getProductKey())
                .build());
    }

    @Override
    public SubscriptionsType update(Long id, SubscriptionsType subscriptionsType) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
