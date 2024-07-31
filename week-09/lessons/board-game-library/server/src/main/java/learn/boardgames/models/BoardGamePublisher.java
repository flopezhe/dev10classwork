package learn.boardgames.models;

import java.time.LocalDate;
import java.util.Objects;

public class BoardGamePublisher {
    private int publisherBoardGameId;
    public Publisher publisher;
    public LocalDate publishedDate;

    public BoardGamePublisher() {}

    public BoardGamePublisher(int publisherBoardGameId, Publisher publisher, LocalDate publishedDate) {
        this.publisherBoardGameId = publisherBoardGameId;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
    }

    public int getPublisherBoardGameId() {
        return publisherBoardGameId;
    }

    public void setPublisherBoardGameId(int publisherBoardGameId) {
        this.publisherBoardGameId = publisherBoardGameId;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardGamePublisher that = (BoardGamePublisher) o;
        return publisherBoardGameId == that.publisherBoardGameId && Objects.equals(publisher, that.publisher) && Objects.equals(publishedDate, that.publishedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherBoardGameId, publisher, publishedDate);
    }
}
