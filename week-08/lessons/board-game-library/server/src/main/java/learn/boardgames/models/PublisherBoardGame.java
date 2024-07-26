package learn.boardgames.models;

import java.time.LocalDate;

public class PublisherBoardGame {
    private int publisherBoardGameId;
    private BoardGame boardGame;
    private LocalDate publishedDate;

    public PublisherBoardGame() {}

    public PublisherBoardGame(int publisherBoardGameId, BoardGame boardGame, LocalDate publishedDate) {
        this.publisherBoardGameId = publisherBoardGameId;
        this.boardGame = boardGame;
        this.publishedDate = publishedDate;
    }

    public int getPublisherBoardGameId() {
        return publisherBoardGameId;
    }

    public void setPublisherBoardGameId(int publisherBoardGameId) {
        this.publisherBoardGameId = publisherBoardGameId;
    }

    public BoardGame getBoardGame() {
        return boardGame;
    }

    public void setBoardGame(BoardGame boardGame) {
        this.boardGame = boardGame;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
}
