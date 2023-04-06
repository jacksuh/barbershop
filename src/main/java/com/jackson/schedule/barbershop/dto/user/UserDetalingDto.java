package com.jackson.schedule.barbershop.dto.user;

import com.jackson.schedule.barbershop.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDetalingDto {

    private Long id;
    private String login;
    private String password;

    public UserDetalingDto(User user){
        this.setId(user.getId());
        this.setLogin(user.getLogin());
    }
}
