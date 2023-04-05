package com.jackson.schedule.barbershop.service;
import com.jackson.schedule.barbershop.dto.barber.BarberDto;
import com.jackson.schedule.barbershop.model.Barber;
import com.jackson.schedule.barbershop.repository.BarberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class BarberService {
    @Autowired
    private BarberRepository repository;
    public Page<Barber> getAll(Pageable page) {
        return repository.findAll(page);
    }

    public Barber saveBarber(BarberDto dto) {
        Barber b = new Barber();
        b.setName(dto.getName());

        return repository.save(b);
    }
    public Barber updateBarber(BarberDto dto, Long id) {
        Optional<Barber> optional = repository.findById(id);
        Barber db = optional.get();
        db.setName(dto.getName());

        return repository.save(db);
    }
    public void deleteBarber(Long id) {
        Optional<Barber> barber = repository.findById(id);
        if (barber.isPresent()) {
            repository.deleteById(id);
        }

    }
}
