package com.jackson.schedule.barbershop.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jackson.schedule.barbershop.dto.barber.BarberDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Table(name ="barbeiro")
@Entity(name = "Barbeiro")
@EqualsAndHashCode(of = "idBarbeiro")
@Setter
@Getter
@NoArgsConstructor
public class Barber extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "barber")
    @JsonBackReference
    private List<Scheduling> scheduling;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Barber (BarberDto dto){
        this.setName(dto.getName());
    }

}