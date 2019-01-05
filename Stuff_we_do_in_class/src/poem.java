public abstract class poem {
	public abstract int numLines();
	public abstract int getSyllables(int k);
	
	public void printRhythm(){
		for(int k = 1;k <=numLines();k++){
			int count = getSyllables(k);
			for (int i = 1; i <= count;i++){
				System.out.print("ta");
				if(i < count )
					System.out.print("-");
			}
			System.out.println();
		}
	}
	public static void main (String[] args){
		poem p1 = new Haiku();
		p1.printRhythm();
		System.out.println();
		poem p2 = new Limerick();
		p2.printRhythm();
	}
}
