package com.jackson.schedule.barbershop.dto.scheduling;
import com.jackson.schedule.barbershop.model.Barber;
import com.jackson.schedule.barbershop.model.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SchedulingDto {

    private Client client;

    private String service;

    private Barber barber;

    private double price;

    private String date;

    private String hour;

}
