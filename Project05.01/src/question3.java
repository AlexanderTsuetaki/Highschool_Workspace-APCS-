import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.math.*;
public class question3 {
	private ArrayList<Waypoint> myPoints;
	private double totalDistance;
	public question3(){
		myPoints = new ArrayList<Waypoint>();
		totalDistance = 0.0;
	}
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
	public double findGreatCircleFormulaDistance(Waypoint D, Waypoint P){
		double a = 0.0;
		double b1 = Math.toRadians(D.getlattitude());
		double b2 = Math.toRadians(P.getlattitude());
		double c = Math.toRadians(D.getlongitude());
		double c2 = Math.toRadians(P.getlongitude());
		a = 20904000*Math.acos(Math.sin(b1)*Math.sin(b2)+Math.cos(b1)*Math.cos(b2)*Math.cos(Math.abs(c-c2)));
		totalDistance = totalDistance+a;
		return a;
	}
	public double getSlope(Waypoint D, Waypoint P){
		double distance = findGreatCircleFormulaDistance(D,P);
		int deltaElevations = D.getElevation()-P.getElevation();
		System.out.println(deltaElevations);
		System.out.println(distance);
		return (deltaElevations/distance);
	}
	public static void main(String[] args){
		question3 q3 = new question3();
		q3.populateDatabase();
		double total = 0.0;
		double t1 = 0;
		double t2 = 0;
		double t3 = 0;
		double t4 = 0;
		double t5 = 0;
		for (int i = 0; i<q3.myPoints.size()-1;i++){
			total = q3.getSlope(q3.myPoints.get(i), q3.myPoints.get(i+1))*100;
			if (total>5.0){
				if(total>15.0){
					t4++;
				}
				t1++;
			}
			else if(total<-5.0){
				if(total<-15.0){
					t5++;
				}
				t2++;
			}
			else{
				t3++;
			}
		}
		System.out.println(q3.totalDistance);
		System.out.println("greater than 15    "+t4/q3.myPoints.size()*100);
		System.out.println("greater than 5 "+t1/q3.myPoints.size()*100);
		System.out.println("between -5 and 5   "+t3/q3.myPoints.size()*100);
		System.out.println("less than -5   "+ t2/q3.myPoints.size()*100);
		System.out.println("less than than -15 "+t5/q3.myPoints.size()*100);
		//System.out.println((t1+t2+t3)/q3.myPoints.size()*100);
	}
}
