package com.jackson.schedule.barbershop.service;
import com.jackson.schedule.barbershop.dto.barber.BarberDto;
import com.jackson.schedule.barbershop.dto.user.UserDto;
import com.jackson.schedule.barbershop.model.Barber;
import com.jackson.schedule.barbershop.model.User;
import com.jackson.schedule.barbershop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticationService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }


    public User saveUser(UserDto dto) {
        User u = new User();
        u.setLogin(dto.getLogin());
        u.setPassword(dto.getPassword());

        return repository.save(u);
    }

    public User updateUser(UserDto dto, Long id) {
        Optional<User> optional = repository.findById(id);
        User db = optional.get();
        db.setLogin(dto.getLogin());
        db.setPassword(dto.getPassword());

        return repository.save(db);
    }
    public void deleteUser(Long id) {
        Optional<User> barber = repository.findById(id);
        if (barber.isPresent()) {
            repository.deleteById(id);
        }

    }
}
