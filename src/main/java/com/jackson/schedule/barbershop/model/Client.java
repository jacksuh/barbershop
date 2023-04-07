package com.jackson.schedule.barbershop.model;
import com.jackson.schedule.barbershop.dto.client.ClientDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
@Table(name = "cliente")
@Entity(name = "Cliente")
@EqualsAndHashCode(of = "idCliente")
@Setter
@Getter
@NoArgsConstructor
public class Client extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "client")
    private List<Scheduling> scheduling;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
         this.name = name;
    }

    public Client(ClientDto dto){
        this.setName(dto.getName());
    }


}
