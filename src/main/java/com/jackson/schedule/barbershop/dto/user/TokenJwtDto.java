package com.jackson.schedule.barbershop.dto.user;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
public class TokenJwtDto {

    private String token;
   public TokenJwtDto(String token){
       this.setToken(token);
   }
}
