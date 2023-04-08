package com.jackson.schedule.barbershop.controller;
import com.jackson.schedule.barbershop.dto.client.ClientDetailingDto;
import com.jackson.schedule.barbershop.dto.client.ClientDto;
import com.jackson.schedule.barbershop.model.Client;
import com.jackson.schedule.barbershop.service.ClientService;
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
@RequestMapping("cliente")
public class ClientController {
    @Autowired
    ClientService service;
    @PostMapping
    @CacheEvict(value = "client", allEntries = true)
    public ResponseEntity clientRegistration(@RequestBody ClientDto dto, UriComponentsBuilder uriBuilder){
        Client c = service.saveClient(dto);
        var uri = uriBuilder.path("/cliente/{id}").buildAndExpand(c.getName()).toUri();
        return ResponseEntity.created(uri).body(new ClientDetailingDto(c));
    }
    @GetMapping
    @Cacheable(value = "client")
    public ResponseEntity<Page<Client>> getAllClient(@PageableDefault(sort = "id", page = 0, size = 10) Pageable page){
        Page<Client> listClient = service.getAll(page);
        return ResponseEntity.ok(listClient);
    }
    @PutMapping("/{id}")
    @CacheEvict(value = "client", allEntries = true)
    public ResponseEntity updateClient(@PathVariable("id") Long id, @RequestBody ClientDto dto){
        Client p = service.updateClient(dto,id);

        return p != null?
                ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    @CacheEvict(value = "client", allEntries = true)
    public ResponseEntity deleteClient(@PathVariable Long id){
        service.deleteClient(id);
        return ResponseEntity.ok().build();
    }

}
