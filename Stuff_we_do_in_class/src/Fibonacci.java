
public class Fibonacci {
	public static int count = 0;
	public static int fibonacciIter(int n ){
			if (n == 1) return 0;
			else if ( n == 2) return 1;
			else{
				int n1 = 0;
				int n2= 1;
				int temp = 0;
				int i = 0;
				while (i+2 < n){
					temp = n2;
					n2 = n1+n2;
					n1 = temp;
					i++;
				}
				return n2;
			}
	}
	public static int fibonacciRecursion(int n){
		count+=1;
		if (n ==1) return 0;
		else if (n==2) return 1;
		else {
			return fibonacciRecursion(n-2) + fibonacciRecursion(n-1);
		}
	}
	public static void main(String[] args){
		System.out.println(fibonacciIter(1));
		System.out.println(fibonacciIter(9));
		System.out.println(fibonacciIter(10));
		System.out.println(fibonacciRecursion(9));
		System.out.println(count);
	}
}
