package learn.boardgames.data;

import learn.boardgames.data.mappers.PublisherBoardGameMapper;
import learn.boardgames.data.mappers.PublisherMapper;
import learn.boardgames.models.Publisher;
import learn.boardgames.models.PublisherBoardGame;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Repository
public class PublisherJdbcTemplateRepository implements PublisherRepository {
    private final JdbcTemplate jdbcTemplate;

    public PublisherJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Publisher> findAll() {
        final String sql = """
            select 
                publisher_id, 
                `name`,
                established_date
            from publisher;
            """;
        return jdbcTemplate.query(sql, new PublisherMapper());
    }

    @Override
    @Transactional
    public Publisher findById(int publisherId) {
        final String sql = """
            select 
                publisher_id, 
                `name`,
                established_date
            from publisher 
            where publisher_id = ?;
            """;
        Publisher publisher = jdbcTemplate.query(sql, new PublisherMapper(), publisherId).stream()
                .findFirst().orElse(null);

        if (publisher != null) {
            addBoardGames(publisher);
        }

        return publisher;
    }

    @Override
    public Publisher add(Publisher publisher) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);

        insert.withTableName("publisher")
                .usingGeneratedKeyColumns("publisher_id");

        HashMap<String, Object> args = new HashMap<>();
        args.put("name", publisher.getName());
        args.put("established_date", publisher.getEstablishedDate());

        publisher.setPublisherId(insert.executeAndReturnKey(args).intValue());
        return publisher;
    }

    @Override
    public boolean update(Publisher publisher) {
        final String sql = """
        update publisher set
            `name` = ?,
            established_date = ?
        where publisher_id = ?;
        """;
        return jdbcTemplate.update(sql,
                publisher.getName(),
                publisher.getEstablishedDate(),
                publisher.getPublisherId()) > 0;
    }

    @Override
    public boolean deleteById(int publisherId) {
        final String sql = "delete from publisher where publisher_id = ?";
        return jdbcTemplate.update(sql, publisherId) > 0;
    }

    private void addBoardGames(Publisher publisher) {
        final String sql = """
                select
                    pg.publisher_board_game_id,
                    pg.published_date,
                    g.board_game_id,
                    g.title,
                    g.rating,
                    g.minimum_players,
                    g.maximum_players,
                    g.checked_out,
                    w.weight
                from publisher_board_game pg
                join board_game g on pg.board_game_id = g.board_game_id
                join board_game_weight w on g.board_game_weight_id = w.board_game_weight_id
                where pg.publisher_id = ?;
                """;
        List<PublisherBoardGame> games = jdbcTemplate.query(sql,
                new PublisherBoardGameMapper(), publisher.getPublisherId());

        publisher.setBoardGames(games);
    }
}
