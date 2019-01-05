package testCorrections5;

import java.util.ArrayList;

public class Q6 {
	public ArrayList<Integer> nums;
	public static void printprobability(int n){
		if (n <= 1)
			System.out.print(1);
		else{
			printprobability(n-1);
			System.out.println();
			for(int i = (int) Math.pow(2,(n-1));i>=1;i--){
				if(n == 4)
					System.out.print(3);
				else
					System.out.print(1*n);
			}
		}
	}
	public static void main(String[] args){
		printprobability(4);
		System.out.println();
		System.out.println("3*8+3*4+2*2+1=49 || 41/15 is about 2.75");
			
		
	}
}
 