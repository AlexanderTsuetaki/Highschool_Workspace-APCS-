import java.util.Arrays;
import java.util.Random;
public class RPS {
	public static char getRandomRPS(){
		char[] letters = {'r','r','r','p','p','p','p','p','s','s','s','s','s','s'};
		//return letters[(int)(Math.random()*letters.length)];
		
		Random r= new Random();
		return letters[r.nextInt(letters.length)];
	}
	public static void init(){
		int[] nums = {1,2,4};
		int total = 0;
		for (int i = 0; i<nums.length;i++){
			total += nums[i];
		}
	}
	public static int[] change(int[] nums){
		int temp = nums[nums.length-1];
		nums[nums.length-1] = nums[0];
		nums[0]= temp;
		return nums;
	}
	public int[][] checkDiag2Darray(int n){
		int[][] nums = new int[n][n];
		int[] diag = new int[n*n];
		int c=0;
		for (int i = 0;i<n;i++ )
			for (int j= 0;j<n;j++)
				if ((i+j ==n)||(i==j)){
					diag[c]=nums[i][j];
					c++;
				}
		return nums;
	}
	public static double positiveMax(double[][] m){
		double max = 0.0;
		for (int i= 0;i<m.length;i++){
			for (int j=0;j<m[i].length;j++){
				if (m[i][j]>max){
					max = m[i][j];
				}
			}
		}
		if (max<0.0){
			return 0.0;
		}
		return max;
	}
	public static int sumList(int[]m){
		int total = 0;
		for(int i:m){
			total+=i;
		}
		return total;
	}
	public static int[] sumLists(int[][]m){
		int total = 0;
		int[] sumlist= new int[m.length];
		for(int j = 0; j<m.length;j++){
			total = 0;
			for(int i:m[j]){
				total+=i;
			}
			sumlist[j]=total;
		}
		return sumlist;	
	}

	public static boolean check(int[] nums){
		return nums[0] == nums[nums.length-1];
	}
	public static int[] fibonacci(int n){
		int[] fib= new int[n+1];
		for (int i = 0; i<=n;i++){
			if (i == 0 ){
				fib[i]= 0;
			}
			else if (i==1){
				fib[i]= 1;
			}
			else
				fib[i] = fib[i-1]+fib[i-2];
		}
		return fib;
	}
	public static boolean isValidISBN(String isbn){
		int temp = 0;
		for (int i = 0; i<isbn.length();i++){
			if(i%2==0){
				temp += Integer.parseInt(isbn.substring(i,i+1));
			}
			else{
				temp += Integer.parseInt(isbn.substring(i,i+1))*3;
			}
			System.out.println(temp);
				
		}
		return (temp%10 == 0);
	}
	public static void main(String args[]){
		System.out.println(isValidISBN("9759727361581"));
	}
}
