
public class KevinLearning {
	public static void main(String[] args){
		double notLearned = 100.0;
		int counter = 0;
		double total = 0.0;
		while (total < 95.0){
			total += notLearned/10;
			notLearned = notLearned/10*9;
			counter+=1;
			System.out.println(total);
			System.out.println("one more month has passed, it has been "+counter+" months");
		}
	}
}
