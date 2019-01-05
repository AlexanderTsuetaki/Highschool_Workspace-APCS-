/**
 * This program calculates the answer to question 3 for the Appalachian Trail Group Project
 * @author Alexander Tsuetaki
 * @version 3/30/17
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Question3 {

	private ArrayList<Integer> elevations;
	private ArrayList<Double> latitudes;
	private ArrayList<Double> longitudes;
	private static Scanner in;
	
	/**
	 * Constructor for the Question3 class
	 * Initializes arrays and imports needed information
	 */
	public Question3(){
		elevations = new ArrayList<Integer>();
		latitudes  = new ArrayList<Double>();
		longitudes = new ArrayList<Double>();
		in = new Scanner(System.in);
		try {
			in = new Scanner(new File("atgps.txt"));
			String[] temp;
			in.nextLine();
			while(in.hasNext()){
				temp = in.nextLine().split("\t");
				elevations.add(Integer.valueOf(temp[3]));
				latitudes.add(Double.valueOf(temp[0]) * (Math.PI/180));
				longitudes.add(Double.valueOf(temp[1]) * (Math.PI/180));
			}
		} catch(Exception e){
			System.out.println("Error opening or reading data file");
		}
		finally	{
			in.close();
		}
	}
	
	/**
	 * Calculates total percentage of the Appalachian Trail that has varying slopes
	 * @return percentage of the Appalachian Trail that has varying slopes
	 */
	private double[] calculate(){
		Double deltaSigma;
		Double deltaLambda;
		Double distance;
		Double grade;
		Double totalDistance = 0.0;
		Double slopeGreaterThanFivePercentDownhill = 0.0;
		Double slopeGreaterThanFivePercentUphill = 0.0;
		Double slopeLessThanFivePercentEither = 0.0;
		Double slopeGreaterThanFifteenPercentDownhill = 0.0;
		Double slopeGreaterThanFifteenPercentUphill = 0.0;
		for(int i = 0; i < elevations.size() - 1; i++){
			deltaLambda = Math.abs(longitudes.get(i) - longitudes.get(i + 1));
			deltaSigma = Math.atan(Math.sqrt(Math.pow(Math.cos(latitudes.get(i + 1)) * Math.sin(deltaLambda), 2.0) + Math.pow((Math.cos(latitudes.get(i)) * Math.sin(latitudes.get(i + 1))) - (Math.sin(latitudes.get(i)) * Math.cos(latitudes.get(i + 1)) * Math.cos(deltaLambda)), 2.0)) / ((Math.sin(latitudes.get(i)) * Math.sin(latitudes.get(i + 1))) + (Math.cos(latitudes.get(i)) * Math.cos(latitudes.get(i + 1)) * Math.cos(deltaLambda))));
			totalDistance += 20904000 * deltaSigma;
		}
		for(int i = 0; i < elevations.size() - 1; i++){
			deltaLambda = Math.abs(longitudes.get(i) - longitudes.get(i + 1));
			deltaSigma = Math.atan(Math.sqrt(Math.pow(Math.cos(latitudes.get(i + 1)) * Math.sin(deltaLambda), 2.0) + Math.pow((Math.cos(latitudes.get(i)) * Math.sin(latitudes.get(i + 1))) - (Math.sin(latitudes.get(i)) * Math.cos(latitudes.get(i + 1)) * Math.cos(deltaLambda)), 2.0)) / ((Math.sin(latitudes.get(i)) * Math.sin(latitudes.get(i + 1))) + (Math.cos(latitudes.get(i)) * Math.cos(latitudes.get(i + 1)) * Math.cos(deltaLambda))));
			distance = 20904000 * deltaSigma;
			grade = ((elevations.get(i) - elevations.get(i + 1)) / distance) * 100;
			if(grade < -5){
				slopeGreaterThanFivePercentDownhill += distance / totalDistance;
			}
			if(grade > 5){
				slopeGreaterThanFivePercentUphill += distance / totalDistance;
			}
			if(grade > -5 && grade < 5){
				slopeLessThanFivePercentEither += distance / totalDistance;
			}
			if(grade < -15){
				slopeGreaterThanFifteenPercentDownhill += distance / totalDistance;
			}
			if(grade > 15){
				slopeGreaterThanFifteenPercentUphill += distance / totalDistance;
			}
		}
		return new double[] {slopeGreaterThanFivePercentDownhill, slopeGreaterThanFivePercentUphill, slopeLessThanFivePercentEither, slopeGreaterThanFifteenPercentDownhill, slopeGreaterThanFifteenPercentUphill};
	}
	
	/**
	 * Main method for class Question3. The entry point.
	 * @param args Command line arguments if needed.
	 */
	public static void main(String[] args){
		Question3 app = new Question3();
		double[] temp = app.calculate();
		System.out.println("(a)Has a slope greater than a 5% downhill grade: " + (temp[0] * 100) + "%");
		System.out.println("(b)Has a slope greater than a 5% uphill grade: " + (temp[1] * 100) + "%");
		System.out.println("(c)Has less than 5% slope either uphill or downhill: " + (temp[2] * 100) + "%");
		System.out.println("(d)Has a slope greater than a 15% downhill grade: " + (temp[3] * 100) + "%");
		System.out.println("(e)Has a slope greater than a 15% uphill grade: " + (temp[4] * 100) + "%");
	}

}
