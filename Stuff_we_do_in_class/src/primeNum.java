import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class primeNum {
	public static int sequence(int num){
		
		if (num%2 == 0){
			num = (num - 2*num)/2;
			return (num);
		}
		else{
			num = (num+1)/2;
			return (num);
		}
					
	}
	public static int minutesUntilLunch(String time){
		int minutes= 0;
		int hours = Integer.parseInt(time.substring(0,2));
		int mins = Integer.parseInt(time.substring(3));
		minutes = 270+(8-hours)*60-mins+15;
		return minutes;
	}
	public static void main(String[] args){
		DecimalFormat df = new DecimalFormat("#.00");
		df.format(0.912385);
		int[] grades = {77, 90, 88, 92, 100, 95, 84};
		double average = 0;
		double temp = 0.0;
		for (int i = 0; i<grades.length;i++)
			temp += grades[i];
		temp/= grades.length;
		System.out.println(minutesUntilLunch("09:25"));
	}
}
