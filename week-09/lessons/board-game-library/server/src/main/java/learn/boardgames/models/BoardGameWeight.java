package learn.boardgames.models;

public enum BoardGameWeight {
    CASUAL(1),
    LIGHT(2),
    MEDIUM(3),
    HEAVY(4);

    private final int id;

    BoardGameWeight(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
