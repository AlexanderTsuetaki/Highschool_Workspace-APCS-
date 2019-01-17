package testCorrections5;

public class Q16 {
	public static void q(){
		int[] b = {1,2,3,4,5};
		for (int j = 0;j<b.length;j++){
			int k = b.length - 1-j;
			int temp = b[j];b[j] = b[k]; b[k] = temp;
		}
		for(int i = 0;i< 5;i++){
			System.out.print(b[i]);
		}
	}
	public static void main(String[] args){
		q();
			
		
	}
}
