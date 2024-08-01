package learn.boardgames.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import learn.boardgames.TestHelpers;
import learn.boardgames.data.PublisherRepository;
import learn.boardgames.models.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PublisherControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    PublisherRepository repository;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void findAll() throws Exception {
        List<Publisher> expected = List.of(
                TestHelpers.makePublisher(1),
                TestHelpers.makePublisher(2),
                TestHelpers.makePublisher(3));

        when(repository.findAll()).thenReturn(expected);

        String expectedJson = objectMapper.writeValueAsString(expected);

        mvc.perform(get("/api/publisher"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}