import java.util.ArrayList;
import java.util.Arrays;
public class ListExamples {
	public static void main(String[] args){
		int[] nums = {2,4,6,8,10,12,14,16,18};
		ArrayList<Integer> myList = new ArrayList<Integer>();
		myList.add(0);
		myList.add(1);
		myList.add(2);
		myList.add(0,0);
		myList.add(1,1);
		myList.add(2,2);
		
		//myList.add(8);
		System.out.println(myList);
		
	}
}
