package com.jackson.schedule.barbershop.model;
import com.jackson.schedule.barbershop.dto.ClientDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "cliente")
@Entity(name = "Cliente")
@EqualsAndHashCode(of = "idCliente")
@NoArgsConstructor
public class Client extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public Client(ClientDto dto){
        this.setName(dto.getName());
    }
}
