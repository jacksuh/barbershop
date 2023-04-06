package com.jackson.schedule.barbershop.controller;
import com.jackson.schedule.barbershop.dto.user.UserDetalingDto;
import com.jackson.schedule.barbershop.dto.user.UserDto;
import com.jackson.schedule.barbershop.model.User;
import com.jackson.schedule.barbershop.service.AutenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("usuario")
public class UserController {

    @Autowired
    private AutenticationService service;

    @PostMapping
    public ResponseEntity userRegistration(@RequestBody UserDto dto, UriComponentsBuilder uriBuilder){
        User u = service.saveUser(dto);
        var uri = uriBuilder.path("/barbeiro/{id}").buildAndExpand(u.getLogin()).toUri();
        return ResponseEntity.created(uri).body(new UserDetalingDto(u));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable("id") Long id, @RequestBody UserDto dto){
        User p = service.updateUser(dto,id);

        return p != null?
                ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        service.deleteUser(id);
        return ResponseEntity.ok().build();
    }


}
