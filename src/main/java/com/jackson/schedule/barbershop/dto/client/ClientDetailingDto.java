package com.jackson.schedule.barbershop.dto.client;
import com.jackson.schedule.barbershop.model.Client;

public class ClientDetailingDto {

    private Long id;

    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientDetailingDto(Client client){
        this.id = client.getId();
        this.name = client.getName();


    }

}
