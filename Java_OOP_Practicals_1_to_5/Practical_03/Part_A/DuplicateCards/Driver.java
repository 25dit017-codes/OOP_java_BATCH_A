import java.util.HashSet;
import java.util.Set;

public class Driver {
    public static void main(String[] args) {
        Card[] cards = {
            new Card("Ace", "Spades"), new Card("King", "Hearts"),
            new Card("Ace", "Spades"), new Card("10", "Clubs")
        };
        Set<Card> seen = new HashSet<>();
        for (Card card : cards) {
            if (!seen.add(card)) System.out.println("Duplicate card: " + card);
        }
    }
}
