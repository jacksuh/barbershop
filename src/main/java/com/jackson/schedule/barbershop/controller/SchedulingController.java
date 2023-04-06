package com.jackson.schedule.barbershop.controller;
import com.jackson.schedule.barbershop.dto.scheduling.SchedulingDetailingDto;
import com.jackson.schedule.barbershop.dto.scheduling.SchedulingDto;
import com.jackson.schedule.barbershop.model.Scheduling;
import com.jackson.schedule.barbershop.service.SchedulingService;
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
@RequestMapping("agenda")
public class SchedulingController {
    @Autowired
    private SchedulingService service;

    @PostMapping
    @CacheEvict(value = "scheduling", allEntries = true)
    public ResponseEntity Schedulingsave(@RequestBody SchedulingDto dto, UriComponentsBuilder uriBuilder){
        Scheduling s = service.saveScheduling(dto);
        var uri = uriBuilder.path("/agenda/{id}").buildAndExpand(s.getBarber()).toUri();
        return ResponseEntity.created(uri).body(new SchedulingDetailingDto(s));
    }

    @GetMapping
    @Cacheable(value = "scheduling")
    public ResponseEntity<Page<Scheduling>> getAllScheduling(@PageableDefault(sort = "id", page = 0, size = 10) Pageable page){
        Page<Scheduling> listBarber = service.getAll(page);
        return ResponseEntity.ok(listBarber);
    }

    @PutMapping("/{id}")
    @CacheEvict(value = "scheduling", allEntries = true)
    public ResponseEntity updatedScheduling(@PathVariable("id") Long id, @RequestBody SchedulingDto dto){
        Scheduling p = service.updateScheduling(dto,id);

        return p != null?
                ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    @CacheEvict(value = "scheduling", allEntries = true)
    public ResponseEntity deleteClientScheduling(@PathVariable Long id){
        service.deleteScheduling(id);
        return ResponseEntity.ok().build();
    }
}
