/**
 * This is a class that plays the GUI version of the Elevens game.
 * See accompanying documents for a description of how Elevens is played.
 * @author Alex Tsuetaki(editor)
 * @version 4/18/17
 */
public class ElevensGUIRunner9 {

	/**
	 * Plays the GUI version of Elevens.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		Board9 board = new ElevensBoard9();
		CardGameGUI9 gui = new CardGameGUI9(board);
		gui.displayGame();
		
	}
}
