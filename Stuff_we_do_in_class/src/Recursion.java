

public class Recursion {
	public static int c1= 0;
	public static int c2 =0;
	public static void printStars(int n){
		for(int i = 0; i<n;i++){
			System.out.print("*");
		}
	}
	private static void printTriangleASC(int n){
		if (n == 0){
			return;
		}
		printTriangleASC(n-1);
		printStars(n);
		System.out.println();
		
	}
	public static void enigma(int n){
		for (int i = 0;i<n;i++)
			enigma(i);
		System.out.println(n);
	}
	private static void printTriangeDSC(int n){
		printStars(n);
		System.out.println();
		if (n == 1){
			return;
		}
		printTriangeDSC(n-1);
	}
	public static int multiply(int n1, int n2){
		if (n2 == 1)
			return n1;
		return n1+multiply(n1,n2-1);
	}
	public static boolean isGood(String s){
		int n = s.length();
		return n<2||s.charAt(0) == s.charAt(n-1)&&isGood(s.substring(1, n-1));
	}
	public int factorial(int n){
		if (n==1){
			return 1;
		}
		return factorial(n-1)*n;
	}
	public static int sumDigits(int n){
		if (n<10){
			return n;
		}
		else
			return sumDigits(n/10)+n%10;
	}
	public static int power3(int n){
		if (n ==0){
			return 1;
		}
		else{
			int p = power3(n/2);
			p*=p;
			System.out.print("*");
			if(n%2==1){
				p*=3;
				System.out.print("*");
			}
			return p;
		}
	}
	public static boolean divsb3(int n)
	{
		if (n < 10)
				return n == 3 || n == 6 || n == 9;
		else
				return divsb3(sumDigits(n));
	}
	public int foo(int[] arr, int x)	{
		for(int i = 0; i < arr.length; i++)	{
			if(arr[i] == x)
				return i;
		}
		return -1;
	}

	public void fooTest()	{
		int[] vals = {1, 4, 51, 3, 14, 91, 130, 14};
		for(int i = 0; i < 20; i++)	{
			if(foo(vals, i%4) < 0)
				System.out.println("African or European?");
		}
	}
	public static void main(String[] args) {
		Recursion r = new Recursion();
		r.fooTest();
	}


}
