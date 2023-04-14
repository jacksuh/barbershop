package com.jackson.schedule.barbershop.dto.scheduling;
import com.jackson.schedule.barbershop.model.Scheduling;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class SchedulingDetailingDto {
    private Long id;
    private String client;
    private String service;
    private String Barber;
    private String date;
    private String hour;
    private double price;
    public SchedulingDetailingDto(Scheduling scheduling){
        this.setId(scheduling.getId());
        this.setService(scheduling.getService());
        this.setDate(scheduling.getDate());
        this.setHour(scheduling.getHour());
        this.setPrice(scheduling.getPrice());
        this.setBarber(scheduling.getBarber().getName());
        this.setClient(scheduling.getClient().getName());

    }
}
