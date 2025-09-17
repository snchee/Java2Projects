import java.util.*;

public class TowerOfHanoi {
    private final Map<Peg, Deque<Integer>> diskStacks;

    public TowerOfHanoi(int numDisks, Peg start) {
        if (numDisks <= 0) {
            throw new IllegalArgumentException("Number of disks must be positive");
        }
        if (start == null) {
            throw new NullPointerException("Starting peg cannot be null");
        }

        diskStacks = new EnumMap<>(Peg.class);
        diskStacks.put(Peg.LEFT, new ArrayDeque<>());
        diskStacks.put(Peg.MIDDLE, new ArrayDeque<>());
        diskStacks.put(Peg.RIGHT, new ArrayDeque<>());

        Deque<Integer> startStack = diskStacks.get(start);
        for (int i = numDisks; i > 0; i--) {
            startStack.push(i); 
        }
    }

    public Deque<Integer> getDiskStack(Peg peg) {
        Deque<Integer> stack = diskStacks.get(peg);
        if (stack == null) {
            throw new NullPointerException("Peg cannot be null");
        }
        return new ArrayDeque<>(stack);  
    }

    public void moveDisk(Move move) {
        if (move == null) {
            throw new NullPointerException("Move cannot be null");
        }

        Deque<Integer> fromStack = diskStacks.get(move.from);
        Deque<Integer> toStack = diskStacks.get(move.to);

        if (fromStack.isEmpty()) {
            throw new IllegalArgumentException("No disks to move from " + move.from);
        }
        if (!toStack.isEmpty() && toStack.peek() < fromStack.peek()) {
            throw new IllegalArgumentException("Cannot place a larger disk on a smaller disk");
        }

        toStack.push(fromStack.pop());
    }
    
    public String reverser(Deque<Integer> deque) {
        List<Integer> reverser = new ArrayList<>(deque);
        Collections.reverse(reverser);
        return reverser.toString();
    }

    @Override
    public String toString() {
        return "  LEFT: " + reverser(diskStacks.get(Peg.LEFT)) + System.lineSeparator() +
                "MIDDLE: " + reverser(diskStacks.get(Peg.MIDDLE)) + System.lineSeparator() +
                " RIGHT: " + reverser(diskStacks.get(Peg.RIGHT));
     }

    public static List<Move> solve(int numDisks, Peg start, Peg end) {
        if (numDisks < 0) {
            throw new IllegalArgumentException("Number of disks cannot be negative");
        }
        if (start == null || end == null) {
            throw new NullPointerException("Pegs cannot be null");
        }
        if (start == end || numDisks == 0) {
            return new ArrayList<>(); 
        }

        List<Move> moves = new ArrayList<>();
        solveRecursive(numDisks, start, end, Peg.other(start, end), moves);
        return moves;
    }

    private static void solveRecursive(int n, Peg start, Peg end, Peg temp, List<Move> moves) {
        if (n == 1) {
            moves.add(Move.move(start, end)); 
        } else {
            solveRecursive(n - 1, start, temp, end, moves); 
            moves.add(Move.move(start, end)); 
            solveRecursive(n - 1, temp, end, start, moves); 
        }
    }
}