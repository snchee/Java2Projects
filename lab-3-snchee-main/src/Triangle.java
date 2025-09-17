
public class Triangle {
	private double sideA;
	private double sideB;
	private double sideC;
	
	public static final String POLYGONSHAPE = "Triangle";
	public static final double DEFAULT_SIDE = 1.0;
	
	// constructors
	public Triangle() {
		sideA = DEFAULT_SIDE;
		sideB = DEFAULT_SIDE;
		sideC = DEFAULT_SIDE;
	}
	
	public Triangle(double a, double b, double c) {
		if (!isTriangle(a, b, c)) {
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
		else {
			this.sideA = a;
			this.sideB = b;
			this.sideC = c;
		}
	}
	
	public static boolean isTriangle(double a, double b, double c) {
		if (a > 0 && b > 0 && c > 0 && a < b + c && b < a + c && c < a + b) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Triangle(double[] sides) {
		if (sides == null || sides.length != 3 || !isTriangle(sides[0], sides[1], sides[2])) {
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
		else {
			this.sideA = sides[0];
			this.sideB = sides[1];
			this.sideC = sides[2];
		}
		
	}
	
	public static boolean isTriangle(double[] sides) {
		if (sides == null || sides.length != 3) {
			return false;
		}
		if (sides[0] > 0 && sides[1] > 0 && sides[2] > 0 && isTriangle(sides[0], sides[1], sides[2]) && sides != null) {
			return true;
		}
		return false;
	}
	
	public Triangle(Triangle triangle) { 
		if (triangle == null) {
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
		else {
			this.sideA = triangle.sideA;
			this.sideB = triangle.sideB;
			this.sideC = triangle.sideC;
		}
	}
	
	public static double lawOfCosines(double a, double b, double c) {
		double cAngle = ((a * a) + (b * b) - (c * c)) / (2 * a * b);
		double angle = Math.acos(Math.min(1.0, Math.max(-1.0, cAngle)));
		return Math.toDegrees(angle);
	}
	
	// setters and getters
	public double getSideA() {
		return sideA;
	}

	public boolean setSideA(double a) {
		if (isTriangle(a, sideB, sideC)) {
			this.sideA = a;
			return true;
		}
		return false;
	}

	public double getSideB() {
		return sideB;
	}

	public boolean setSideB(double b) {
		if (isTriangle(sideA, b, sideC)) {
			this.sideB = b;
			return true;
		}
		return false;
	}

	public double getSideC() {
		return sideC;
	}

	public boolean setSideC(double c) {
		if (isTriangle(sideA, sideB, c)) {
			this.sideC = c;
			return true;
		}
		return false;
	}
	
	public double[] getSides() {
		return new double[] {sideA, sideB, sideC};
	}
	
	public boolean setSides(double[] sides) {
		if (isTriangle(sides)) {
			this.sideA = sides[0];
			this.sideB = sides[1];
			this.sideC = sides[2];
			return true;
		}
		return false;
	}
	
	public double getAngleA() {
		return lawOfCosines(sideB, sideC, sideA);
	}
	
	public double getAngleB() {
		return lawOfCosines(sideA, sideC, sideB);
	}
	
	public double getAngleC() {
		return lawOfCosines(sideA, sideB, sideC);
	}
	
	public double[] getAngles() {
		return new double[] {getAngleA(), getAngleB(), getAngleC()};
	}
	
	
	// to String 
	@Override
	public String toString() {
		return String.format("%s(%.4f, %.4f, %.4f)", POLYGONSHAPE, sideA, sideB, sideC);
	}
	
}

