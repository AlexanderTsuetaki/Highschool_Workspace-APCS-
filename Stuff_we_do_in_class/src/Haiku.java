
public class Haiku extends poem {

	@Override
	public int numLines() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getSyllables(int k) {
		if (k != 2){
			return 5;
		}
		else
			return 7;
		// TODO Auto-generated method stub
	}

}
