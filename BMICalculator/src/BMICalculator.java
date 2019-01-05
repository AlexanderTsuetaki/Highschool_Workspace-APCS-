/**
 * returns BMI after input of weight and height
 * @author 18tsuetaki
 * @version 10/10/16
 */
import java.util.Scanner;
import java.text.DecimalFormat;

public class BMICalculator {
	/**
	 * Convert English to Metric, perform the BMI calculation
	 * @param inches
	 * @param pounds
	 * @return user'sBMI as a double
	 */
	public static double computeBMI(int inches, int pounds){
		DecimalFormat df = new DecimalFormat("0.00");
		double meters = inches*0.0254;
		double kg = pounds*0.454;
		if ((meters<=0) || (pounds<=0))
			return (0.00);
		double BMI = kg/(meters*meters);
		String BMI2 = df.format(BMI);
		double BMI3 = Double.parseDouble(BMI2);
		return BMI3;
	}
	/**
	 * the Main method finds the users he3ight and weight in the standard system through a scanner and then calls computeBMI and prints the correct statements
	 * @param args
	 */
	public static void main(String[] args){
		int inches;
		int pounds;
		String f = "";
		String inc = "";
		Scanner in = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		
		System.out.print("Enter your height in feet and inches (Ex 6\'1\"): ");
		String userEntry = in.nextLine();
		int q = userEntry.indexOf("\'");
		
		for (int i = userEntry.length()-2; i!=q ; i--){
			inc = userEntry.substring(i,i+1)+inc;
		}
		
		for (int j= q-1; j >= 0; j--){
			f = userEntry.substring(j,j+1)+f;
		}
		inches = 12*Integer.parseInt(f) + Integer.parseInt(inc);
		
		System.out.print("Enter your weight in pounds: ");
		String userEntry2 = in.nextLine();
		pounds = Integer.parseInt(userEntry2);
		
		System.out.print("Your BMI, expressed as weight(kg)/height(m)^2: "+ computeBMI(inches, pounds) +" kg/m^2");
		
		
			
	}
}
