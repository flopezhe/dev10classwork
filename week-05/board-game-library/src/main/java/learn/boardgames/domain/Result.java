package learn.boardgames.domain;

import java.util.ArrayList;
import java.util.List;

public class Result<T> {
    private boolean success = true;
    private final ArrayList<String> messages = new ArrayList<>();
    private T payload;

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public T getPayload() {
        return payload;
    }

    public boolean isSuccess() {
        return success;
    }

    public void addMessage(String message) {
        success = false;
        messages.add(message);
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }
}
