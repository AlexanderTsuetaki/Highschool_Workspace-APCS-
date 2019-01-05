import java.text.DecimalFormat;

public class HouseForSale extends House implements Comparable<House> {
	private double salePrice;

	/** Constructor for HouseForSale */
	public HouseForSale(int beds, int baths, boolean gr, boolean fp, double sf, double sp) {
		super(beds, baths, gr, fp, sf);
		salePrice = sp;
	}

	/**
	 * @return The listed price of this house.
	 */
	public double getSalePrice() {
		return salePrice;
	}

	/**
	 * Comparing based on price, if other instanceof HouseForSale, otherwise by
	 * area
	 * 
	 * @return -int this < other, 0 this == other, +int this > other
	 */
	public int compareTo(House other) {
		if (other instanceof HouseForSale) {
			Double d1 = this.salePrice;
			Double d2 = ((HouseForSale) other).salePrice;

			return d1.compareTo(d2);
		} else
			return super.compareTo(other);
	}

	/**
	 * @return "3BR/2BA 26xx.00ft^2 house (includes garage and fireplace) -->
	 *         Sale price: $XX,YYY.00"
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("$0,000.00");
		return super.toString() + " --> Sale price: " + df.format(salePrice);
	}

	/**
	 * Main method for class, used for testing print output.
	 * 
	 * @param args
	 *            Command-line arguments, if needed.
	 */
	public static void main(String[] args) {
		House h1 = new HouseForSale(6, 5, true, true, 4100.0, 622000.0);
		House h2 = new HouseForSale(3, 2, false, true, 1400.0, 201000.0);
		House h3 = new HouseForSale(5, 4, true, true, 4200.0, 494000.0);

		System.out.println(h1);
		System.out.println(h2);
		System.out.println(h3);
	}
}