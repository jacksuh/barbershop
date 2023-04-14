package com.jackson.schedule.barbershop.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jackson.schedule.barbershop.dto.scheduling.SchedulingDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "agenda")
@Entity(name = "Agenda")
@Setter
@Getter
@NoArgsConstructor
public class Scheduling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Barber barber;
    private double price;
    private String service;
    private String date;
    private String hour;

    public Scheduling(SchedulingDto dto){
        this.setService(dto.getService());
        this.setBarber(dto.getBarber());
        this.setClient(dto.getClient());
        this.setDate(dto.getDate());
        this.setHour(dto.getHour());
        this.setPrice(dto.getPrice());
    }
}
