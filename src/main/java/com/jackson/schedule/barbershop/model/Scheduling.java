package com.jackson.schedule.barbershop.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jackson.schedule.barbershop.dto.scheduling.SchedulingDto;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
@Table(name = "agenda")
@Entity(name = "Agenda")
@NoArgsConstructor
public class Scheduling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Client client;
    @JsonIgnore
    @ManyToOne
    private Barber barber;

    private double price;
    private String service;
    private String date;
    private String hour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Barber getBarber() {
        return barber;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Scheduling(SchedulingDto dto){
        this.setService(dto.getService());
        this.setBarber(dto.getBarber());
        this.setClient(dto.getClient());
        this.setDate(dto.getDate());
        this.setHour(dto.getHour());
        this.setPrice(dto.getPrice());
    }
}
