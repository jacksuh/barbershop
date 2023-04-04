package com.jackson.schedule.barbershop.service;

import com.jackson.schedule.barbershop.dto.ClientDto;
import com.jackson.schedule.barbershop.model.Client;
import com.jackson.schedule.barbershop.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client saveClient(ClientDto dto){
        Client cli = new Client();
        cli.setName(dto.getName());

        return  repository.save(cli);
    }

}
