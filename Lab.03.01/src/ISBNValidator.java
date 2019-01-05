/**
 * imports the things needed for the thing
 */
import java.io.File;
import java.lang.Math;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class that checks to see if an ISBN number is valid
 * @author 18tsuetaki
 *
 */
public class ISBNValidator {
	private String[] validNums;
	private String[] invalidNums;
	
	/**
	 * constructor for the class
	 */
	public ISBNValidator(){
		validNums = new String[1000];
		invalidNums = new String[1000];
	}
	// imports .dat file, calls isValidISBN method and stores Strings into // corresponding arrays
	/**
	 * imports the data form the isbn files and checks if they are all valid and sorts them
	 */
	public void importData(){
		try{
			Scanner in = new Scanner(new File("isbn_files/isbn1.dat"));
			//PrintWriter pw = new PrintWriter( new FileWriter("isbn_files/converted.dat"));
			String baseNum;
			int counterV = 0;
			int counterI = 0;
			String temp = null;
			while(in.hasNext()){
				baseNum = in.nextLine();
				//System.out.println("TESTING"+ Arrays.toString(temp));		
					temp = baseNum.replace("-","");
					if (isValidISBN(temp)){
						//try {
						validNums[counterV] = baseNum;
						counterV++;
						//} catch (Exception e) {
						//	System.out.println(e);
						//}
					}
					else{
						invalidNums[counterI] = baseNum;
						counterI++;
					}
			}
			in.close();
			//pw.close();

		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Homie dont play dat, error: unable to locate data file");
		}
	}
	// determines validity of supplied ISBN number; called inside importData 
	/**
	 * checks if the ISBN numbers are correct 
	 * @param isbn
	 * @return boolean
	 */
	public boolean isValidISBN(String isbn){
		int temp = 0;
		for (int i = 0; i<isbn.length();i++){
			if(i%2==0){
				temp += Integer.parseInt(isbn.substring(i,i+1));
			}
			else{
				temp += Integer.parseInt(isbn.substring(i,i+1))*3;
			}
				
		}
		return (temp%10 == 0);
	}
	// output the user-picked ISBN list or quit the application 
	/**
	 * runs the program that and give the user choices and then prints out the list of numbers that the user wants
	 */
	public void runProgram(){
		Boolean t = true;
		while (t){
			String input = "";
			System.out.println("All ISBN data has been imported and validated. Would you like to:\n1) View all valid ISBN numbers \n2) View all invalid ISBN numbers \n3) Quit");
			System.out.print("Your selection: ");
			Scanner user_input = new Scanner( System.in );
			input= user_input.nextLine();
			int count= 0;
			try{
				if (Integer.parseInt(input) == 1){
					//System.out.println(Arrays.toString(validNums));
					for (String i:validNums){
						if (i == null){
							break;
						}
						System.out.println(i);
						count++;
					}
					System.out.println(count);
				}
				else if (Integer.parseInt(input) ==2){
					//System.out.println(Arrays.toString(invalidNums));
					for (String i:invalidNums){
						if (i == null){
							break;
						}
						System.out.println(i);
						count++;
					}
					System.out.println(count);
				}
				else{
					user_input.close();
					t= false;
				}
			}
			catch(Exception e){
				user_input.close();
				t= false;
			}
		}
		
	}
	/**
	 * the main method. makes the ISBNValidaor program run and then ends the program.
	 * @param args
	 */
	public static void main(String[] args){
		ISBNValidator app = new ISBNValidator();
		System.out.println("* ISBN Validator Program *"); 
		System.out.println("...Importing data...");
		app.importData(); // imports data from the text file 
		app.runProgram(); // runs using a while loop; see examples 
		System.out.println("* End of Program *");
		}
}
