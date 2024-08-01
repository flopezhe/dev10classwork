package learn.boardgames.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import learn.boardgames.TestHelpers;
import learn.boardgames.data.BoardGameRepository;
import learn.boardgames.models.BoardGame;
import learn.boardgames.models.BoardGameWeight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BoardGameControllerTest {

    @MockBean
    BoardGameRepository repository;

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void findAll() throws Exception {
        List<BoardGame> expected = List.of(
                TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM),
                TestHelpers.makeBoardGame(2, BoardGameWeight.LIGHT),
                TestHelpers.makeBoardGame(3, BoardGameWeight.MEDIUM));

        when(repository.findAll()).thenReturn(expected);

        String expectedJson = objectMapper.writeValueAsString(expected);

        mvc.perform(get("/api/board-game"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void shouldFindByNumberOfPlayers() throws Exception {
        List<BoardGame> expected = List.of(
                TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM),
                TestHelpers.makeBoardGame(2, BoardGameWeight.LIGHT),
                TestHelpers.makeBoardGame(3, BoardGameWeight.MEDIUM));

        when(repository.findByNumberOfPlayers(2)).thenReturn(expected);

        String expectedJson = objectMapper.writeValueAsString(expected);

        mvc.perform(get("/api/board-game/players/2"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void shouldFindByTitle() throws Exception {
        List<BoardGame> expected = List.of(
                TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM),
                TestHelpers.makeBoardGame(2, BoardGameWeight.LIGHT),
                TestHelpers.makeBoardGame(3, BoardGameWeight.MEDIUM));

        when(repository.findByTitle("Test")).thenReturn(expected);

        String expectedJson = objectMapper.writeValueAsString(expected);

        mvc.perform(get("/api/board-game/title?title=Test"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void shouldFindById() throws Exception {
        BoardGame expected = TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM);

        when(repository.findById(1)).thenReturn(expected);

        String expectedJson = objectMapper.writeValueAsString(expected);

        mvc.perform(get("/api/board-game/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void shouldAdd() throws Exception {
        BoardGame boardGame = TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM);
        boardGame.setBoardGameId(0);
        BoardGame expected = TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM);

        when(repository.add(boardGame)).thenReturn(expected);

        String jsonIn = objectMapper.writeValueAsString(boardGame);
        String expectedJson = objectMapper.writeValueAsString(expected);

        var request = post("/api/board-game")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonIn);

        mvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(content().json(expectedJson))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void shouldNotSaveBadGame() throws Exception {
        BoardGame badGame = TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM);

        // Trigger validation
        badGame.setTitle("");

        List<String> errors = List.of("Board game title is required.");

        String badJson = objectMapper.writeValueAsString(badGame);
        String expectedJson = objectMapper.writeValueAsString(errors);

        var request = post("/api/board-game")
                .contentType(MediaType.APPLICATION_JSON)
                .content(badJson);

        mvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectedJson));

    }

    @Test
    void shouldUpdateValidGame() throws Exception {
        BoardGame game = TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM);

        when(repository.update(game)).thenReturn(true);

        String jsonIn = objectMapper.writeValueAsString(game);

        var request = put("/api/board-game/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonIn);

        mvc.perform(request)
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldNotUpdateInvalidGame() throws Exception {
        BoardGame game = TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM);

        // Trigger validation
        game.setTitle("");

        List<String> errors = List.of("Board game title is required.");

        String badJson = objectMapper.writeValueAsString(game);
        String expectedJson = objectMapper.writeValueAsString(errors);

        var request = put("/api/board-game/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(badJson);

        mvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectedJson));
    }

    @Test
    void shouldNotUpdateMissingGame() throws Exception {
        BoardGame game = TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM);
        when(repository.update(game)).thenReturn(false);

        var request = put("/api/board-game/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(game));

        mvc.perform(request)
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldDelete() throws Exception {
        when(repository.deleteById(1)).thenReturn(true);

        mvc.perform(delete("/api/board-game/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldNotDeleteMissingGame() throws Exception {
        when(repository.deleteById(1)).thenReturn(false);

        mvc.perform(delete("/api/board-game/1"))
                .andExpect(status().isNotFound());
    }
}