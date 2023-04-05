package com.jackson.schedule.barbershop.model;
import com.jackson.schedule.barbershop.dto.barber.BarberDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

@Table(name ="barbeiro")
@Entity(name = "Barbeiro")
@EqualsAndHashCode(of = "idBarbeiro")
@NoArgsConstructor
public class Barber extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(mappedBy = "barber")
    private List<Scheduling> scheduling;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Scheduling> getScheduling() {
        return scheduling;
    }

    public Barber (BarberDto dto){
        this.setName(dto.getName());
    }

}