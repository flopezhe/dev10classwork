package learn.Memories.Models;

public class Memory {

    private int id;
    private String from;
    private String content;
    private boolean shareable;

    public Memory(){

    }
    public Memory(int id, String from, String content, boolean shareable){
        this.id = id;
        this.from = from;
        this.content=content;
        this.shareable=shareable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setShareable(boolean shareable) {
        this.shareable = shareable;
    }

    public boolean isShareable(){
        return shareable;
    }
}
