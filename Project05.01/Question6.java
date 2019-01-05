/**
 * This program calculates the answer to question 6 for the Appalachian Trail Group Project
 * @author Alexander Tsuetaki
 * @version 3/30/17
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Question6 {

	private ArrayList<Integer> elevations;
	private ArrayList<Double> latitudes;
	private ArrayList<Double> longitudes;
	private ArrayList<Double> atOrAboveElevationsStart;
	private ArrayList<Double> atOrAboveElevationsEnd;
	private ArrayList<String> waypointNames;
	private ArrayList<Double> waypointLatitudes;
	private ArrayList<Double> waypointLongitudes;
	private ArrayList<String> finalWaypointsStart;
	private ArrayList<String> finalWaypointsEnd;
	private static Scanner in;
	
	/**
	 * Constructor for the Question6 class
	 * Initializes arrays and imports needed information
	 */
	public Question6(){
		elevations = new ArrayList<Integer>();
		latitudes  = new ArrayList<Double>();
		longitudes = new ArrayList<Double>();
		atOrAboveElevationsStart = new ArrayList<Double>();
		atOrAboveElevationsEnd = new ArrayList<Double>();
		waypointNames = new ArrayList<String>();
		waypointLatitudes = new ArrayList<Double>();
		waypointLongitudes = new ArrayList<Double>();
		finalWaypointsStart = new ArrayList<String>();
		finalWaypointsEnd = new ArrayList<String>();
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
			in = new Scanner(new File("apptrailDB.txt"));
			while(in.hasNext()){
				temp = in.nextLine().split("\t");
				waypointNames.add(String.valueOf(temp[1]));
				waypointLatitudes.add(Double.valueOf(temp[3]) * (Math.PI/180));
				waypointLongitudes.add(Double.valueOf(temp[4]) * (Math.PI/180));
			}
		} catch(Exception e){
			System.out.println("Error opening or reading data files");
		}
		finally	{
			in.close();
		}
	}
	
	/**
	 * Does calculations for building a list of mileage sections of all parts of the Appalachian Trail that are at or above the elevation of 5905 feet
	 * @return a list of mileage sections of all parts of the Appalachian Trail that are at or above the elevation of 5905 feet
	 */
	private void calculate(){
		Double deltaSigma;
		Double deltaLambda;
		Double distance;
		Double minDistance = 10000000.0;
		int minDistanceIndex = 0;
		int findEnd;
		Double distanceSoFar = 0.0; 
		for(int i = 0; i < elevations.size(); i++){
			if(elevations.get(i) >= 5905){
				atOrAboveElevationsStart.add((double)i);
				findEnd = i + 1;
				while(elevations.get(findEnd) >= 5905){
					findEnd++;
				}
				atOrAboveElevationsEnd.add((double)findEnd);
				i = findEnd + 1;
			}
		}
		
		for(int i = 0; i < atOrAboveElevationsStart.size(); i++){
			for(int q = 0; q < waypointNames.size(); q++){
				deltaLambda = Math.abs(longitudes.get(atOrAboveElevationsStart.get(i).intValue()) - waypointLongitudes.get(q));
				deltaSigma = Math.atan(Math.sqrt(Math.pow(Math.cos(waypointLatitudes.get(q)) * Math.sin(deltaLambda), 2.0) + Math.pow((Math.cos(latitudes.get(atOrAboveElevationsStart.get(i).intValue())) * Math.sin(waypointLatitudes.get(q))) - (Math.sin(latitudes.get(atOrAboveElevationsStart.get(i).intValue())) * Math.cos(waypointLatitudes.get(q)) * Math.cos(deltaLambda)), 2.0)) / ((Math.sin(latitudes.get(atOrAboveElevationsStart.get(i).intValue())) * Math.sin(waypointLatitudes.get(q))) + (Math.cos(latitudes.get(atOrAboveElevationsStart.get(i).intValue())) * Math.cos(waypointLatitudes.get(q)) * Math.cos(deltaLambda))));
				distance = 20904000 * deltaSigma;
				if(minDistance > distance){
					minDistance = distance;
					minDistanceIndex = q;
				}
			}
			finalWaypointsStart.add(waypointNames.get(minDistanceIndex));
			minDistance = 10000000.0;
		}
		
		for(int i = 0; i < atOrAboveElevationsEnd.size(); i++){
			for(int q = 0; q < waypointNames.size(); q++){
				deltaLambda = Math.abs(longitudes.get(atOrAboveElevationsEnd.get(i).intValue()) - waypointLongitudes.get(q));
				deltaSigma = Math.atan(Math.sqrt(Math.pow(Math.cos(waypointLatitudes.get(q)) * Math.sin(deltaLambda), 2.0) + Math.pow((Math.cos(latitudes.get(atOrAboveElevationsEnd.get(i).intValue())) * Math.sin(waypointLatitudes.get(q))) - (Math.sin(latitudes.get(atOrAboveElevationsEnd.get(i).intValue())) * Math.cos(waypointLatitudes.get(q)) * Math.cos(deltaLambda)), 2.0)) / ((Math.sin(latitudes.get(atOrAboveElevationsEnd.get(i).intValue())) * Math.sin(waypointLatitudes.get(q))) + (Math.cos(latitudes.get(atOrAboveElevationsEnd.get(i).intValue())) * Math.cos(waypointLatitudes.get(q)) * Math.cos(deltaLambda))));
				distance = 20904000 * deltaSigma;
				if(minDistance > distance){
					minDistance = distance;
					minDistanceIndex = q;
				}
			}
			finalWaypointsEnd.add(waypointNames.get(minDistanceIndex));
			minDistance = 10000000.0;
		}
			
		
		
		
		for(int i = 0; i < elevations.size() - 1; i++){
			deltaLambda = Math.abs(longitudes.get(i) - longitudes.get(i + 1));
			deltaSigma = Math.atan(Math.sqrt(Math.pow(Math.cos(latitudes.get(i + 1)) * Math.sin(deltaLambda), 2.0) + Math.pow((Math.cos(latitudes.get(i)) * Math.sin(latitudes.get(i + 1))) - (Math.sin(latitudes.get(i)) * Math.cos(latitudes.get(i + 1)) * Math.cos(deltaLambda)), 2.0)) / ((Math.sin(latitudes.get(i)) * Math.sin(latitudes.get(i + 1))) + (Math.cos(latitudes.get(i)) * Math.cos(latitudes.get(i + 1)) * Math.cos(deltaLambda))));
			distance = 20904000 * deltaSigma;
			distanceSoFar += distance * 0.000189394;
			for(int q = 0; q < atOrAboveElevationsStart.size(); q++){
				if(atOrAboveElevationsStart.get(q) == (double)(i)){
					atOrAboveElevationsStart.remove(q);
					atOrAboveElevationsStart.add(q, distanceSoFar);
				}
			}
			for(int q = 0; q < atOrAboveElevationsEnd.size(); q++){
				if(atOrAboveElevationsEnd.get(q) == (double)(i)){
					atOrAboveElevationsEnd.remove(q);
					atOrAboveElevationsEnd.add(q, distanceSoFar);
				}
			}
		}
	}

	/**
	 * Main method for class Question6. The entry point.
	 * @param args Command line arguments if needed.
	 */
	public static void main(String[] args){
		Question6 app = new Question6();
		app.calculate();
//		for(int i = 0; i < app.finalWaypointsStart.size(); i++){
//			System.out.println("Start: " + app.finalWaypointsStart.get(i) + " | End: " + app.finalWaypointsEnd.get(i));
//		}
		for(int i = 0; i < app.finalWaypointsStart.size(); i++){
			System.out.println("Start: " + app.atOrAboveElevationsStart.get(i) + " miles | End: " + app.atOrAboveElevationsEnd.get(i) + " miles");
		}
	}
	
}
