/**
*it changes a Roman numeral to a decimal value. it takes invalid input, but goes through illogical input
*@author Alexander Tsuetaki
*@version 10/4/2016
*/
public class RomanToDecimal{
	/**
	 * the romanToDecmial function. It does the actual work and changes the Roman numerals to decimals then outputs a int with the correct numbers
	 * @param roman
	 * @return
	 */
	public static int romanToDecimal(String roman){
		String numerals ="IVXLCDM";
		int[] nums = {1,5,10,50,100,500,1000};
		int total = 0;
		String let  = null;
		//System.out.println("length of " + let + " = "+ let.length());
		for (int i=0; i<roman.length();i++){
			let = roman.substring(i,i+1);
			if (numerals.indexOf(let) != -1)
				total += nums[numerals.indexOf(let)];
			else 
				return -1;
	
		}
		if (roman.indexOf("IV")!=-1)
			total-=2;
		if (roman.indexOf("IX")!=-1)
			total-=2;
		if (roman.indexOf("XL")!=-1)
			total-=20;
		if (roman.indexOf("XC")!=-1)
			total-=20;
		if (roman.indexOf("CD")!=-1)
			total-=200;
		if (roman.indexOf("CM")!=-1)
			total-=200;
		return total;
		
	}
	/*public static String decimalToRoman(String roman){
			String newNum ="";
			int a = 0;
			a+=(roman.length());
			System.out.print(a);
			int n=0;
			for (int j = 0;j<roman.length();j++){
				//the place values over 4
				if (a>=4){
					if (roman.substring(j) == "1" ){
						n=1;
					}
					else if (roman.substring(j) == "2" ){
						n=2;
					}
					else if (roman.substring(j) == "3" ){
						n=3;
					}
					else if (roman.substring(j) == "4" ){
						n=4;
					}
					else if (roman.substring(j) == "5" ){
						n=5;
					}
					else if (roman.substring(j) == "6" ){
						n=6;
					}
					else if (roman.substring(j) == "7" ){
						n=7;
					}
					else if (roman.substring(j) == "8" ){
						n=8;
					}
					else if (roman.substring(j) == "9" ){
						n=9;
					}
					else if (roman.substring(j) == "0" ){
						n=0;
					}
				for (int t=0; t<(((int)Math.pow(10.0, ((j-3)+1)))*n);t++)
					newNum=newNum.concat("M");
				a-=1;
			
				if (a==3){
					if (roman.substring(j) == "1" ){
						newNum=newNum.concat("C");
					}
					else if (roman.substring(j) == "2" ){
						newNum=newNum.concat("CC");
					}
					else if (roman.substring(j) == "3" ){
						newNum=newNum.concat("CCC");
					}
					else if (roman.substring(j) == "4" ){
						newNum=newNum.concat("CD");
					}
					else if (roman.substring(j) == "5" ){
						newNum+="D";
					}
					else if (roman.substring(j) == "6" ){
						newNum+="DC";
					}
					else if (roman.substring(j) == "7" ){
						newNum+="DCC";
					}
					else if (roman.substring(j) == "8" ){
						newNum+="DCCC";
					}
					else if (roman.substring(j) == "9" ){
						newNum+="CM";
					}
					a-=1;
				}
				if (a==2){
					if (roman.substring(j) == "1" ){
						newNum+="X";
					}
					else if (roman.substring(j) == "2" ){
						newNum+="XX";
					}
					else if (roman.substring(j) == "3" ){
						newNum+="XXX";
					}
					else if (roman.substring(j) == "4" ){
						newNum+="XL";
					}
					else if (roman.substring(j) == "5" ){
						newNum+="L";
					}
					else if (roman.substring(j) == "6" ){
						newNum+="LX";
					}
					else if (roman.substring(j) == "7" ){
						newNum+="LXX";
					}
					else if (roman.substring(j) == "8" ){
						newNum+="LXXX";
					}
					else if (roman.substring(j) == "9" ){
						newNum+="XC";
					}
					a-=1;
				}
				if (a==1){
					if (roman.substring(j) == "1" ){
						newNum+="I";
					}
					else if (roman.substring(j) == "2" ){
						newNum+="II";
					}
					else if (roman.substring(j) == "3" ){
						newNum+="III";
					}
					else if (roman.substring(j) == "4" ){
						newNum+="IV";
					}
					else if (roman.substring(j) == "5" ){
						newNum+="V";
					}
					else if (roman.substring(j) == "6" ){
						newNum+="VI";
					}
					else if (roman.substring(j) == "7" ){
						newNum+="VII";
					}
					else if (roman.substring(j) == "8" ){
						newNum+="VIII";
					}
					else if (roman.substring(j) == "9" ){
						newNum+="IX";
					}
					a=-1;
				}
				}
			}
			return newNum;
		}
		*/
	/**
	 * the main method. it plays the function and takes outside input for the run configurations menu it prints out a function 
	 * @param args
	 */
	public static void main(String[] args){
		for(String arg : args){
			/*if (arg.contains("1")||arg.contains("2")||arg.contains("3")||arg.contains("4")||arg.contains("5")||arg.contains("6")||arg.contains("7")||arg.contains("8")||arg.contains("9")||arg.contains("0")){
				System.out.print("input: " + arg + " => " + "output: ");
				String Rome = (decimalToRoman(arg));
				System.out.println(Rome);
			}
			else{*/
				System.out.print("input: " + arg.toUpperCase() + " => " + "output: ");
				int Rome = (romanToDecimal(arg.toUpperCase()));
				if  (Rome != -1 )
					System.out.println(Rome);
				else
					System.out.println("invalid");
			//}
		}
	}
}
