package learn.boardgames.data;

import learn.boardgames.data.mappers.BoardGameMapper;
import learn.boardgames.data.mappers.BoardGamePublisherMapper;
import learn.boardgames.models.BoardGame;
import learn.boardgames.models.BoardGamePublisher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Repository
public class BoardGameJdbcTemplateRepository implements BoardGameRepository {

    private final JdbcTemplate jdbcTemplate;
    private final BoardGameMapper boardGameMapper = new BoardGameMapper();
    private final BoardGamePublisherMapper boardGamePublisherMapper = new BoardGamePublisherMapper();

    public BoardGameJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BoardGame> findAll() {
        final String sql = """
                select
                	g.board_game_id,
                    g.title,
                    g.rating,
                    g.minimum_players,
                    g.maximum_players,
                    g.checked_out,
                    w.weight
                from board_game g
                join board_game_weight w on w.board_game_weight_id = g.board_game_weight_id
                order by title;
                """;

        return jdbcTemplate.query(sql, boardGameMapper);
    }

    @Override
    public List<BoardGame> findByNumberOfPlayers(int numberOfPlayers) {
        final String sql = """
                select
                	g.board_game_id,
                    g.title,
                    g.rating,
                    g.minimum_players,
                    g.maximum_players,
                    g.checked_out,
                    w.weight
                from board_game g
                join board_game_weight w on w.board_game_weight_id = g.board_game_weight_id
                where g.minimum_players <= ? and g.maximum_players >= ?
                order by title;
                """;

        return jdbcTemplate.query(sql, boardGameMapper, numberOfPlayers, numberOfPlayers);
    }

    @Override
    public List<BoardGame> findByTitle(String title) {
        final String sql = """
                select
                	g.board_game_id,
                    g.title,
                    g.rating,
                    g.minimum_players,
                    g.maximum_players,
                    g.checked_out,
                    w.weight
                from board_game g
                join board_game_weight w on w.board_game_weight_id = g.board_game_weight_id
                where g.title like ?
                order by title;
                """;

        String titleParam = String.format("%%%s%%", title);

        return jdbcTemplate.query(sql, boardGameMapper, titleParam);
    }

    @Override
    @Transactional
    public BoardGame findById(int boardGameId) {
        final String sql = """
                select
                	g.board_game_id,
                    g.title,
                    g.rating,
                    g.minimum_players,
                    g.maximum_players,
                    g.checked_out,
                    w.weight
                from board_game g
                join board_game_weight w on w.board_game_weight_id = g.board_game_weight_id
                where g.board_game_id = ?;
                """;

        BoardGame game = jdbcTemplate.query(sql, boardGameMapper, boardGameId).stream()
                .findFirst()
                .orElse(null);

        if (game != null) {
            populatePublishers(game);
        }

        return game;
    }

    @Override
    public BoardGame add(BoardGame game) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("board_game")
                .usingGeneratedKeyColumns("board_game_id");

        HashMap<String, Object> args = new HashMap<>();
        args.put("title", game.getTitle());
        args.put("rating", game.getRating());
        args.put("minimum_players", game.getMinimumPlayers());
        args.put("maximum_players", game.getMaximumPlayers());
        args.put("checked_out", game.isCheckedOut() ? 1 : 0);
        args.put("board_game_weight_id", game.getWeight().getId());

        game.setBoardGameId(insert.executeAndReturnKey(args).intValue());
        return game;
    }

    @Override
    public boolean update(BoardGame game) {
        final String sql = """
                update board_game set
                    title = ?,
                    rating = ?,
                    minimum_players = ?,
                    maximum_players = ?,
                    checked_out = ?,
                    board_game_weight_id = ?
                where board_game_id = ?;
                """;
        int rowsAffected = jdbcTemplate.update(sql,
                game.getTitle(),
                game.getRating(),
                game.getMinimumPlayers(),
                game.getMaximumPlayers(),
                game.isCheckedOut() ? 1 : 0,
                game.getWeight().getId(),
                game.getBoardGameId());

        return rowsAffected > 0;
    }

    @Override
    public boolean deleteById(int boardGameId) {
        jdbcTemplate.update("delete from publisher_board_game where board_game_id = ?;", boardGameId);
        return jdbcTemplate.update("delete from board_game where board_game_id = ?;", boardGameId) > 0;
    }

    private void populatePublishers(BoardGame boardGame) {
        final String sql = """
                select
                    pb.publisher_board_game_id,
                    p.publisher_id,
                    p.name,
                    p.established_date,
                    pb.published_date
                from publisher_board_game pb
                inner join publisher p on p.publisher_id = pb.publisher_id
                where pb.board_game_id = ?;
                """;

        List<BoardGamePublisher> publishers = jdbcTemplate.query(sql, boardGamePublisherMapper, boardGame.getBoardGameId());

        boardGame.setPublishers(publishers);
    }
}
