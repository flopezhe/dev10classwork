package learn.boardgames.data;

import learn.boardgames.models.BoardGame;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.List;

public class BoardGameJdbcTemplateRepository implements BoardGameRepository{

    private final JdbcTemplate jdbcTemplate ;


    public BoardGameJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BoardGame> findAll() throws DataAccessException {
        return List.of();
    }

    @Override
    public List<BoardGame> findByNumberOfPlayers(int numberOfPlayers) throws DataAccessException {
        return List.of();
    }

    @Override
    public List<BoardGame> findByTitle(String title) throws DataAccessException {
        final String sql = """
                select 
                g.board_game_id,
                g.title,
                g.rating,
                
                
                """;
        return jdbcTemplate.query(sql,mapper, title);
    }

    @Override
    public BoardGame findById(int boardGameId) throws DataAccessException {
        return null;
    }

    @Override
    public BoardGame add(BoardGame game) throws DataAccessException {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("")
    }

    @Override
    public boolean update(BoardGame game) throws DataAccessException {
        return false;
    }

    @Override
    public boolean deleteById(int boardGameId) throws DataAccessException {
        return false;
    }
}
