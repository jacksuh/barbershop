package com.jackson.schedule.barbershop.repository;
import com.jackson.schedule.barbershop.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
