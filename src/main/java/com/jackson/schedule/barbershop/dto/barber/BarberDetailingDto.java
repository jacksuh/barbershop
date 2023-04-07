package com.jackson.schedule.barbershop.dto.barber;

import com.jackson.schedule.barbershop.model.Barber;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class BarberDetailingDto {
    private String name;
    public BarberDetailingDto(Barber barber){
        this.name = barber.getName();

    }

}
