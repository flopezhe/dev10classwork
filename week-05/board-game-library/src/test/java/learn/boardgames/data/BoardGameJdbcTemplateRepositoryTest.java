package learn.boardgames.data;

import learn.boardgames.DataHelper;
import learn.boardgames.TestHelpers;
import learn.boardgames.models.BoardGame;
import learn.boardgames.models.BoardGameWeight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardGameJdbcTemplateRepositoryTest {

    JdbcTemplate jdbcTemplate = DataHelper.getJdbcTemplate();
    BoardGameJdbcTemplateRepository repository = new BoardGameJdbcTemplateRepository(jdbcTemplate);

    @BeforeEach
    void setup(){
        jdbcTemplate.execute("call set_known_good_state();");
    }

    @Test
    void shouldFindAll() throws DataAccessException {
        List<BoardGame> expected = List.of(
                TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM),
                TestHelpers.makeBoardGame(2, BoardGameWeight.LIGHT),
                TestHelpers.makeBoardGame(3, BoardGameWeight.MEDIUM));

        List<BoardGame> actual = repository.findAll();

        assertEquals(expected, actual);

    }


}