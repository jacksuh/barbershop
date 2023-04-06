package com.jackson.schedule.barbershop.controller;
import com.jackson.schedule.barbershop.dto.barber.BarberDetailingDto;
import com.jackson.schedule.barbershop.dto.barber.BarberDto;
import com.jackson.schedule.barbershop.model.Barber;
import com.jackson.schedule.barbershop.service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
@RestController
@RequestMapping("barbeiro")
public class BarberController {
    @Autowired
    private BarberService service;
    @PostMapping
    @CacheEvict(value = "barber", allEntries = true)
    public ResponseEntity barberRegistration(@RequestBody BarberDto dto, UriComponentsBuilder uriBuilder){
        Barber b = service.saveBarber(dto);
        var uri = uriBuilder.path("/barbeiro/{id}").buildAndExpand(b.getName()).toUri();
        return ResponseEntity.created(uri).body(new BarberDetailingDto(b));
    }
    @GetMapping
    @Cacheable(value = "barber")
    public ResponseEntity<Page<Barber>> getAllBarber(@PageableDefault(sort = "id", page = 0, size = 10) Pageable page){
        Page<Barber> listBarber = service.getAll(page);
        return ResponseEntity.ok(listBarber);
    }
    @PutMapping("/{id}")
    @CacheEvict(value = "barber", allEntries = true)
    public ResponseEntity updateBarber(@PathVariable("id") Long id, @RequestBody BarberDto dto){
        Barber p = service.updateBarber(dto,id);

        return p != null?
                ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    @CacheEvict(value = "barber", allEntries = true)
    public ResponseEntity deleteBarber(@PathVariable Long id){
        service.deleteBarber(id);
        return ResponseEntity.ok().build();
    }
}
