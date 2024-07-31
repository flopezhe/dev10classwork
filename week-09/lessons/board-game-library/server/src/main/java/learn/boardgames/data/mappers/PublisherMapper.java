package learn.boardgames.data.mappers;

import learn.boardgames.models.Publisher;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PublisherMapper implements RowMapper<Publisher> {
    @Override
    public Publisher mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setPublisherId(resultSet.getInt("publisher_id"));
        publisher.setName(resultSet.getString("name"));
        publisher.setEstablishedDate(resultSet.getDate("established_date").toLocalDate());
        return publisher;
    }
}
