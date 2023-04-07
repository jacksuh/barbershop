package com.jackson.schedule.barbershop.dto.client;
import com.jackson.schedule.barbershop.model.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
public class ClientDetailingDto {
    private Long id;
    private String name;
    public ClientDetailingDto(Client client){
        this.id = client.getId();
        this.name = client.getName();
    }

}
