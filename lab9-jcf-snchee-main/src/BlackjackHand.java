import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackjackHand {
    private static final Map<Rank, Integer> CARD_VALUES = new HashMap<>();
    private static final int MAX_VALUE = 21;

    static {
        for (Rank rank : Rank.values()) {
            if (rank == Rank.JACK || rank == Rank.QUEEN || rank == Rank.KING) {
                CARD_VALUES.put(rank, 10);
            } else if (rank == Rank.ACE) {
                CARD_VALUES.put(rank, 11);
            } else {
                CARD_VALUES.put(rank, Integer.parseInt(rank.toString()));
            }
        }
    }

    private final List<Card> cards = new ArrayList<>();
    private int value = 0;
    private int numAcesAs11 = 0;

    public BlackjackHand(Card c1, Card c2) {
        addCard(c1);
        addCard(c2);
    }

    public void addCard(Card card){
    	if(card == null) {
    		throw new NullPointerException();
    	}
    	if (getValue() < MAX_VALUE) {
    		cards.add(card);
    		int cardValue = CARD_VALUES.get(card.getRank());
    		value += cardValue;
    	}
    	if (card.getRank() == Rank.ACE) {
    		numAcesAs11++; 
    	}
    	while (value > MAX_VALUE && numAcesAs11 > 0) {
    		value -= 10;
    		numAcesAs11--;
    	}
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    public int size() {
        return cards.size();
    }

    public static Map<Rank, Integer> getCardValues() {
        return new HashMap<>(CARD_VALUES);
    }

    public int getValue() {
    	while(value > MAX_VALUE && numAcesAs11 > 0) {
    		value -= CARD_VALUES.get(Rank.ACE);
    		value += 1;
    		numAcesAs11 --;
    		}
        return value;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}