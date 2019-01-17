package testCorrections5;
//from http://www.java2novice.com/java-sorting-algorithms/insertion-sort/ (sorry for being too lazy to copy from the sorting algorithms i already 
public class q21 {
	public static void main(String a[]){
        int[] arr1 = {71,86,79,36,78,35,75,86,24,11};
        int[] arr2 = doInsertionSort(arr1);
        for(int i:arr2){
            System.out.print(i);
            System.out.print(", ");
        }
    }
     
    public static int[] doInsertionSort(int[] input){
         
        int temp;
        for (int i = 1; i < input.length; i++) {
        	System.out.println();
        	for(int k:input){
        		System.out.print(k);
        		System.out.print(", ");
        	}
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }
    
}
