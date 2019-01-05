/**
 * This program calculates the answer to question 4 for the Appalachian Trail Group Project
 * @author Alexander Tsuetaki
 * @version 3/30/17
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Question4 {

	private ArrayList<Double> grades;
	private ArrayList<Double> distances;
	private ArrayList<Integer> elevations;
	private ArrayList<Double> latitudes;
	private ArrayList<Double> longitudes;
	private static Scanner in;
	
	/**
	 * Constructor for the Question4 class
	 * Initializes arrays and imports needed information
	 */
	public Question4(){
		grades = new ArrayList<Double>();
		distances = new ArrayList<Double>();
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
	 * Calculates the 100-mile section of the trail that can be determined to be the "most challenging" section of the trail
	 * @return the 100-mile section of the trail that can be determined to be the "most challenging" section of the trail
	 */
	private double[] calculate(){
		Double deltaSigma;
		Double deltaLambda;
		Double distance;
		Double grade;
		Double totalDistance = 0.0;
		Double averageGrade = 0.0;
		Double maxAverageGrade = 0.0;
		Double distanceSoFar = 0.0;
		Double startMile = 0.0;
		Double endMile = 0.0;
		int startIndex = 0;
		int endIndex = 0;
		int endI = 0;
		for(int i = 0; i < elevations.size() - 1; i++){
			deltaLambda = Math.abs(longitudes.get(i) - longitudes.get(i + 1));
			deltaSigma = Math.atan(Math.sqrt(Math.pow(Math.cos(latitudes.get(i + 1)) * Math.sin(deltaLambda), 2.0) + Math.pow((Math.cos(latitudes.get(i)) * Math.sin(latitudes.get(i + 1))) - (Math.sin(latitudes.get(i)) * Math.cos(latitudes.get(i + 1)) * Math.cos(deltaLambda)), 2.0)) / ((Math.sin(latitudes.get(i)) * Math.sin(latitudes.get(i + 1))) + (Math.cos(latitudes.get(i)) * Math.cos(latitudes.get(i + 1)) * Math.cos(deltaLambda))));
			distance = 20904000 * deltaSigma;
			grade = (double)(Math.abs(elevations.get(i) - elevations.get(i + 1)));
			distances.add((Double.isNaN(distance)) ? 0.0 : distance);
			grades.add((Double.isNaN(grade)) ? 0.0 : grade);
		}
		
		for(int q = 0; q < 284870; q++){
			for(int i = q; totalDistance <= 100; i++){
				totalDistance += (distances.get(i) * 0.000189394);
				averageGrade += grades.get(i);
				endI = i;
			}
			averageGrade /= (totalDistance * 5280);
			if(maxAverageGrade < averageGrade){
				maxAverageGrade = averageGrade;
				startIndex = q;
				endIndex = endI;
			}
			averageGrade = 0.0;
			totalDistance = 0.0;
			if(q % (284870 / 10) == 0){
				System.out.println(q / (284870 / 100) + "% done");
			}
		}

		for(int i = 0; i < elevations.size() - 1; i++){
			deltaLambda = Math.abs(longitudes.get(i) - longitudes.get(i + 1));
			deltaSigma = Math.atan(Math.sqrt(Math.pow(Math.cos(latitudes.get(i + 1)) * Math.sin(deltaLambda), 2.0) + Math.pow((Math.cos(latitudes.get(i)) * Math.sin(latitudes.get(i + 1))) - (Math.sin(latitudes.get(i)) * Math.cos(latitudes.get(i + 1)) * Math.cos(deltaLambda)), 2.0)) / ((Math.sin(latitudes.get(i)) * Math.sin(latitudes.get(i + 1))) + (Math.cos(latitudes.get(i)) * Math.cos(latitudes.get(i + 1)) * Math.cos(deltaLambda))));
			distance = 20904000 * deltaSigma;
			distanceSoFar += distance * 0.000189394;
			if(startIndex == i){
				startMile  = distanceSoFar;
			}
			if(endIndex == i){
				endMile  = distanceSoFar;
				break;
			}
		}
		
		return new double[] {maxAverageGrade * 100, startMile, endMile};
	}
	
	/**
	 * Main method for class Question4. The entry point.
	 * @param args Command line arguments if needed.
	 */
	public static void main(String[] args){
		Question4 app = new Question4();
		double[] temp = app.calculate();
		System.out.println("100% done\nAverage Grade: " + temp[0] + "\nStarting Mile: " + temp[1] + "\nEnding Mile: " + temp[2]);
	}

}
