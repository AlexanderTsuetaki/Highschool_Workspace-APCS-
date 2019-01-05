
public class Limerick extends poem {
	@Override
	public int numLines() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getSyllables(int k) {
		if (k <= 2){
			return 9;
		}
		else if ( k <= 4)
			return 6;
		else
			return 9;
		// TODO Auto-generated method stub
	}
}
