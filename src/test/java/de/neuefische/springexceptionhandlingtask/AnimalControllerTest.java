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
class AnimalControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Test
    void handleIllegalArgumentException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/animals/{species}","cat"))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(""" 
                    {"errorMessage": "This specie is not available.. Only 'dog' is allowed"}
"""));
    }
}