public class Musician {

    String name;
     int rating;

    /**
     * @param name   The name of the musician.
     * @param rating A number representing how much a musician is loved relative to other musicians.
     */
    public Musician(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;

    }

    public void setName(String newName){
        this.name= newName;
    }

    public void setRating(int newRating){
        this.rating=newRating;
    }

    public int getRating(){
        return rating;
    }

}
