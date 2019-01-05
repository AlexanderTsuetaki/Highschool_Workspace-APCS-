import java.text.DecimalFormat;

public class House implements Comparable<House> {
	private int bedrooms, bathrooms;
	private boolean hasGarage;
	private boolean hasFireplace;
	private double squareFootage;

	/** Constructor for class House */
	public House(int beds, int baths, boolean gr, boolean fp, double sf) {
		bedrooms = beds;
		bathrooms = baths;
		hasGarage = gr;
		hasFireplace = fp;
		squareFootage = sf;
	}

	// ACCESSOR METHODS
	public int bedrooms() {
		return bedrooms;
	}

	public int bathrooms() {
		return bathrooms;
	}

	public boolean hasGarage() {
		return hasGarage;
	}

	public boolean hasFireplace() {
		return hasFireplace;
	}

	public double squareFootage() {
		return squareFootage;
	}

	/**
	 * Comparing based on square footage
	 * 
	 * @return -int this < other, 0 this == other, +int this > other
	 */
	public int compareTo(House other) {
		Double dThis = this.squareFootage;
		Double dOther = other.squareFootage;
		return dThis.compareTo(dOther);
	}

	/**
	 * @return 3BR/2BA 26xx.00ft^2 house (includes garage and fireplace) for
	 *         example.
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		String val = bedrooms + "BR/" + bathrooms + "BA " + df.format(squareFootage) + " ft^2 house";
		val += (hasGarage) ? " (includes garage" : "";
		val += (hasFireplace) ? ((hasGarage) ? " and fireplace" : " (includes fireplace") : "";
		val += (hasGarage || hasFireplace) ? ")" : "";
		return val;
	}

	/**
	 * Main method for class, used for testing print output.
	 * 
	 * @param args
	 *            Command-line arguments, if needed.
	 */
	public static void main(String[] args) {
		House h1 = new House(5, 4, true, true, 4700.0);
		House h2 = new House(3, 2, false, true, 1300.0);
		House h3 = new House(5, 4, true, false, 3000.0);

		System.out.println(h1);
		System.out.println(h2);
		System.out.println(h3);
	}
}