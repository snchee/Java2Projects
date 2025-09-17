import java.util.Arrays;
import java.util.StringJoiner;
public class IntegerList {
	

	private int[] array;
	
	private int size;
	
	private static final int MIN_CAPACITY = 2;
	

	public IntegerList() {
		array = new int[MIN_CAPACITY];
		size = 0;
	}
	
	
	public IntegerList(int capacity) {
		if (capacity < MIN_CAPACITY) {
            throw new IllegalArgumentException("The capacity cannot be less than 2.");
        }
        array = new int[capacity];
        size = 0;
	}
	
	public int capacity() {
        return array.length;
    }
	
	public void add(int integer) {
		insert(size, integer);
	}
	
	
	public int indexOf(int integer) {
		for (int i = 0; i < size; i++) {
            if (array[i] == integer) {
                return i;
            }
        }
        return -1;
    }
	
	
	public int get(int index) {
		if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The index is outside the range [0, " + (size - 1) + "].");
        }
        return array[index];
	}
	
	public void insert(int index, int integer) {
		if (index < 0 || index > size) {
			String message = "The index is outside the range [0, " + size 
					+ "].";
			throw new IndexOutOfBoundsException(message);
		}
		
		if (size == array.length) {
			array = Arrays.copyOf(array, 2*array.length);
		}
		
		for (int idx = size - 1; idx >= index; --idx) {
			array[idx + 1] = array[idx];
		}
		
		array[index] = integer;
		++size;
	}
	
	public int remove(int index) {
		if (index < 0 || index >= size) {
			String message = "The index is outside the range [0, "
					+ (size - 1) + "].";
			throw new IndexOutOfBoundsException(message);
		}
		
		int removedInt = array[index];
		
		for (int idx = index + 1; idx < size; ++idx) {
			array[idx - 1] = array[idx];
		}
		
		--size;
		
		if (4*size <= array.length && array.length > MIN_CAPACITY) {
			
			int newCapacity = Math.max(array.length / 2, MIN_CAPACITY);
			array = Arrays.copyOf(array, newCapacity);
		}
		
		return removedInt;
	}
	

	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner(", ", "[", "]");
		// TODO: Complete this method.
		for (int i = 0; i < size; i++) {
            joiner.add(String.valueOf(array[i]));
        }
        return joiner.toString();
	}
}
