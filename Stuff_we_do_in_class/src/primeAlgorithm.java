import java.util.Scanner;

public class primeAlgorithm {
	public static boolean isPrime(int num){
		for(int i = 2; i<=Math.sqrt(num); i++){
			if(num%i==0)
				return false;
		}
		return true;
				
	}
	public static void main(String[] args) {
		int num;
		Scanner in = new Scanner(System.in);
		do{
			System.out.print("enter a number to test or 0 to quit");
			num = in.nextInt();
			if (isPrime(num))
				System.out.print (12 +" is prime");
			else
				System.out.print(12 + " is not prime");
		}while(num != 0);
		System.out.print("buh bye");
	}
	/*public static void main(String[] args){
		if(isPrime(12))
			System.out.print (12 +" is prime");
		else
			System.out.print(12 + " is not prime");
	}*/
}
