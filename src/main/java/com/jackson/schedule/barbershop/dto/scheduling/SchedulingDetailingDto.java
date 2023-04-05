package com.jackson.schedule.barbershop.dto.scheduling;
import com.jackson.schedule.barbershop.model.Scheduling;

public class SchedulingDetailingDto {

    private Long id;
    private String client;
    private String service;
    private String Barber;
    private String date;
    private String hour;

    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getBarber() {
        return Barber;
    }

    public void setBarber(String barber) {
        Barber = barber;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public SchedulingDetailingDto(Scheduling scheduling){
        this.setId(scheduling.getId());
        this.setService(scheduling.getService());
        this.setDate(scheduling.getDate());
        this.setHour(scheduling.getHour());
        this.setPrice(scheduling.getPrice());
        this.setBarber(scheduling.getBarber().getName());
        this.setBarber(scheduling.getBarber().getName());
        this.setClient(scheduling.getClient().getName());

    }
}
