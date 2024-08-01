package learn.boardgames.data.mappers;

import learn.boardgames.models.BoardGamePublisher;
import learn.boardgames.models.Publisher;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardGamePublisherMapper implements RowMapper<BoardGamePublisher> {
    @Override
    public BoardGamePublisher mapRow(ResultSet rs, int rowNum) throws SQLException {
        Publisher p = new Publisher(
                rs.getInt("publisher_id"),
                rs.getString("name"),
                rs.getDate("established_date").toLocalDate());

        BoardGamePublisher bgp = new BoardGamePublisher();
        bgp.setPublisherBoardGameId(rs.getInt("publisher_board_game_id"));
        bgp.setPublishedDate(rs.getDate("published_date").toLocalDate());
        bgp.setPublisher(p);

        return bgp;    }
}
