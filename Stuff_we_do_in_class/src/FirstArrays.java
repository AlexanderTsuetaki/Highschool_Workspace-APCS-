
public class FirstArrays {
	public static void main(String[] args){
		String[] numerals = {"I","V","X","L","C","D","M"};
		int[] nums = {1,5,10,50,100,500,1000};
		for (int i=0; i<nums.length; i ++){
			System.out.println(numerals[i] +"=" +nums[i]);
		}
		int sum = 0;
		for (String s : args){
			//I'm going to find and output the Roman Numeral decimal value
			System.out.print(s);
			for( int x=0; x>s.length(); x++){
				System.out.print(s.substring(x,x+1));
			}
			System.out.println();
		}
	}
}
