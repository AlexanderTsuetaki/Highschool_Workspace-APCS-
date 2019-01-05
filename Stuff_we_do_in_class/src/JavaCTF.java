/**
 * Class JavaCTF is a test of your problem-solving skills, patience and
 * collective brain power. You must be clever and think on your feet!
 * @author Julian Cochran
 * @version 2.1 October 11, 2016
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaCTF {
	private String al;
	private ArrayList<String> als;
	
	/**
	 * Default constructor for class JavaCTF
	 */
	public JavaCTF()	{
		al = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
		char c = (char)(32 % (int)(Math.pow(2, 6)));
		String [] chs = al.split(""+c);
		als = new ArrayList<String>(Arrays.asList(chs));
		als.add(""+c);
	}
	
	/**
	 * This is question 1. Solve it!
	 * @param cipher It's a secret -- SHHHHHH....
	 * @return I'm not going to tell you that...
	 */
	public boolean question1(String cipher)	{
		String en = cipher.toUpperCase();
		int zz = -1;
		String hash = "";
		String bash = "23111310562182672317211223212617726253217111321262562425718";
		for(int i = 0; i < en.length(); i++)	{
			zz = als.indexOf(en.substring(i, i+1));
			hash += (zz == 26) ? zz+"" : (25-zz)+"";
		}
		System.out.println(hash.equals(bash) ? "Correct! Write down your answer to #1 in your Google doc." : "Incorrect; try again");
		return hash.equals(bash);
	}
	
	/**
	 * This is question 2.  Solve it!
	 * @param cipher It's a secret -- SHHHHHH....
	 * @return I'm not going to tell you that...
	 */
	public boolean question2(String cipher)	{
		try	{
			String[] iCanHasItemz = cipher.toUpperCase().split(" ");
			String en = "";
			for(int x = 0; x < iCanHasItemz.length-1; x++)
				en += (iCanHasItemz[x] + " ");
			int shoop = Integer.parseInt(iCanHasItemz[iCanHasItemz.length-1]);
			int zz = -1;
			String hash = "";
			String bash = "15101875171626141126151317513426016";
			for(int i = 0; i < en.length()-1; i++)	{
				zz = als.indexOf(en.substring(i, i+1));
				hash += (zz == 26) ? zz+"" : ((zz+shoop)%26)+"";
			}
			System.out.println(hash.equals(bash) ? "Correct! Write down your answer to #2 in your Google doc." : "Incorrect; try again");
			return hash.equals(bash);
		}
		catch(Exception e)	{
			System.out.println("Incorrect; try again");
			return false;
		}
	}
	
	/**
	 * This is question 3.  Solve it!
	 * @param cipher It's a secret -- SHHHHHH....
	 * @return I'm not going to tell you that...
	 */
	public boolean question3(String cipher)	{
		String hash = "";
		for(int x = 0; x < cipher.length(); x++)
			hash += "" + (int)cipher.charAt(x);
		String bash = "10511011632109971051104011811110510041";
		System.out.println(hash.equals(bash) ? "Correct! Write down your answer to #3 in your Google doc." : "Incorrect; try again");
		return hash.equals(bash);
	}
	
	/**
	 * Main method for class Friday9_12
	 * @param args Command-line arguments, if needed.
	 */
	public static void main(String[] args)	{
		JavaCTF muhahahaha = new JavaCTF();
		Scanner in = new Scanner(System.in);
		System.out.println("* A chat with the bridge keeper *");
		System.out.println("Stop. Who would cross the Bridge of Death must answer me these questions three, ere the other side he see.");
		System.out.println("King Arthur would tell you, \"Case sensitivity doesn't matter to me...I am king!\n");
		boolean[] q = new boolean[3];
		
		//question 1
		System.out.print("Question 1 (30 points): Tell me how you REALLY feel: ");
		q[0] = muhahahaha.question1(in.nextLine());
		//question 2
		System.out.print("Question 2 (40 points): Whoop-dee-doo! Borat says, \"Tell me if you're confused and add a number too.\": ");
		q[1] = muhahahaha.question2(in.nextLine());
		//question 3
		System.out.print("Question 3 (30 points): K&R entry? ");
		q[2] = muhahahaha.question3(in.nextLine());
		
		if(q[0] && q[1] && q[2])
			System.out.println("*** YOU HAVE SUCCEEDED IN YOUR 100-POINT QUEST! SUBMIT YOUR GOOGLE DOC THROUGH VERACROSS. ***");
		else	{
			int points = 90;
			points += q[0] ? 3 : 0;
			points += q[1] ? 3 : 0;
			points += q[2] ? 4 : 0;
			System.out.println("*** YOUR CURRENT SCORE IS " + points + ". SUBMIT YOUR GOOGLE DOC THROUGH VERACROSS OR TRY RUNNING THIS AGAIN. ***");
		}
	}
}

// end of class JavaCTF