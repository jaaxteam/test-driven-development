package com.jaax.testdrivendevelopment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaax.testdrivendevelopment.model.Local;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
@AutoConfigureMockMvc
public class LocalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAllLocals() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/recurso"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(5)));
    }

    @Test
    void registerLocal() throws Exception {
        Local local = Local.builder()
                .id(1L)
                .name("PetShop")
                .floor("Third Floor")
                .build();
        mockMvc.perform(MockMvcRequestBuilders.post("/api/recurso/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(local)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("Recurso creado exitosamente."));
    }

    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }


}
