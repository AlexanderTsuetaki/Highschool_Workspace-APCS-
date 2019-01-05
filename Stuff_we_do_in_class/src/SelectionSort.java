import java.util.Arrays;

public class SelectionSort {
	public static void sort(int[] values){
		for(int i = 0;i<values.length;i++){
			int MIN = values[i];
			int index = i;
			for(int j = values[i]+1;j<values.length;j++){
				if (values[j]< MIN){
					MIN = values[j];
					index = j;
				}
			}
			int temp = values[i];
			values[i] = values[index];
			values[index] = temp;
		}
	}
	public static void main(String[] args){
		int[] nums = {17,3,5,7,-6,82,14,20,28,2};
		sort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
