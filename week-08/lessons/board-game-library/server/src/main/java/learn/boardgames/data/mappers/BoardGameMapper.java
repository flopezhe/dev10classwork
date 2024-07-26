package learn.boardgames.data.mappers;

import learn.boardgames.models.BoardGame;
import learn.boardgames.models.BoardGameWeight;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardGameMapper implements RowMapper<BoardGame> {
    @Override
    public BoardGame mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BoardGame(
                rs.getInt("board_game_id"),
                rs.getString("title"),
                rs.getDouble("rating"),
                rs.getInt("minimum_players"),
                rs.getInt("maximum_players"),
                rs.getBoolean("checked_out"),
                BoardGameWeight.valueOf(rs.getString("weight"))
        );
    }
}
