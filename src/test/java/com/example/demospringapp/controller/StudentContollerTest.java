package com.example.demospringapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class StudentContollerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testGetStudents_withUnauthorizedUser_thenThrow401Error() throws Exception {
        this.mockMvc.perform(get("/sudents"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }
}