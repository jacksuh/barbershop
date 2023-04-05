package com.jackson.schedule.barbershop.dto.barber;

import com.jackson.schedule.barbershop.model.Barber;

public class BarberDetailingDto {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BarberDetailingDto(Barber barber){
        this.setName(barber.getName());

    }

}
