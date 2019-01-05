import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class question1 {
	private ArrayList<Waypoint> myPoints;

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
	public question1(){
		myPoints = new ArrayList<Waypoint>();
	}
	public int[] getHeight(){
		int[] total  = new int[2];
		int totalH = 0;
		int totalD = 0;
		for (int i = 1; i< myPoints.size();i++){
			if (myPoints.get(i).getElevation()>myPoints.get(i-1).getElevation()){
				totalH+=(myPoints.get(i).getElevation()-myPoints.get(i-1).getElevation());
			}
			else
				totalD+=(myPoints.get(i-1).getElevation()-myPoints.get(i).getElevation());
		}
		total[0] = totalH;
		total[1] = totalD;
		return total ;
	}
	public static void main(String[] args){
		question1 q1 = new question1();
		q1.populateDatabase();
		int[] total = q1.getHeight();
		System.out.println(total[0]);
		System.out.println(total[1]);
	}

}
