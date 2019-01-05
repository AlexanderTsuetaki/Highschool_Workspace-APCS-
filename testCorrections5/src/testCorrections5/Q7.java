package testCorrections5;
//base case is the point where the scenerio is terminated and thus it is when n<=1;
public class Q7 {
	public int factorial(int n){
		int product = 1;
		if(n>1)
			product = n*factorial(n-1);
		return product;
	}
}
