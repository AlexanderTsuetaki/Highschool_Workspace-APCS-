import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class question4 {
	private ArrayList<Waypoint> myPoints;
	private double totalDistance;
	public void populateDatabase(){
		Scanner in;
		try{
			in = new Scanner(new File("atgps.txt"));
			String[] temp = in.nextLine().split("\t");
			while (in.hasNext()){
				temp = in.nextLine().split("\t");
				double t1 = Double.parseDouble(temp[0]);
				double t2 = Double.parseDouble(temp[1]);
				int t4 = Integer.parseInt(temp[3]);
				myPoints.add(new Waypoint(t1,t2,t4));
			}
			in.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public question4(){
		myPoints = new  ArrayList<Waypoint>();
		totalDistance = 0.0;
	}
	public static void main(String[] args){
		question4 q4 = new question4();
		
	}
	
}
