/**
 * Waypoint class. This holds the data to be used in the TrailDatabase.jave class to store the values from appTrailDB
 * @author 18tsuetaki
 * @version 3/1/17
 */
public class Waypoint {
	public int elevation = 0;
	public String Name = "";
	public Double longitude = 0.0;
	public Double lattitude = 0.0;
	/**
	 * the constructor
	 * @param la
	 * @param lo
	 * @param n
	 * @param e
	 */
	public Waypoint(double la, double lo, int e){
		lattitude = la;
		longitude = lo;
		elevation = e;
		Name = " ";
	}
	public Waypoint(double la, double lo,String N){
		lattitude = la;
		longitude = lo;
		elevation = 0;
		Name = N;
	}
	/**
	 * returns the name of the waypoint
	 * @return name
	 */
	public String getName(){
		return Name;
	}
	/**
	 * returns the elevation
	 * @return elevation
	 */
	public int getElevation(){
		return elevation;
	}
	/**
	 * returns the lattitude
	 * @return lattitude
	 */
	public double getlattitude(){
		return lattitude;
	}
	/**
	 * returns the longitude
	 * @return longitude
	 */
	public double getlongitude(){
		return longitude;
	}
	
}
	 
