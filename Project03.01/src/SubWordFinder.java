/**
 * SubWordFinder takes a file full of words and parses out the ones that have subwords 
 * in them and then prints the, 
 * @author Alexander Tsuetaki
 * @version 12/05/2016
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class SubWordFinder implements WordFinder {
	private ArrayList<ArrayList<String>>Dictionary;
/**
 * initializes the dictionary with 26 buckets
 */
	public void subWordFinder(){
		Dictionary = new ArrayList<ArrayList<String>>();
		for (int i = 0;i<26;i++)
			Dictionary.add(new ArrayList<String>());
	}
	/**
	 * populates the buckets in dictionary with words corrilating with their first letter
	 */
	public void populateDictionary() {
		String al = "abcdefghijklmnopqrstuvwxyz";
		try{
			Scanner in = new Scanner(new File("words_all_os.txt"));
			String line;
			while(in.hasNext()){
				line = in.nextLine();
				Dictionary.get(line.charAt(0)-97).add(line);
				//al.indexOf(line.charAt(0))
			}
			in.close();
			}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	/**
	 * gets the subwords that are in the list of words
	 * @return the words with subwords in dictionary
	 */
	public ArrayList<SubWord> getSubWords() {
		// TODO Auto-generated method stub
		ArrayList<SubWord> subwords = new ArrayList<SubWord>();
		for(ArrayList<String> temp : Dictionary){
			//System.out.println(temp);
			for (String word : temp){
				//System.out.println(word);
				String sub1, sub2;
				for (int i = 1; i < word.length(); i++){
					sub1 = word.substring(0,i);
					sub2 = word.substring(i,word.length());
					if (inDictionary(sub1) && inDictionary(sub2)){
						subwords.add(new SubWord(word, sub1, sub2));
				}
			}
		}
	}
			return subwords;
	}
	
	/**
	 * checks if the subwords are in the dictionary themselves
	 * @param word
	 * @return boolean
	 */
	public boolean inDictionary(String word) {
		char c = word.charAt(0);
		int top = Dictionary.get(c-97).size()-1;
		int bottom = 0;
		int middle = (top+bottom)/2;
		if (indexOf(word, middle, c, top, bottom)>=0){
			return true;
		}
		return false;
	}
		/*
		if (word.length() > 0){
			char c = word.charAt(0);
			return Dictionary.get(c-97).indexOf(word) != -1;
			}
		else
			return false;
		
	}*/
	/**
	 * finds the index of a word in the bucket in dictionary and returns it
	 * @param word
	 * @param middle
	 * @param c
	 * @param top
	 * @param bottom
	 * @return index
	 */
	private int indexOf(String word, int middle, char c, int top, int bottom){
		while(true){
			//System.out.println(word+" " +Dictionary.get(c-97).get(middle));
			if (word.compareTo(Dictionary.get(c-97).get(middle))==0){
				return middle;
			}
			else if(word.compareTo(Dictionary.get(c-97).get(middle))>0){
				bottom = middle+1;
			}
			else if (word.compareTo(Dictionary.get(c-97).get(middle))<0){
				top = middle-1;
			}
			middle = ((top+bottom)/2);
			if(top<bottom){
				return -1;
			}
		}
	}
	/**
	 * the main method that makes the program run and then prints out the 
	 * words that have subwords in them 
	 * @param args
	 */
	public static void main(String[] args){
		SubWordFinder app = new SubWordFinder();
		app.subWordFinder();
		app.populateDictionary();
		ArrayList<SubWord> subwords = app.getSubWords();
		for(SubWord i:subwords){
			System.out.println(i.toString());
			i.compareTo(i);
		}
	}
}
