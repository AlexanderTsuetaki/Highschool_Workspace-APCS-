import java.util.*;
import java.io.*;
import java.lang.Throwable;
public class PropertyManager {
	private ArrayList<House> houses;
	private ArrayList<HouseForSale> housesForSale;// IS THIS LIST NECESSARY?

	/** Constructor for class PropertyManager */
	public PropertyManager() {
		houses = new ArrayList<House>();
		housesForSale = new ArrayList<HouseForSale>();// AGAIN, DO WE NEED THIS?
		importPropertyList();
	}

	/** Import house data and build corresponding lists */
	private void importPropertyList() {
		Scanner in = null;
		try {
			in = new Scanner(new File("houses.txt"));
			String[] temp;
			while (in.hasNext()) {
				temp = in.nextLine().trim().split(",");
				// The price field is 0.0 if the house is NOT for sale
				// Create a new House or HouseForSale object and add to the
				// appropriate list
				if (Double.parseDouble(temp[5]) == 0.0)
					// House Object added
					houses.add(new House(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]),
							Boolean.parseBoolean(temp[2]), Boolean.parseBoolean(temp[3]), Double.parseDouble(temp[4])));
				else
					// HouseForSale Object added
					houses.add(new HouseForSale(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]),
							Boolean.parseBoolean(temp[2]), Boolean.parseBoolean(temp[3]), Double.parseDouble(temp[4]),
							Double.parseDouble(temp[5])));
			}
			if (in != null)
				in.close();
			System.out.println("House data imported into database.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sortDB() {
		Collections.sort(houses);
	}

	/** Prints the list of all houses not on the market */
	public void printHouses() {
		for (House h : houses)
			System.out.println(h);
	}

	/** Prints the list of all houses on the market */
	// IS THIS METHOD NECESSARY? CAN IT BE DELETED?
	public void printHousesForSale() {
		for (HouseForSale hfs : housesForSale)
			System.out.println(hfs);
	}

	public static void main(String[] args) {
		PropertyManager app = new PropertyManager();
		System.out.println("** The following is a list of our managed properties **");
		app.printHouses();
		app.sortDB();
		app.printHouses();
	}
}