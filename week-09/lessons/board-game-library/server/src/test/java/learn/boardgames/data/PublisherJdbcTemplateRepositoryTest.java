package learn.boardgames.data;

import learn.boardgames.TestHelpers;
import learn.boardgames.models.Publisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PublisherJdbcTemplateRepositoryTest {

    @Autowired
    PublisherJdbcTemplateRepository repository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setup() {
        jdbcTemplate.update("call set_known_good_state();");
    }

    @Test
    void shouldFindAll() {
        List<Publisher> expected = List.of(
                TestHelpers.makePublisher(1),
                TestHelpers.makePublisher(2),
                TestHelpers.makePublisher(3));

        assertEquals(expected, repository.findAll());
    }

    @Test
    void shouldFindById() {
        Publisher expected = TestHelpers.makePublisher(1);
        Publisher actual = repository.findById(1);

        assertEquals(expected, actual);
        assertEquals(2, actual.getBoardGames().size());

        assertNull(repository.findById(99));
    }

    @Test
    void shouldAdd() {
        Publisher publisher = new Publisher();
        publisher.setName("Test Publisher3");
        Publisher actual = repository.add(publisher);
        assertNotNull(actual);
        assertEquals(4, actual.getPublisherId());
    }

    @Test
    void shouldUpdate() {
        Publisher publisher = TestHelpers.makePublisher(2);
        publisher.setName("Updated Publisher");
        assertTrue(repository.update(publisher));
        assertEquals(publisher, repository.findById(2));

        publisher = TestHelpers.makePublisher(99);
        assertFalse(repository.update(publisher));
    }

    @Test
    void shouldDelete() {
        assertTrue(repository.deleteById(3));
        assertFalse(repository.deleteById(99));
    }
}