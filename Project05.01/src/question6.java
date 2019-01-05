import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class question6 {
	private ArrayList<Waypoint> myPoints;
	private ArrayList<Waypoint> trailDB;
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
	public void populateDatabase2(){
		Scanner in;
		try{
			in = new Scanner(new File("apptrailDB.txt"));
			String[] temp = in.nextLine().split("\t");
			while (in.hasNext()){
				temp = in.nextLine().split("\t");
				double t1 = Double.parseDouble(temp[3]);
				double t2 = Double.parseDouble(temp[4]);
				String n = temp[0]+temp[1];
				trailDB.add(new Waypoint(t1,t2,n));
			}
			in.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public double[][] findSectionRange(Waypoint a, Waypoint b){
		double[][] temp0 = new double[2][2];
		temp0[0][0] = a.getlongitude();
		temp0[0][1] = a.getlattitude();
		temp0[1][0] = b.getlongitude();
		temp0[1][1] = b.getlattitude();
		if(a.getElevation()>=5905&&b.getElevation()>=5905){
			return temp0;
		}
		if(a.getElevation()>b.getElevation()){
			if(a.getElevation()>=5905){
				double temp = 5905/(a.getElevation()+b.getElevation());
				temp0[1][0] = (a.getlongitude()+b.getlongitude())*temp;
				temp0[1][1] = (a.getlattitude()+b.getlattitude())*temp;
				return temp0;
			}	
		}
		if(b.getElevation()>=5905){
			double temp = 5905/(a.getElevation()+b.getElevation());
			temp0[0][0] = (a.getlongitude()+b.getlongitude())*temp;
			temp0[0][1] = (a.getlattitude()+b.getlattitude())*temp;
			return temp0;
		}
		temp0[0][0] = 0;
		temp0[0][1] = 0;
		temp0[1][0] = 0;
		temp0[1][1] = 0;
		return temp0;
	}
	public void outputPoints(){
		double[][] gesDF= new double[2][2];
		double[][] gestemp = new double[2][2];
		double start[] = new double[2];
		double end[] = new double[2];
		try {
			PrintWriter pw = new PrintWriter( new FileWriter("converted.txt"));
			for (int i = 0;i<myPoints.size()-1;i++){
				gesDF = findSectionRange(myPoints.get(i),myPoints.get(i+1));
				if(gesDF[0][0] != 0 && gesDF[1][0]!= gestemp[0][0]&&gesDF[1][1]!=gestemp[0][1]){
					pw.println(gesDF[0][1]+"\t"+gesDF[0][0]);
					for(int j = 0;j<trailDB.size();j++){
						if(trailDB.get(j).getlattitude()== gesDF[0][1] && trailDB.get(j).getlongitude()==gesDF[0][0]){
							pw.print(trailDB.get(i).getName());
						}
					}
					pw.println(gesDF[1][1]+"\t"+gesDF[1][0]);
					for(int j = 0;j<trailDB.size();j++){
						if(trailDB.get(j).getlattitude()== gesDF[1][1] && trailDB.get(j).getlongitude()==gesDF[1][0]){
							pw.print(trailDB.get(i).getName());
						}
					}
					
				}
			}
			pw.close();
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public question6(){
		myPoints = new  ArrayList<Waypoint>();
		trailDB = new  ArrayList<Waypoint>();
	}
	public static void main(String[] args){
		question6 q6 = new question6();
		q6.populateDatabase();
		q6.populateDatabase2();
		q6.outputPoints();
	}
}
