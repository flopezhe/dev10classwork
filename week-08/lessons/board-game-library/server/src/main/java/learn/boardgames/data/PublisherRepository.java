package learn.boardgames.data;

import learn.boardgames.models.Publisher;

import java.util.List;

public interface PublisherRepository {
    List<Publisher> findAll();
    Publisher findById(int publisherId);
    Publisher add(Publisher publisher);
    boolean update(Publisher publisher);
    boolean deleteById(int publisherId);
}
