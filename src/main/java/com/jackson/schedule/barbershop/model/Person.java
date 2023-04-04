package com.jackson.schedule.barbershop.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
