package de.neuefische.springexceptionhandlingtask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GlobalExceptionHandlerTest {


    @Autowired
    MockMvc mockMvc;
    @Test
    void handleNoSuchElementException_In_GlobalExceptionHandlerClass_NoCarsFound() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/cars"))
            .andExpect(status().isNotFound())
            .andExpect(content().json(""" 
                    {"errorMessage": "Oops, something went wrong here..No Cars found"}
"""));
    }

    @Test
    void handleNoSuchElementException_In_GlobalExceptionHandlerClass_NoAnimalsFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/animals"))
                .andExpect(status().isNotFound())
                .andExpect(content().json(""" 
                    {"errorMessage": "Oops, something went wrong here..No Animals found"}
"""));
    }


}

