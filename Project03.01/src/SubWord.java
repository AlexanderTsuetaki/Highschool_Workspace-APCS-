/**
 * SubWord object contains the root word and the two interior
 * words that can be contained within it.
 * Example:	rootWord is "baseball"
 * 			sub words are "base" + "ball"
 * @author Alexander Tsuetaki
 * @version 12/05/2016
 */

import java.util.*;
public class SubWord implements Comparable<SubWord> {
	private String rootWord;
	private String sub1, sub2;
	
	/**
	 * Constructor for a SubWord object.  Start by supplying the
	 * root word for the object.
	 * @param root The rootWord value of this object.
	 */
	public SubWord(String root, String firstSub, String secondSub)	{
		rootWord = root;
		sub1 = firstSub;
		sub2 = secondSub;
	}
	
	/**
	 * Utility accessor method
	 * @return The rootWord of this object
	 */
	public String getRoot()	{	return rootWord;	}
	/**
	 * Utility accessor method
	 * @return The list of sub words
	 */
	public String getSubWords()	{	return sub1 + " + " + sub2;	}
	
	/**
	 * Compares two SubWord objects alphabetically A to Z based on rootWord
	 * @return -int if this.rootWord is less than other.rootWord, 0 if both 
	 * are equal, +int if this.rootWord is greater than other.rootWord
	 */
	public int compareTo(SubWord other)	{
		// override this invalid return statement
		for (int i = 0; i < other.rootWord.length();i++){
			if(this.rootWord.charAt(i)- other.rootWord.charAt(i) != 0){
				return this.rootWord.charAt(i)- other.rootWord.charAt(i);
			}
		}
		return 0;
	}
	
	/**
	 * @return This SubWord in root = sub1 + sub2 format
	 */
	public String toString()	{
		// define this method to return "rootWord = subWord1 + subWord2"
		String rts = rootWord + " = " + sub1 + " + " + sub2;
		return rts;
	}
}
