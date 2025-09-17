public class SortedList extends IntegerList {

    public SortedList() {
        super();
    }

    public SortedList(int capacity) {
        super(capacity);
    }

    @Override
    public void add(int integer) {
        int i;
        for (i = 0; i < size(); i++) {
            if (get(i) > integer) {
                break;
            }
        }
        super.insert(i, integer); 
    }

    @Override
    public void insert(int index, int integer) {
        throw new UnsupportedOperationException("Cannot insert at an arbitrary index in a SortedList.");
    }
}