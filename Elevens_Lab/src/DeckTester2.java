/**
 * This is a class that tests the Deck class.
 * @author Alex Tsuetaki(editor)
 * @version 4/18/17
 */
public class DeckTester2 {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		String[] str1 = {"Jack","Queen","King"};
		String[] str2 = {"Green","Black"};
		int[] str3 = {11,12,13};
		Deck2 deck1 = new Deck2(str1,str2,str3);
		String[] str4 = {"Null","Void"};
		String[] str5 = {"0","-"};
		int[] str6 = {10,1};
		Deck2 deck2 = new Deck2(str4,str5,str6);
		String[] str7 = {"Tank","LMG","MMG","HMG","Rifle","Grenade"};
		String[] str8 = {"German","French","English","American"};
		int[] str9 = {20,5,8,10,3,4};
		Deck2 deck3 = new Deck2(str7,str8,str9);
		System.out.print(deck1.toString());
		System.out.print(deck2.toString());
		System.out.print(deck3.toString());
	}
}
