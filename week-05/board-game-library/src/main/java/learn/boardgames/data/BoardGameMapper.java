package learn.boardgames.data;

import learn.boardgames.models.BoardGame;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardGameMapper implements RowMapper<BoardGame> {
    @Override
    public BoardGame mapRow(ResultSet rs, int rowNum) throws SQLException {
        BoardGame boardGame = new BoardGame();

        boardGame.setBoardGameId(rs.getInt("board_game_id"));
        boardGame.setTitle(rs.getString("title"));
        boardGame.setRating(rs.getDouble("rating"));
        boardGame.setMinimumPlayers(rs.getInt("minimum_players"));
        boardGame.setMaximumPlayers(rs.getInt("maximum_players"));
        boardGame.setCheckedOut(rs.getBoolean("checked_out"));
        boardGame.setWeight();
        return boardGame;


    }


}
