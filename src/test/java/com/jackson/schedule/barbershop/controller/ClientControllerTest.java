package com.jackson.schedule.barbershop.controller;
import com.jackson.schedule.barbershop.dto.client.ClientDetailingDto;
import com.jackson.schedule.barbershop.dto.client.ClientDto;
import com.jackson.schedule.barbershop.model.Client;
import com.jackson.schedule.barbershop.repository.ClientRepository;
import com.jackson.schedule.barbershop.service.ClientService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@ActiveProfiles("test")
class ClientControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<ClientDto> clientDtoJson;

    @Autowired
    private JacksonTester<ClientDetailingDto> clientDetailingDtoJson;

   @Mock
   private  ClientService service;

   @Mock
   private ClientRepository repository;

    @Test
    @DisplayName("Test erro 400 informações invalidas.")
    @WithMockUser
    void client_cenario1() throws Exception {
       var response = mvc.perform(post("/cliente"))
                .andReturn().getResponse();

       assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }


    @Test
    @DisplayName("Test http GET 200")
    @WithMockUser
    void client_cenario2() throws Exception {

        var response = mvc
                .perform(get("/cliente"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getStatus()).isNotZero();
    }


    @Test
    @DisplayName("Test Delete")
    @WithMockUser
    void client_cenario3() throws Exception {

        var response = mvc
                .perform(delete("/cliente/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    }

    @Test
    @DisplayName("Test  201")
    @WithMockUser
    void client_cenario4() throws Exception {

        String json = "{\"name\":\"Jackson\"}";

        var response = mvc.perform(
                        post("/cliente")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());

    }



}