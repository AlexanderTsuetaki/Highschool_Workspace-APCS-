import java.util.Arrays;

public class Mergesort {
	private static int[] temp;
	// Sorts a[0], ..., a[a.length-1] in ascending order
	//   using the Mergesort algorithm.
	public static void sort(int[] a)	{
		int n = a.length;
		temp = new int[n];
		recursiveSort(a, 0, n-1);
	}

	// Recursive helper method: sorts a[from], ..., a[to]
	private static void recursiveSort(int[] a, int from, int to)	{
		if (to - from < 2)	{	// Base case: 1 or 2 elements
			if (to > from && a[to] < a[from])	{
				// swap a[to] and a[from]
				int aTemp = a[to]; a[to] = a[from]; a[from] = aTemp;
			}
	    }
	    else	{                   // Recursive case
	    		int middle = (from + to) / 2;
	    		recursiveSort(a, from, middle);
	    		recursiveSort(a, middle + 1, to);
	    		merge(a, from, middle, to);
	    }
	  }

	  // Merges a[from] ... a[middle] and a[middle+1] ... a[to]
	  //   into one sorted array a[from] ... a[to]
	  private static void merge(int[] a, int from, int middle, int to)	{
		  int i = from, j = middle + 1, k = from;
		  
		  // While both arrays have elements left unprocessed:
		  while (i <= middle && j <= to)	{
			  if (a[i] < a[j])	{
				  temp[k] = a[i];   // Or simply temp[k] = a[i++];
				  i++;
			  }
			  else	{
				  temp[k] = a[j];
				  j++;
			  }
			  k++;
			  
		}

	    // Copy the tail of the first half, if any, into temp:
	    while (i <= middle)	{
	    		temp[k] = a[i];     // Or simply temp[k++] = a[i++]
	    		i++;
	    		k++;
	    }

	    // Copy the tail of the second half, if any, into temp:
	    while (j <= to)	{
	      temp[k] = a[j];     // Or simply temp[k++] = a[j++]
	      j++;
	      k++;
	    }
	    

	    // Copy temp back into a
	    for (k = from; k <= to; k++)
	      a[k] = temp[k];
	    System.out.println("Merging: " + Arrays.toString(temp));
	  }
	  public static void main(String[] args){
		  int[] nums = {17,3,5,7,-6,82,14,20,28,2};
		  System.out.println("** Before sort:\n" + Arrays.toString(nums));
		  sort(nums);
		  System.out.println("** After sort:\n" + Arrays.toString(nums));
	  }
}
