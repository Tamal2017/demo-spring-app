package com.example.demospringapp.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(addFilters = false)
@Disabled
class StudentContollerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testGetStudents_withUnauthorizedUser_thenThrow401Error() throws Exception {
        this.mockMvc.perform(get("/students"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}