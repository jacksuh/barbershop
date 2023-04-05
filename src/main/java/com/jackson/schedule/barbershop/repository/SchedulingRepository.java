package com.jackson.schedule.barbershop.repository;
import com.jackson.schedule.barbershop.model.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {

}
