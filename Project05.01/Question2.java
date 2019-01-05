/**
 * This program calculates the answer to question 2 for the Appalachian Trail Group Project
 * @author Alexander Tsuetaki
 * @version 3/30/17
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Question2 {

	private ArrayList<Integer> elevations;
	private static Scanner in;
	
	/**
	 * Constructor for the Question2 class
	 * Initializes arrays and imports needed information
	 */
	public Question2(){
		elevations = new ArrayList<Integer>();
		in = new Scanner(System.in);
		try {
			in = new Scanner(new File("atgps.txt"));
			String[] temp;
			in.nextLine();
			while(in.hasNext()){
				temp = in.nextLine().split("\t");
				elevations.add(Integer.valueOf(temp[3]));
			}
		} catch(Exception e){
			System.out.println("Error opening or reading data file");
		}
		finally	{
			in.close();
		}
	}
	
	/**
	 * Calculates total elevation loss across all of the GPS points on the Appalachian Trail
	 * @return total elevation loss across all of the GPS points on the Appalachian Trail
	 */
	private int calculate(){
		int sum = 0;
		for(int i = 0; i < elevations.size() - 1; i++){
			if(elevations.get(i) > elevations.get(i + 1)){
				sum += elevations.get(i) - elevations.get(i + 1);
			}
		}
		return sum;
	}

	/**
	 * Main method for class Question2. The entry point.
	 * @param args Command line arguments if needed.
	 */
	public static void main(String[] args){
		Question2 app = new Question2();
		System.out.println(app.calculate());
	}
	
}
