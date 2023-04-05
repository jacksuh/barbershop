package com.jackson.schedule.barbershop.repository;
import com.jackson.schedule.barbershop.model.Barber;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BarberRepository extends JpaRepository<Barber, Long>{
}
