package com.jackson.schedule.barbershop.controller;

import com.jackson.schedule.barbershop.dto.user.TokenJwtDto;
import com.jackson.schedule.barbershop.dto.user.UserAuthentication;
import com.jackson.schedule.barbershop.infra.springsecurity.TokenService;
import com.jackson.schedule.barbershop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody UserAuthentication dto){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getPassword());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenJwtDto(tokenJWT));
    }
}
