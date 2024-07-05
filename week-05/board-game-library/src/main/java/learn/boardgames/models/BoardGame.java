package learn.boardgames.models;

import java.util.Objects;

public class BoardGame {
    private int boardGameId;
    private String title;
    private double rating;
    private int minimumPlayers;
    private int maximumPlayers;
    private boolean checkedOut;
    private BoardGameWeight weight;

    public BoardGame() { }

    public BoardGame(int boardGameId, String title, double rating, int minimumPlayers, int maximumPlayers, boolean checkedOut, BoardGameWeight weight) {
        this.boardGameId = boardGameId;
        this.title = title;
        this.rating = rating;
        this.minimumPlayers = minimumPlayers;
        this.maximumPlayers = maximumPlayers;
        this.checkedOut = checkedOut;
        this.weight = weight;
    }

    public int getBoardGameId() {
        return boardGameId;
    }

    public void setBoardGameId(int boardGameId) {
        this.boardGameId = boardGameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getMinimumPlayers() {
        return minimumPlayers;
    }

    public void setMinimumPlayers(int minimumPlayers) {
        this.minimumPlayers = minimumPlayers;
    }

    public int getMaximumPlayers() {
        return maximumPlayers;
    }

    public void setMaximumPlayers(int maximumPlayers) {
        this.maximumPlayers = maximumPlayers;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public BoardGameWeight getWeight() {
        return weight;
    }

    public void setWeight(BoardGameWeight weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardGame boardGame = (BoardGame) o;
        return boardGameId == boardGame.boardGameId && Double.compare(rating, boardGame.rating) == 0 && minimumPlayers == boardGame.minimumPlayers && maximumPlayers == boardGame.maximumPlayers && checkedOut == boardGame.checkedOut && Objects.equals(title, boardGame.title) && weight == boardGame.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardGameId, title, rating, minimumPlayers, maximumPlayers, checkedOut, weight);
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "boardGameId=" + boardGameId +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", minimumPlayers=" + minimumPlayers +
                ", maximumPlayers=" + maximumPlayers +
                ", checkedOut=" + checkedOut +
                ", weight=" + weight +
                '}';
    }
}
