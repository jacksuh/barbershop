package com.jackson.schedule.barbershop.dto.scheduling;
import com.jackson.schedule.barbershop.model.Barber;
import com.jackson.schedule.barbershop.model.Client;

public class SchedulingDto {
    private Client client;
    private String service;
    private Barber barber;

    private double price;
    private String date;
    private String hour;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Barber getBarber() {
        return barber;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public double getPrice() {
        return price;
    }

    public void setCommission(double price) {
        this.price = price;
    }
}
