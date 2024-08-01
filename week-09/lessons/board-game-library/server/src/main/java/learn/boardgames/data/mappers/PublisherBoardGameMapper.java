package learn.boardgames.data.mappers;

import learn.boardgames.models.BoardGame;
import learn.boardgames.models.PublisherBoardGame;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PublisherBoardGameMapper implements RowMapper<PublisherBoardGame> {
    @Override
    public PublisherBoardGame mapRow(ResultSet rs, int rowNum) throws SQLException {
        PublisherBoardGame publisherBoardGame = new PublisherBoardGame();
        publisherBoardGame.setPublisherBoardGameId(rs.getInt("publisher_board_game_id"));
        publisherBoardGame.setPublishedDate(rs.getDate("published_date").toLocalDate());

        BoardGame game = new BoardGameMapper().mapRow(rs, rowNum);
        publisherBoardGame.setBoardGame(game);

        return publisherBoardGame;
    }
}
