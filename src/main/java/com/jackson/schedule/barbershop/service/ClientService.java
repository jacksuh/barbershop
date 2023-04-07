package com.jackson.schedule.barbershop.service;
import com.jackson.schedule.barbershop.dto.client.ClientDto;
import com.jackson.schedule.barbershop.model.Client;
import com.jackson.schedule.barbershop.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    public Page<Client> getAll(Pageable page) {
        return repository.findAll(page);
    }
    public Client saveClient(ClientDto dto){
        Client cli = new Client();
        cli.setName(dto.getName());

        return  repository.save(cli);
    }
    public Client updateClient(ClientDto dto, Long id) {
        Optional<Client> optional = repository.findById(id);
        Client db = optional.get();
        db.setName(dto.getName());

        return repository.save(db);
    }
    public void deleteClient(Long id) {
        Optional<Client> client = repository.findById(id);
        if (client.isPresent()) {
            repository.deleteById(id);
        }

    }

}
