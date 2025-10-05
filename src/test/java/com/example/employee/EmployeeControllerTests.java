package com.example.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(classes = EmployeeManagementApplication.class)
@AutoConfigureMockMvc
class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        // Spring context loads properly
    }

    @Test
    void shouldReturnEmployeesList() throws Exception {
        mockMvc.perform(get("/employees").accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());
    }

    @Test
    void shouldReturnEmployeeById() throws Exception {
        mockMvc.perform(get("/employees/1").accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id").value(1));
    }
}
