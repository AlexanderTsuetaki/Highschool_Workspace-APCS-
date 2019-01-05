import java.util.Arrays;
public class Lockers {
	
	public static void Lockers(){
			}
	
	public static void main(String[] args){
		int counter0 = 0;
		boolean[] Locker = new boolean[500];
		for (int i= 0; i<500; i++){
			Locker[i] =  true;
		}
		for (int j=2; j<500; j+=3){
			Locker[j] = false;
		}
		for (int k = 0; k<(500); k++){
			if (Locker[k] == true){
				counter0++;
				if (counter0 >1){
					Locker[k] = false;
					counter0 = 0;
				}
			}
		}
		for (int l= 5; l<500; l+=6){
			Locker[l] = true;
		}
		counter0 = 0;
		for (int m= 0; m<500; m++){
			if (Locker[m] == true){
				counter0++;
				if (counter0 >4){
					Locker[m] = false;
					counter0 = 0;
				}
			}
				
		}
		for (int n = 1; n<500;n=((2*n)+1)){
			Locker[n] = false;
		}
		counter0 = 0;
		for (int o= 0; o<500; o++){
			if (Locker[o] == true){
				counter0++;
				if (counter0>3){
					Locker[o] = false;
					counter0 = 0;
				}
			}
		}
		int counter = 0;
		for (int a=0;a<500;a++){
			if (Locker[a] == true){
				System.out.print(a+1);
				System.out.print(" ");
				counter++;
			}
		}
		System.out.println("");
		//String array = Arrays.toString(Locker);
		//System.out.println(array);
		System.out.println(counter);
		
	}
		
}
