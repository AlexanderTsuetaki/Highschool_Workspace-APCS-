/**
*It plays the text game thing that also does some maths
*@author Alexander Tsuetaki
*@version 09/15/2016
*/
import java.util.Scanner;

/**
 * the class that does the text based adventure thing
 */
public class SimpleIOMath {
	private int age;
	private String name;
	private int fav;
	
	/**
	 * returns a prime number
	 */
	private static int getUVA(int num){
		int re = 0;
		int temp = num;
		for(int i= 1; temp>1; i++){
			if(temp%2==0)
				temp=temp/2;
			else
				temp= temp*3+1;
			re++;
		}
		return re;
	}
	private static int getPrime(int num){
		for(int i = 2; i<=Math.sqrt(num); i++){
			if(num%i==0)
				return i;
		}	
		return num;
	}
	/**
	 * prompts the user for the info
	 */
	public void promptUser(){
		Scanner in = new Scanner(System.in);
		System.out.println("* Sit yourself down, take a seat *");
		System.out.println("* All you gotta do is repeat after me *");
		System.out.print("Question 1:what is your name");
		name = in.nextLine();
		System.out.print("Question2:what is your age");
		age = in.nextInt();
		System.out.print("Question 3:what is your favorite number");
		fav = in.nextInt();
	}
	/**
	 * prints info in a cool way
	 */
	public void printInfo(){
		System.out.println("I\'m gonna teach you how to sing it out");
		System.out.println("Come on, come on, come on");
		System.out.println("Let me tell you what it\'s all about");
		System.out.println("Reading, writing, arithmetic");
		System.out.println("Are the branches of the learning tree");
		System.out.println("Your name is: "+ name);
		System.out.println("Your age is: "+ age);
		int nage= age+1;
		System.out.println("At your next birthday, you will turn "+ nage);											
		System.out.println("The first prime factor of "+ age + " is:" + getPrime(age));
		System.out.println("Your favorite number is: "+ fav);
		System.out.println("Your favorite number squared is: "+fav*fav);
		System.out.println("If you took your favorite number and applied the formula if odd multiply by 3 and add 1 and if even divide by two, it takes " + getUVA(fav)+ " iterations to get to 1");
		System.out.println("* end of program *");
	}
	/**
	 * the main method
	 * @param args
	 */
	public static void main(String[] args){
		SimpleIOMath thing = new SimpleIOMath();
		thing.promptUser();
		thing.printInfo();
	}
}
