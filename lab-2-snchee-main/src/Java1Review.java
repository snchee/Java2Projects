/**
 * Implement each of the 10 methods tested in JUnitTests.java. Study the tests
 * to determine how the methods should work.
 */
public class Java1Review {
	
	public static double divide(double a, double b) {
		double divide = a/b;
		return divide;
	}
	
	public static int divide(int a, int b) {
		int divide = a/b;
		return divide;
	}
	
	public static boolean isDivisibleBy7(int a) {
		if (a % 7 == 0) {
			return true;
		}
		return false;
	}
	
	public static String main(String a) {
		return "Overloaded main method was passed \"" + a + "\".";
	}
	
	public static int findMin(int a, int b, int c) {
		if (a < b && a < c) {
			return a;
		} else if (b < a && b < c) {
			return b;
		}
			return c;
	}
	
	public static int findMin(int[] a) {
		int min = 10000;
		for (int i = 0; i < a.length; i++) {
			if (a[i] <= min) {
				min = a[i];
			}
		}
		return min;
	}
	
	public static double average(int[] a) {
		double sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}
		sum = sum / a.length;
		return sum;
	}
	
	public static String[] toLowerCase(String[] a) {
		for (int i = 0; i<a.length; i++) {
			a[i] = a[i].toLowerCase();
		}
		return a;
	}
	
	public static String[] toLowerCaseCopy(String[] a) {
		String[] copy = new String[a.length];
		for (int i = 0; i<a.length; i++) {
			copy[i] = a[i].toLowerCase();
		}
		return copy;
	}
	
	public static int[] removeDuplicates(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int spot = a[i];
			for (int j = i+1; j < a.length; j++) {
				if (a[j] == spot) {
					a[j] = 0;
					a[i] = 0;
				}
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		// If you want to write your own tests, do so here. (Do not modify
		// JUnitTests.java.) To run this method in Eclipse, right-click
		// Java1Review.java in the Package Explorer and select "Run As" >
		// "Java Application" from the context menu.
		
	}

}
