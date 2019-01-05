import java.util.*;
import java.io.File;
import java.util.ArrayList;
/**
 * Scrabble Scorer returns the score of a word in terms of the scrabble scoring system
 * @author 18tsuetaki
 * 11/28/16
 */
public class ScrabbleScorer {
	/**
	 * Initial declaration statements
	 */
	private ArrayList<String> myDictionary;
	int[] nums = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
	private String lett="abcdefghijklmnopqrstuvwxyz";
	
	/**
	 * initializes the myDictionary array List
	 */
	public ScrabbleScorer(){
		myDictionary = new ArrayList<String>();
		}
	/**
	 * puts all the values from SCRABBLE_WORDS.txt in to the myDictionary arraylist
	 */
	public void buildDictionary(){
		Scanner in = null;
		try{
			in = new Scanner(new File("SCRABBLE_WORDS.txt"));	
			while (in.hasNext()){
				myDictionary.add(in.nextLine());
			}
		in.close();
		Collections.sort(myDictionary);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	//public boolean isValidWord(String word)
	//public int getWordScore(String word)
	/**
	 * checks of the word is in myDictionary
	 * @param word
	 * @return boolean
	 */
	public boolean isValidWord(String word){
		if (Collections.binarySearch(myDictionary,word,null)<0){
			return false;
		}
		return true;
	}
	/**
	 * gets the score of the word 
	 * @param word
	 * @return total
	 */
	public int getWordScore(String word){
		int total = 0;
		for (int i = 0; i<word.length();i++){
			total+= nums[lett.indexOf(word.substring(i,i+1))];
		}
		return total;
	}
	/**
	 * the main method. takes the words from the user and prints out strings depending on what is entered
	 * and then quits when 0 is put into the user prompt area
	 * @param args
	 */
	public static void main(String[] args){
		Scanner user_input = new Scanner( System.in );
		String userIn = "";
		ScrabbleScorer app = new ScrabbleScorer();
		app.buildDictionary();
		System.out.println("* Welcome to the Scrabble Word Scorer app *");
		do {System.out.print("Enter a word to score or 0 to quit: ");
		userIn= user_input.nextLine();
		if (userIn.equals("0")){
			break;
		}
		if (app.isValidWord(userIn.toUpperCase())){
			System.out.println(userIn +" = "+ app.getWordScore(userIn.toLowerCase())+" points");
		}
		else{
			System.out.println(userIn + " is not a valid word in the dictionary");
		}
		}while(!(userIn.equals("0")));
		user_input.close();
		System.out.println("Exiting the program thanks for playing");
	}
}
