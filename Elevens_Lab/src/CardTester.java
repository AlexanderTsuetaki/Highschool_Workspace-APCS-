import java.util.ArrayList;

/**
 * This is a class that tests the Card class.
 * @author Alex Tsuetaki(editor)
 * @version 4/18/17
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("10","Spade",10));
		cards.add(new Card("Ace","Spade",1));
		cards.add(new Card("Queen","Hearts",12));
		for (int i = 0;i<3;i++){
			System.out.println(cards.get(i));
		}
		
	}
}
