
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Coin Sorter Machine class. sorts the values of money in a file and then returns the breakdown
 * @author 18tsuetaki
 *@version 2/1/17
 */
public class CoinSorterMachine {
	/**
	 * the arraylist that contains the coins
	 */
	private ArrayList<Coin> coins;
	// initializes coins ArrayList 
	/**
	 * the initializer of the coin sorter machine class. it initializes the arraylist of coins as a new arraylist
	 */
	public CoinSorterMachine(){
		ArrayList<Coin> coins = new ArrayList<Coin>();
	}
	// use one or two Scanner objects, prompting user for the appropriate file // name and importing the data from filename
	/**
	 * imports a file of the users choosing and then parses it and inputs the type of coin into the arraylist of coins
	 */
	public void depositCoins(){
		Penny penny = new Penny();
		Nickel nickel = new Nickel();
		Dime dime = new Dime();
		Quarter quarter = new Quarter();
		HalfDollar halfdollar = new HalfDollar();
		Dollar dollar = new Dollar();
		int num;
		coins = new ArrayList<Coin>();
		Scanner user_input = new Scanner(System.in);
		System.out.print("Enter the name of the data file for coin deposit: ");
		String testfile = user_input.nextLine(); 
		System.out.println("Depositing coins...");
		user_input.close();
		try{
			Scanner input = new Scanner(new File(testfile));
			while(input.hasNext()){
				num = Integer.parseInt(input.nextLine());
				if (num==(penny.getValue()*100)){
					coins.add(penny);
				}
				else if (num==(int)(nickel.getValue()*100)){
					coins.add(nickel);
				}
				else if (num==(int)(dime.getValue()*100)){
					coins.add(dime);
				}
				else if (num==(int)(quarter.getValue()*100)){
					coins.add(quarter);
				}
				else if (num==(int)(halfdollar.getValue()*100)){
					coins.add(halfdollar);
				}
				else if (num==(int)(dollar.getValue()*100)){
					coins.add(dollar);
				}		
			}
			input.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Homie dont play dat, error: unable to locate data file");
		}
	}
	
	// Prints deposit summary using a DecimalFormat object (see output section) 
	/**
	 * prints out the summarry of the deposit.
	 */
	public void printDepositSummary(){
		DecimalFormat formatter = new DecimalFormat("#0.00");     
		int[] nums = new int[6];
		for (int n = 0;n<6;n++){
			nums[n] = 0;
		}
		for (int i= 0 ; i< coins.size();i++){
			if(coins.get(i).getName().equals("Penny"))
				nums[0]+=1;
			if(coins.get(i).getName().equals("Nickel"))
				nums[1]+=1;
			if(coins.get(i).getName().equals("Dime"))
				nums[2]+=1;
			if(coins.get(i).getName().equals("Quarter"))
				nums[3]+=1;
			if(coins.get(i).getName().equals("HalfDollar"))
				nums[4]+=1;
			if(coins.get(i).getName().equals("Dollar"))
				nums[5]+=1;
		}
		System.out.println("Summary of deposit:");
		for(int j = 0; j<6;j++){
			if (j == 0){
				System.out.print("\t"+nums[j]+" ");
				if (nums[j] == 1)
					System.out.print("penny");
				else
					System.out.print("pennies");
				System.out.println(" $" + formatter.format(nums[j]*0.01));
			}
			if (j == 1){
				System.out.print("\t"+nums[j]+" ");
				if (nums[j] == 1)
					System.out.print("nickel");
				else
					System.out.print("nickels");
				System.out.println(" $" + formatter.format(nums[j]*0.05));
			}
			if (j == 2){
				System.out.print("\t"+nums[j]+" ");
				if (nums[j] == 1)
					System.out.print("dime");
				else
					System.out.print("dimes");
				System.out.println(" $" + formatter.format(nums[j]*0.10));
			}
			if (j == 3){
				System.out.print("\t"+nums[j]+" ");
				if (nums[j] == 1)
					System.out.print("quarter");
				else
					System.out.print("quarters");
				System.out.println(" $" + formatter.format(nums[j]*0.25));
			}
			if (j == 4){
				System.out.print("\t"+nums[j]+" ");
				if (nums[j] == 1)
					System.out.print("halfdollar");
				else
					System.out.print("halfdolars");
				System.out.println(" $" + formatter.format(nums[j]*0.50));
			}
			if (j == 5){
				System.out.print("\t"+nums[j]+" ");
				if (nums[j] == 1)
					System.out.print("dollar");
				else
					System.out.print("dollars");
				System.out.println(" $" + formatter.format(nums[j]));
			}
		}
		System.out.println("TOTAL DEPOSIT: "+getTotalValue());
		
		
	}
	// return the total value of all Coin objects stored in coins as a double 
	/**
	 * returns the total value of all of the coins in the arraylist of coins
	 * @return
	 */
	public double getTotalValue(){
		int total=0;
		for (int i= 0 ; i< coins.size(); i++){
			total += (int)(coins.get(i).getValue()*100);
		}
		return total/100.0;
		
	}
	/**
	 * the main method. Initializes the program and then runs it.
	 * @param args
	 */
	public static void main(String[] args){
		CoinSorterMachine app = new CoinSorterMachine();
		app.depositCoins();
		app.printDepositSummary();
	}
	
}
