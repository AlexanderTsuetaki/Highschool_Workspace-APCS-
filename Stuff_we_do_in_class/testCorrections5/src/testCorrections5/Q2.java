package testCorrections5;

public class Q2 {
	public int someFun(int n){
		if(n == 3){
			System.out.println("3");
		}
		if(n <=0){
			return 2;
		}
		else{
			int x = someFun(n-1);
			return x*x;
		}
	}
	public int someFun2(int n){
		if(n == 3){
			System.out.println("3");
		}
		if (n <=0){
			return 2;
		}
		else{
			return someFun2(n-1)*someFun2(n-1);
		}
		
	}
	public Q2(){
		
	}
	public static void main(String[] args){
		Q2 q = new Q2();
		q.someFun(5);
		System.out.println("end");
		q.someFun2(5);
	}
}

