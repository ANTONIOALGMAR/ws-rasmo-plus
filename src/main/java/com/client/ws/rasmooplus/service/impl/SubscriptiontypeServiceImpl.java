package com.client.ws.rasmooplus.service.impl;

import com.client.ws.rasmooplus.dto.SubscriptionsTypeDto;
import com.client.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.rasmooplus.exception.BadRequestException;
import com.client.ws.rasmooplus.mapper.SubscriptionTypeMapper;
import com.client.ws.rasmooplus.model.SubscriptionsType;
import com.client.ws.rasmooplus.repository.SubscriptionsTypeRepository;
import com.client.ws.rasmooplus.service.SubscriptionTypeService;
import com.client.ws.rasmooplus.controller.SubscriptionsTypeController;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SubscriptiontypeServiceImpl implements SubscriptionTypeService {

    private static final String UPDATE = "update";
    private static final String DELETE = "delete";
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
        return getSubscriptionsType(id).add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(SubscriptionsTypeController.class).findById(id))
                .withSelfRel()
        ).add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(SubscriptionsTypeController.class).update(id, new SubscriptionsTypeDto()))
                .withRel(UPDATE)
        ).add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(SubscriptionsTypeController.class).delete(id))
                .withRel(DELETE)
        );
    }

    @Override
    public SubscriptionsType create(SubscriptionsTypeDto dto) {
        if (Objects.nonNull(dto.getId())) {
            throw new BadRequestException("Id deve ser nulo");
        }
        return subscriptionsTypeRepository.save(SubscriptionTypeMapper.fromDtoToEntity(dto));

    }

    @Override
    public SubscriptionsType update(Long id, SubscriptionsTypeDto dto) {
        getSubscriptionsType(id);
        dto.setId(id);
        return subscriptionsTypeRepository.save(SubscriptionTypeMapper.fromDtoToEntity(dto));
    }

    @Override
    public void delete(Long id) {
        getSubscriptionsType(id);
        subscriptionsTypeRepository.deleteById(id);
    }

    private SubscriptionsType getSubscriptionsType(Long id) {
        Optional<SubscriptionsType> optionalSubscriptionsType = subscriptionsTypeRepository.findById(id);
        if (optionalSubscriptionsType.isEmpty()) {
            throw new NotFoundException("SubscriptionType não encontrado");
        }
        return optionalSubscriptionsType.get();
    }
}
