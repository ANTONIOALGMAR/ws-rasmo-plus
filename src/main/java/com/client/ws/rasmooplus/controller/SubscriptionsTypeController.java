package com.client.ws.rasmooplus.controller;

import com.client.ws.rasmooplus.dto.SubscriptionsTypeDto;
import com.client.ws.rasmooplus.model.SubscriptionsType;
import com.client.ws.rasmooplus.service.SubscriptionTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions-type")
public class SubscriptionsTypeController {

    @Autowired
    private SubscriptionTypeService subscriptionsTypeService;

    @GetMapping
    public ResponseEntity<List<SubscriptionsType>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionsTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionsType> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionsTypeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SubscriptionsType> create(@Valid @RequestBody SubscriptionsTypeDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionsTypeService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionsType> update(@PathVariable("id") Long id, @RequestBody SubscriptionsTypeDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionsTypeService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        subscriptionsTypeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
