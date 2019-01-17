import java.util.Random;

/**
 * This class provides a convenient way to test shuffling methods.
 * @author Alex Tsuetaki(editor)
 * @version 4/18/17
 */
public class Shuffler3 {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 5;


	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
		for(int k = 0;k<9;k++)
			System.out.println(flip());
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		int[] perfect = new int[values.length];
		int a = 0;
		for(int i = 0; i <values.length/2;i++){
			perfect[a] = values[i];
			a+=2;
		}
		a = 1;
		for(int j = values.length/2; j <values.length;j++){
			perfect[a] = values[j];
			a+=2;
		}
		for(int i = 0; i <values.length;i++){
			values[i] = perfect[i];
		}
		
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		int rand = 0;
		Random r = new Random();
		int temp = 0;
		for(int i =values.length-1;i>0;i--){
			rand = r.nextInt(i);
			temp = values[i];
			values[i] = values[rand];
			values[rand] = temp;
		}
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
	}
	public static String flip() {
		int rand = 0;
		Random r = new Random();
		int temp = 0;
		rand = r.nextInt(3);
		if (rand>0){
			return "Heads";
		}
		else
			return "Tails";
		}
	public static boolean arePermutations(int[] a1, int[] a2) {
		int length = a1.length;
		boolean isIn = true;
		for(int i= 0;i<a1.length;i++){
			isIn = false;
			for(int j= 0;j<a1.length;j++){
				if (a1[i] == a2[j])
					isIn = true;
			}
			if (isIn = false){
				return false;
			}
		}
		return true;
	}
}
