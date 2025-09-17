import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public int size() {
        return cards.size();
    }

    public Card draw() {
        if (cards.isEmpty()) return null;
        return cards.remove(0);
    }

    public List<Card> draw(int count) {
        List<Card> drawnCards = new ArrayList<>();
        if (count > 0) {
            for (int i = 0; i < count && !cards.isEmpty(); i++) {
                drawnCards.add(draw());
            }
        }
        return drawnCards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> getCardsByRank(Rank rank) {
        List<Card> result = new ArrayList<>();
        for (Card card : cards) {
            if (card.getRank() == rank) {
                result.add(card);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
