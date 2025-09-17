import java.util.*;

public class CribbageHand {
    public static final Map<Rank, Integer> CARD_VALUES;
    public final List<Card> cards;

    static {
        Map<Rank, Integer> values = new EnumMap<>(Rank.class);
        values.put(Rank.ACE, 1);
        values.put(Rank.TWO, 2);
        values.put(Rank.THREE, 3);
        values.put(Rank.FOUR, 4);
        values.put(Rank.FIVE, 5);
        values.put(Rank.SIX, 6);
        values.put(Rank.SEVEN, 7);
        values.put(Rank.EIGHT, 8);
        values.put(Rank.NINE, 9);
        values.put(Rank.TEN, 10);
        values.put(Rank.JACK, 10);
        values.put(Rank.QUEEN, 10);
        values.put(Rank.KING, 10);
        CARD_VALUES = Collections.unmodifiableMap(values);
    }

    public CribbageHand(Card c1, Card c2, Card c3, Card c4) {
        if (c1 == null || c2 == null || c3 == null || c4 == null) throw new NullPointerException("Cards cannot be null");
        this.cards = List.of(c1, c2, c3, c4);
    }

    public static Set<Set<Card>> powerSet(List<Card> cards) {
        Set<Set<Card>> result = new HashSet<>();
        result.add(new HashSet<>());
        for (Card card : cards) {
            Set<Set<Card>> newSubsets = new HashSet<>();
            for (Set<Card> subset : result) {
                Set<Card> newSubset = new HashSet<>(subset);
                newSubset.add(card);
                newSubsets.add(newSubset);
            }
            result.addAll(newSubsets);
        }
        return result;
    }

    public Set<Set<Card>> fifteens(Card starter) {
        Set<Set<Card>> result = new HashSet<>();
        List<Card> allCards = new ArrayList<>(cards);
        allCards.add(starter);

        for (Set<Card> subset : powerSet(allCards)) {
            int sum = subset.stream().mapToInt(card -> CARD_VALUES.get(card.getRank())).sum();
            if (sum == 15) result.add(subset);
        }
        return result;
    }
}