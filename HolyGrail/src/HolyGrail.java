/**
*It does that
*@author Alexander Tsuetaki
*@version09/07/2016
*/

import java.util.Scanner;

public class HolyGrail {
	/**
	 * Main method for the class HolyGrail. The entry point
	 * @param args command line arguments if needed
	 */
	public static void main(String[] args){
		Scanner user_input = new Scanner( System.in );
		System.out.println("* A chat with the bridge keeper *");
		System.out.println("Who would cross the Bridge of Death must answer me these questions three, ere the other side he see.");
		System.out.println("Question 1: What is your name?");
		String name;
		name = user_input.nextLine( ); 
		System.out.println("Question 2: What is your quest?");
		String quest;
		quest = user_input.nextLine( ); 
		System.out.println("Question 3: What is your favorite color?");
		String color;
		color= user_input.nextLine( );
		System.out.println("King Arthur says, \"You have to know these things when you\'re a king, you know.\"");
		System.out.println("Your name is: " +name);
		System.out.println("Your quest is: " +quest);
		System.out.println("Your favorite color is: " +color);
		System.out.println("* end of program *");
		System.out.println();
		}
	}