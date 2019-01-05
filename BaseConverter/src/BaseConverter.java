/**
 * imports
 */
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
import java.math.*;
import java.io.PrintWriter;
import java.io.FileWriter;
/**
 * Class that converts a number in any base 2-16 to a number in any base 2-16 
 * @author 18tsuetaki
 * @version 10/25/16
 */
public class BaseConverter {
	/**
	 * Constructor for class.
	 */
	public BaseConverter(){
		
	}
	/**
	 * the digit Map to be used to assign value to letters and numbers in a string
	 */
	public final String digitMap= "0123456789ABCDEF";
	/**
	 * Converts a number in the base fromBase into a number in base 10	
	 * Convert a String num in fromBase to base-10 int.	
	 * @param num
	 * @param fromBase
	 * @return
	 */
	public int strToInt(String num, String fromBase){
		int total = 0;
		int exp = 0;
		int base = Integer.parseInt(fromBase);
		for (int i=num.length()-1;i>=0;i--){
			total += digitMap.indexOf(num.substring(i,i+1))*Math.pow(base,exp);
			exp++;
		}
		return total;
	}
	/**
	 * converts a base 10 number in to a number in base to Base
	 * Convert a base-10 int to a String number of base toBase.
	 * @param num
	 * @param toBase
	 * @return
	 */
	public String IntToStr(int num, int toBase){
		String result = "";
		int remainder = 0;
		if (num == 0){
			return "0";
		}
		while (num>0){
			remainder= num%toBase;
			result = digitMap.substring(remainder,remainder+1)+result;
			num /= toBase;
		}
		return result;
	}
	/**
	 * Opens the file stream, inputs data one line at a time, converts, prints 
	 * the result to the console window and writes data to the output stream.
	 */
	public void inputConvertPrintWrite(){
		try{
			Scanner in = new Scanner(new File("dataFiles/values10.dat"));
			PrintWriter pw = new PrintWriter( new FileWriter("datafiles/converted.dat"));
			String baseNum,fromBase;
			int toBase;
			while(in.hasNext()){
				String[] temp = in.nextLine().split("\t");
				//System.out.println("TESTING"+ Arrays.toString(temp));
				baseNum = temp[0];
				fromBase = temp[1];
				toBase = Integer.parseInt(temp[2]);
				//System.out.print(fromBase);
				String Base1 = "\t"+strToInt(baseNum,fromBase)+"\t 10\t";
				//System.out.println(strToInt(baseNum,fromBase)+" base 10");
				String Base2 = IntToStr(strToInt(baseNum,fromBase),toBase) +"\t"+ toBase;
				if (Integer.parseInt(fromBase) > 1 && Integer.parseInt(fromBase)<17 && toBase>1 && toBase<17){
					System.out.println(baseNum+" base "+fromBase+" = "+IntToStr(strToInt(baseNum,fromBase),toBase)+" base "+ toBase);
					pw.println(baseNum + "\t" + fromBase + "\t" + Base2);
				}
				else{
					System.out.print("Invalid " );
					if(Integer.parseInt(fromBase) < 1 || Integer.parseInt(fromBase)>16){
						System.out.println("input base "+Integer.parseInt(fromBase));
					}
					else{
						System.out.println("output base "+toBase);
					}
				}
			}
			in.close();
			pw.close();

		}
		catch(Exception e){
			System.out.println("Homie dont play dat, error: unable to locate data file");
		}
	}
	/**
	 * the main method that calls the inputConvetrPrintWrite Method
	 * Main method for class BaseConverter. 
	 * @param args
	 */
	public static void main(String[] args){
		BaseConverter app = new BaseConverter();
		app.inputConvertPrintWrite();
	}
}
