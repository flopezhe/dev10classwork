package learn.boardgames.domain;

import learn.boardgames.TestHelpers;
import learn.boardgames.data.PublisherRepository;
import learn.boardgames.models.BoardGameWeight;
import learn.boardgames.models.Publisher;
import learn.boardgames.models.PublisherBoardGame;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PublisherServiceTest {

    @MockBean
    PublisherRepository repository;

    @Autowired
    PublisherService service;

    @Test
    void shouldAddValidPublisher() {
        Publisher publisher = TestHelpers.makePublisher(0);

        Publisher expected = TestHelpers.makePublisher(0);
        expected.setPublisherId(1);

        when(repository.add(publisher)).thenReturn(expected);

        Result<Publisher> actual = service.add(publisher);

        assertTrue(actual.isSuccess());
        assertEquals(expected, actual.getPayload());
    }

    @Test
    void shouldNotAddPublisherWithId() {
        Publisher publisher = TestHelpers.makePublisher(1);
        Result<Publisher> actual = service.add(publisher);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("New publisher must not have id set.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddNullPublisher() {
        Result<Publisher> actual = service.add(null);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Publisher cannot be null.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddPublisherWithNullName() {
        Publisher publisher = TestHelpers.makePublisher(0);
        publisher.setName(null);
        Result<Publisher> actual = service.add(publisher);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Name is required.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddPublisherWithEmptyName() {
        Publisher publisher = TestHelpers.makePublisher(0);
        publisher.setName("");
        Result<Publisher> actual = service.add(publisher);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Name is required.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddPublisherWithNullEstablishedDate() {
        Publisher publisher = TestHelpers.makePublisher(0);
        publisher.setEstablishedDate(null);
        Result<Publisher> actual = service.add(publisher);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Established date is required.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddPublisherWithEstablishedDateInTheFuture() {
        Publisher publisher = TestHelpers.makePublisher(0);
        publisher.setEstablishedDate(LocalDate.now().plusDays(1));
        Result<Publisher> actual = service.add(publisher);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Established date cannot be in the future.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddPublisherWithDuplicateName() {
        List<Publisher> existing = List.of(
                TestHelpers.makePublisher(1),
                TestHelpers.makePublisher(2),
                TestHelpers.makePublisher(3)
        );

        Publisher publisher = TestHelpers.makePublisher(1);
        publisher.setPublisherId(0);

        when(repository.findAll()).thenReturn(existing);

        Result<Publisher> actual = service.add(publisher);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Publisher name must be unique.", actual.getMessages().get(0));
    }

    @Test
    void shouldUpdateValidPublisher() {
        Publisher publisher = TestHelpers.makePublisher(1);

        Result<Publisher> expected = new Result<>();

        when(repository.update(publisher)).thenReturn(true);

        Result<Publisher> actual = service.update(publisher);

        assertTrue(actual.isSuccess());
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotUpdatePublisherWIthoutId() {
        Publisher publisher = TestHelpers.makePublisher(0);
        Result<Publisher> actual = service.update(publisher);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Existing publisher must have id set.", actual.getMessages().get(0));
    }

    @Test
    void shouldNotUpdateMissingPublisher() {
        Publisher publisher = TestHelpers.makePublisher(1);
        Result<Publisher> expected = new Result<>();
        expected.addMessage(ResultType.NOT_FOUND, "Publisher id %s was not found.", 1);

        when(repository.update(publisher)).thenReturn(false);

        Result<Publisher> actual = service.update(publisher);

        assertFalse(actual.isSuccess());
        assertEquals(expected, actual);
    }

    @Test
    void shouldDeleteExistingPublisher() {
        Result<Void> expected = new Result<>();

        when(repository.findById(1)).thenReturn(TestHelpers.makePublisher(1));
        when(repository.deleteById(1)).thenReturn(true);

        Result<Void> actual = service.deleteById(1);

        assertTrue(actual.isSuccess());
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotDeleteMissingPublisher() {
        Result<Void> expected = new Result<>();
        expected.addMessage(ResultType.NOT_FOUND, "Publisher id %s not found.", 1);

        when(repository.findById(1)).thenReturn(TestHelpers.makePublisher(1));
        when(repository.deleteById(1)).thenReturn(false);

        Result<Void> actual = service.deleteById(1);

        assertFalse(actual.isSuccess());
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotDeletePublisherWithAssociatedGames() {
        Result<Void> expected = new Result<>();
        expected.addMessage(ResultType.INVALID, "Publisher has associated games and cannot be deleted.");

        Publisher publisher = TestHelpers.makePublisher(1);
        publisher.setBoardGames(List.of(
                new PublisherBoardGame(1, TestHelpers.makeBoardGame(1, BoardGameWeight.MEDIUM), LocalDate.now())
        ));

        when(repository.findById(1)).thenReturn(publisher);

        Result<Void> actual = service.deleteById(1);

        assertFalse(actual.isSuccess());
        assertEquals(expected, actual);
    }
}