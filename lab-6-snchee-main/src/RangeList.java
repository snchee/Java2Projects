public class RangeList extends IntegerList {


    public RangeList() {
    	super();
    }
    
    public RangeList(int lowerBound, int upperBound) {
    	super();
    	try {
    		if (lowerBound > upperBound) {
    			throw new IllegalArgumentException();
    		} else {
    			int index = 0;
    			for (int i = lowerBound; i <= upperBound; i++) {
    				super.insert(index, i);
    				index++;
    			}
    		}
    	}
    	catch (IllegalArgumentException e) {
    		throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound.");
    	}
    }
    
    public void add(int lowerBound, int upperBound) {
    	if (lowerBound > upperBound) {
    		throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound.");
    	}
    	if (super.size() == 0) {
    		int index = 0;
    		for (int i = lowerBound; i <= upperBound; i++) {
    			super.insert(index, i);
    			index++;
    		}
    	} else {
    		int Lower = super.get(0);
    		int Upper = super.get(size()-1);
    		if (lowerBound < Lower) {
    			for (int i = Lower - 1; i >= lowerBound; i--) {
    				super.insert(0, i);
    			}
    		}
    		if (upperBound > Upper) {
    			for(int i = Upper + 1; i <= upperBound; i++) {
    				super.insert(size(),  i);
    			}
    		}
    	}
    }
    
    public void remove(int lowerBound, int upperBound) {
        if (lowerBound > upperBound) {
            throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound.");
        }
        if (size() == 0) {
            throw new UnsupportedOperationException("Cannot remove range from an empty list.");
        }
        int currentLower = get(0);
        int currentUpper = get(size() - 1);
        
        if (lowerBound < currentLower || upperBound > currentUpper) {
            throw new IllegalArgumentException("Lower and/or upper bounds are out of the current list range.");
        }
        int index = super.indexOf(lowerBound);
        for (int i = lowerBound; i <= upperBound; i++) {
            super.remove(index);
        }
    }
    
    public void insert(int index, int integer) {
    	throw new UnsupportedOperationException();
    }
    
    public void add(int integer) {
    	throw new UnsupportedOperationException();
    }
}