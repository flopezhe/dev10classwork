package learn.boardgames.domain;

import learn.boardgames.data.PublisherRepository;
import learn.boardgames.models.Publisher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PublisherService {

    private final PublisherRepository repository;

    public PublisherService(PublisherRepository repository) {
        this.repository = repository;
    }

    public List<Publisher> findAll() {
        return repository.findAll();
    }

    public Publisher findById(int publisherId) {
        return repository.findById(publisherId);
    }

    public Result<Publisher> add(Publisher publisher) {
        Result<Publisher> result = validate(publisher);

        if (!result.isSuccess()) {
            return result;
        }

        if (publisher.getPublisherId() != 0) {
            result.addMessage("New publisher must not have id set.");
            return result;
        }

        publisher = repository.add(publisher);
        result.setPayload(publisher);
        return result;
    }

    public Result<Publisher> update(Publisher publisher) {
        Result<Publisher> result = validate(publisher);

        if (!result.isSuccess()) {
            return result;
        }

        if (publisher.getPublisherId() <= 0) {
            result.addMessage("Existing publisher must have id set.");
            return result;
        }

        if (!repository.update(publisher)) {
            result.addMessage(ResultType.NOT_FOUND,
                    "Publisher id %s was not found.", publisher.getPublisherId());
        }

        return result;
    }

    public Result<Void> deleteById(int publisherId) {
        Result<Void> result = new Result<>();

        Publisher publisher = findById(publisherId);
        if (!publisher.getBoardGames().isEmpty()) {
            result.addMessage(ResultType.INVALID,
                    "Publisher has associated games and cannot be deleted.", publisherId);
            return result;
        }

        if (!repository.deleteById(publisherId)) {
            result.addMessage(ResultType.NOT_FOUND,
                    "Publisher id %s not found.", publisherId);
        }

        return result;
    }

    private Result<Publisher> validate(Publisher publisher) {
        Result<Publisher> result = new Result<>();

        if (publisher == null) {
            result.addMessage("Publisher cannot be null.");
            return result;
        }

        if (publisher.getName() == null || publisher.getName().isBlank()) {
            result.addMessage("Name is required.");
        }

        if (publisher.getEstablishedDate() == null) {
            result.addMessage("Established date is required.");
            return result;
        }

        if (publisher.getEstablishedDate().isAfter(LocalDate.now())) {
            result.addMessage("Established date cannot be in the future.");
            return result;
        }

        if (findAll().stream().anyMatch(p -> isDuplicate(p, publisher))) {
            result.addMessage("Publisher name must be unique.");
        }

        return result;
    }

    private boolean isDuplicate(Publisher a, Publisher b) {
        return a.getPublisherId() != b.getPublisherId()
                && a.getName().equalsIgnoreCase(b.getName());
    }
}
