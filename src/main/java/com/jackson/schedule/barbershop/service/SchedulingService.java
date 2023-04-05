package com.jackson.schedule.barbershop.service;
import com.jackson.schedule.barbershop.dto.scheduling.SchedulingDto;
import com.jackson.schedule.barbershop.model.Barber;
import com.jackson.schedule.barbershop.model.Client;
import com.jackson.schedule.barbershop.model.Scheduling;
import com.jackson.schedule.barbershop.repository.BarberRepository;
import com.jackson.schedule.barbershop.repository.ClientRepository;
import com.jackson.schedule.barbershop.repository.SchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;
@Service
public class SchedulingService {
    @Autowired
    private SchedulingRepository repository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private BarberRepository barberRepository;
    public Page<Scheduling> getAll(Pageable page) {
        return repository.findAll(page);
    }
    public Scheduling saveScheduling(SchedulingDto dto){
        Long idClient = dto.getClient().getId();
            Client client = clientRepository.findById(idClient)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client not found"));
        Long idBarber = dto.getBarber().getId();
            Barber barber = barberRepository.findById(idBarber)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client not found"));

            Scheduling s = new Scheduling();
            s.setBarber(dto.getBarber());
            s.setService(dto.getService());
            s.setBarber(barber);
            s.setClient(client);
            s.setDate(dto.getDate());
            s.setHour(dto.getHour());
            s.setPrice(dto.getPrice());
            return  repository.save(s);

    }
    public Scheduling updateScheduling(SchedulingDto dto, Long id) {
        Optional<Scheduling> optional = repository.findById(id);
        Scheduling db = optional.get();
        db.setClient(dto.getClient());
        db.setBarber(dto.getBarber());
        db.setDate(dto.getDate());
        db.setHour(dto.getHour());
        db.setBarber(dto.getBarber());
        db.setPrice(dto.getPrice());
        db.setService(dto.getService());

        return repository.save(db);
    }
    public void deleteScheduling(Long id) {
        Optional<Scheduling> scheduling = repository.findById(id);
        if (scheduling.isPresent()) {
            repository.deleteById(id);
        }
    }

    }
