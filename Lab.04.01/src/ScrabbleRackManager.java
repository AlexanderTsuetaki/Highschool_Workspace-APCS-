import java.util.*;
import java.io.*;
/**
 * tells you what words you can possibly use with the tiles in your hand in a scarbble game
 * @author 18tsuetaki
 * @version 1/17/17
 */
public class ScrabbleRackManager {
	private ArrayList<String> masterLetters;
	private ArrayList<String> tileRack;
	private ArrayList<String> dataBase;
	private static ArrayList<Integer> sortedBase;
	private static ArrayList<Integer> sortedRack;
	/**
	 * constructor for the ScrabbleRackManager class
	 */
	public ScrabbleRackManager(){
		String tiles = "";
		String Answer = "";
		Scanner user_input = new Scanner( System.in );
		dataBase = new ArrayList<String>();
		String letters = "EEEEEEEEEEEEAAAAAAAAAIIIIIIIIIOOOOOOOOTTTTTTRRRRRRNNNNNNLLLLSSSSUUUUDDDDGGGBBCCMMPPFHHWWYYKJXQZ";
		tileRack = new ArrayList<String>();
		masterLetters = new ArrayList<String>();
		for(int i = 0; i<letters.length();i++){
			masterLetters.add(""+letters.charAt(i));
		}
		Collections.shuffle(masterLetters);
		//System.out.print("type 1 for random letters, or 2 to submit your own letters");
		//Answer = user_input.next();
		//if (Answer.equals("1")){
			for(int j = 0; j<7;j++){
				tileRack.add(masterLetters.remove((int)Math.random()*masterLetters.size()));
			}
		//}
		//else{
			//System.out.println("enter your letters");
			//tiles = user_input.next();
			//for(int p = 0;p<tiles.length();p++){
			//	tileRack.add(tiles.substring(p, p+1));
			//}
		//}
		sortedBase = new ArrayList<Integer>();
		for (int i = 0; i<26;i++){
			sortedBase.add(0);
		}
		sortedRack = new ArrayList<Integer>();
		for (int i = 0; i<26;i++){
			sortedRack.add(0);
		}
	}
	/**
	 * constructs a dictionary from SCRABBLE_WORDS.txt
	 */
	public void getPlaylist(){
		Scanner in = null;
		try{
			in = new Scanner(new File("SCRABBLE_WORDS.txt"));	
			while (in.hasNext()){
				dataBase.add(in.nextLine());
			}
		in.close();
		Collections.sort(dataBase);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * sorts the users rack into a array list of integers with each index representing a letter(0-A, 1-B, 2-C...)
	 * @param word
	 */
	private static void sort(String word){
		for(int j =0;j<26;j++){
			for(int i = 0; i<word.length();i++){
				if (word.charAt(i)-65 == j ){
					sortedRack.set(j,sortedRack.get(j)+1);;
				}
			}
		}
	}
	/**
	 *  sorts the words being tried into a array list of integers with each index representing a letter(0-A, 1-B, 2-C...)
	 * @param word
	 */
	private static void sortWords(String word){
		for(int j =0;j<26;j++){
			for(int i = 0; i<word.length();i++){
				if (word.charAt(i)-65 == j ){
					sortedBase.set(j,sortedBase.get(j)+1);;
				}
			}
		}
	}
	/**
	 * compares the two array lists of integers and returns false if the sorted base has more of a letter than the users rack
	 * @return boolean
	 */
	private Boolean compare(){
		for(int i = 0; i < sortedRack.size();i++){
			if (sortedRack.get(i)<sortedBase.get(i)){
				return false;
			}
		}
		return true;
	}
	/**
	 * prints the users Rack
	 */
	public void printRack(){	
		String track = "";
		for (int i = 0; i <tileRack.size();i++){
			track = track + tileRack.get(i);
		}
		System.out.println("Letters in the rack: "+tileRack);
		sort(track);
	}
	/**
	 * prints the words that can be made with the rack
	 */
	public void printMatches(){
		int counter = 0;
		int counter2 = 0;
		System.out.println("You can play the following words from the letters in your rack:");
		while(dataBase.size()> counter){
			sortWords(dataBase.get(counter));
			if (compare()){
				counter2+=1;
				System.out.print(dataBase.get(counter));
				if (dataBase.get(counter).length()  == 7){
					System.out.print("*");
				}
				System.out.print("\t");
				if (counter2%10 == 0){
					System.out.println();
				}
			}
			for(int k = 0;k<26;k++){
				sortedBase.set(k,0);
			}
			counter+=1;
		}
		System.out.println();
		if(counter2 == 0){
			System.out.println("Sorry, NO words can be played from those tiles.");
		}
		System.out.println("* denotes BINGO");
	}
	/**
	 * the main method of ScrabbleRackManager
	 * @param args
	 */
	public static void main(String[] args){
		ScrabbleRackManager app = new ScrabbleRackManager();
		app.getPlaylist();
		app.printRack();
		app.printMatches();
	}
}
