package learn.boardgames.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Publisher {
    private int publisherId;
    private String name;
    private LocalDate establishedDate;

    private List<PublisherBoardGame> boardGames = new ArrayList<>();

    public Publisher() {}

    public Publisher(int publisherId, String name, LocalDate establishedDate) {
        this.publisherId = publisherId;
        this.name = name;
        this.establishedDate = establishedDate;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(LocalDate establishedDate) {
        this.establishedDate = establishedDate;
    }

    public List<PublisherBoardGame> getBoardGames() {
        return new ArrayList<>(boardGames);
    }

    public void setBoardGames(List<PublisherBoardGame> boardGames) {
        this.boardGames = boardGames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return publisherId == publisher.publisherId && Objects.equals(name, publisher.name) && Objects.equals(establishedDate, publisher.establishedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherId, name, establishedDate);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + publisherId +
                ", name='" + name + '\'' +
                ", establishedDate=" + establishedDate +
                '}';
    }
}
