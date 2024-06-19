package learn.cards;

import learn.cards.Suit;
import learn.cards.Rank;

public class Card {

    // 1. Add a learn.cards.Suit and Rank field to the Card class.
    // 2. Add a constructor that accepts a learn.cards.Suit and Rank and sets the appropriate fields.
    // 3. Add getters for both suit and rank.

    private Suit newSuit;
    private Rank newRank;

    public Card(Rank newRank, Suit newSuit){
        this.newSuit = newSuit;
        this.newRank = newRank;
    }

    public String getNewSuit(){
        switch (newSuit){
            case SPADES:
                return "Spades";
            case HEARTS:
                return "Hearts";
            case DIAMONDS:
                return "Diamonds";
            case CLUBS:
                return "Clubs";
        }
        String suitType = newSuit.name();
        return suitType;
    }

    public String getNewRank(){
        switch (newRank){
            case ACE:
                return "Ace";
            case TWO:
                return "2";
            case THREE:
                return "3";
            case FOUR:
                return "4";
            case FIVE:
                return "5";
            case SIX:
                return "6";
            case SEVEN:
                return "7";
            case EIGHT:
                return "8";
            case NINE:
                return "9";
            case TEN:
                return "10";
            case JACK:
                return "Jack";
            case QUEEN:
                return "Queen";
            case KING:
                return "King";
        }

        String rankType = newRank.name();
        return rankType;
    }

    public String getName() {

        // 4. Complete the getName method.
        // Given a card's suit and rank, getName returns a String in the format:
        // "[rank] of [suit]"
//        switch (newSuit){
//            case SPADES:
//                return "Spades";
//            case HEARTS:
//                return "Hearts";
//            case DIAMONDS:
//                return "Diamonds";
//            case CLUBS:
//                return "Clubs";
//        }

//        switch (newRank){
//            case ACE:
//                return "1";
//            case TWO:
//                return "2";
//            case THREE:
//                return "3";
//            case FOUR:
//                return "4";
//            case FIVE:
//                return "5";
//            case SIX:
//                return "6";
//            case SEVEN:
//                return "7";
//            case EIGHT:
//                return "8";
//            case NINE:
//                return "9";
//            case TEN:
//                return "10";
//            case JACK:
//                return "Jack";
//            case QUEEN:
//                return "Queen";
//            case KING:
//                return "King";
//        }


        return getNewRank() + " of "+ getNewSuit();
        // Examples:
        // Ace of Clubs
        // 5 of Diamonds
        // King of Hearts
        // 9 of Spades

        // Note: it's unlikely you'll be able to use the enum name directly since enum naming conventions
        // don't match the required output.
    }
}
