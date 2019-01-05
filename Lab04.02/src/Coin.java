/**
 * Coin class, the abstract class that the other coin type classes are based. 
 * @author 18tsuetaki
 *@version2/1/17
 */
public abstract class Coin {
	/**
	 * gets the value of the coin
	 * @returns value
	 */
	public abstract double getValue();
	/**
	 * gets the name of the coin
	 * @return name
	 */
	public abstract String getName();
	/**
	 * gets the plural name of the coin
	 * @return the plural name
	 */
	public String getPluralName() {
		String sName= getName();
		if (sName.substring(sName.length(),sName.length()+1).equals("y")){
			sName  = sName.substring(0,sName.length())+"ies";
		}
		else
			sName = sName+"s";
		return sName;
	}
	// returns .01, .05, ..., .5, 1.0 based on // implementing class object's value
	// returns "penny", "nickel", ...,
	// "half dollar", "dollar"
	// define in the class: pennies, dimes...
}
