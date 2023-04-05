package com.jackson.schedule.barbershop.model;
import jakarta.persistence.MappedSuperclass;
@MappedSuperclass
public abstract class Person {
    protected String name;

    public abstract String getName();

    public abstract void setName(String name);
}
