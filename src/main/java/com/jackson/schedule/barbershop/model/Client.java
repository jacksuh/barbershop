package com.jackson.schedule.barbershop.model;
import com.jackson.schedule.barbershop.dto.client.ClientDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

@Table(name = "cliente")
@Entity(name = "Cliente")
@EqualsAndHashCode(of = "idCliente")
@NoArgsConstructor
public class Client extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "client")
    private List<Scheduling> scheduling;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Scheduling> getScheduling() {
        return scheduling;
    }

    public void setScheduling(List<Scheduling> scheduling) {
        this.scheduling = scheduling;
    }
}
