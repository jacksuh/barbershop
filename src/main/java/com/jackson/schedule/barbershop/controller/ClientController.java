package com.jackson.schedule.barbershop.controller;

import com.jackson.schedule.barbershop.dto.ClientDetailingDto;
import com.jackson.schedule.barbershop.dto.ClientDto;
import com.jackson.schedule.barbershop.model.Client;
import com.jackson.schedule.barbershop.repository.ClientRepository;
import com.jackson.schedule.barbershop.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("cliente")
public class ClientController {

    @Autowired
    ClientService service;

    @PostMapping
    public ResponseEntity ClientRegistration(@RequestBody ClientDto dto, UriComponentsBuilder uriBuilder){
        Client c = service.saveClient(dto);
        var uri = uriBuilder.path("/cliente/{id}").buildAndExpand(c.getName()).toUri();
        return ResponseEntity.created(uri).body(new ClientDetailingDto(c));
    }
}
