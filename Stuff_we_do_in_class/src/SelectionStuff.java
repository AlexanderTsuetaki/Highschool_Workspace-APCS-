import java.util.Random;
import java.util.Scanner;
import java.awt.Color;
import java.awt.color.*;
import java.lang.Math.*;
import java.util.ArrayList;
public class SelectionStuff {
	public static void main(String[] args){
		int[] n = fibbonacci(4);
		for(int i = 0; i< n.length;i++)
			System.out.println(n[i]);
		/*String[] randomLetters = new String[26];
		String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		//return letters[(int)(Math.random()*letters.length)];
		
		Random r= new Random();
		int b = letters.length;
		for(int i = 0; i<b;i++){
			String c = letters[r.nextInt(letters.length)];
			if (c.equals("0")){
				i--;
			}
			else{
				randomLetters[i] = c;
				for (int k = 0; k<letters.length;k++){
					if (letters[k].equals(c) ){
						letters[k] = "0";
					}
				}
			}
		}
		for (int j = 0; j<randomLetters.length;j++){
			System.out.print(randomLetters[j]);
		
	}*/
		/*8int[] temp = fibonacciArray(10);
		for (int i = 0; i<temp.length;i++){
			System.out.println(temp[i]);
		}/*
		//int[] numss = swapNums(nums);
		//insert(nums, 10,1);
		/*Scanner in = new Scanner(System.in);
		String one; int two;
		System.out.print("Enter a Color: ");
		one = in.nextLine();
		System.out.print("enter your age: ");
		two = in.nextInt();
		String[] colors = {"red","orange","yellow","green","blue","indigo","violet"};
		int compNumber = 14+(int)(Math.random()*5);
		String compColor = colors[(int)(Math.random()*colors.length)];
		boolean firstTest = one.equals(compColor);
		boolean secondTest = two==compNumber;
		
		if (firstTest)
			System.out.println("hey that"s my favorite color too!");
		else 
			System.out.println("I don't like that color "+ compColor + " is my favorite color");
		if (secondTest)
			System.out.println("hey that's my age to!");
		else 
			System.out.println("I don't like that age. "+ compNumber + " is my favorite age.");
		if (firstTest && secondTest)
			System.out.println("wow you are insane "+ one+ " is awsome and I am "+ two +" year old you... I think I love you");*/
	}
	public static double totalWages(double hours, double rate){
		double wages;
		if (hours<40.0)
			wages = hours*rate;
		else{
			wages = (40*rate)+(hours-40)*(rate)*(1.5);
		}
		return wages;
	}
	public static void coinCombinations(int amt) {
		//quarters
		int q = (int)(amt * (1.0/25));
		for (int qi = 0; qi <= q; qi++) {
			int d = (int)((amt - 25 * qi) * (1.0/10));
			for (int di = 0; di <= d; di++) {
				int n = (int)((amt - 25 * qi - 10 * di) * (1.0/5));
				for (int ni = 0; ni <= n; ni++) {
					int p = (int)((amt - 25 * qi - 10 * di - 5 * ni));
					System.out.println((amt + " cents = " + qi + " quarters + " + di + " dimes + " + ni + " nickels + " + p + " pennies"));
				}
			}
		}
	}
	public static int max2(int x, int y, int z){
		if (x>y&&x>z){
			return x;
		}
		if (y>x&&y>z){
			return y;
		}
		return z;
	}
	public static boolean isGeometricSequence(int a, int b, int c ){
		return a*b*c != 0 && a*c==b*b;
	}
	public static String isLeapYear(int year){
		if (year<60)
			return "F";
		else if (year<70)
			return "D";
		else if (year<80)
			return "C";
		else if (year<90)
			return"B";
		else
			return "A";
		
	}
	public static double timeToPopChange(double a){
		int year = 2014;
		double startingPop= 123.8;
		double pop = startingPop;
		double Growth =1.005;
		while (pop<a){
			pop*=Growth;
			year += 1;
		}
		
		return year;
	}

	public Color bestMatch(int r, int g, int b){
		if (r>g&&r>b){
			return Color.RED;
		}
		if(g>r&&g>b){
			return Color.GREEN;
		}
		if(b>r&&b>g){
			return Color.BLUE;
		}
		if (r==g){
			return Color.YELLOW;
		}
		if(g==b){
			return Color.CYAN;
		}
		if(b==r){
			return Color.MAGENTA;
		}
		return Color.GRAY;
		
	}
	public static boolean ifString2(String stra){
		int length = stra.length();
		System.out.println(length);
		if ((stra.substring(length-2,length).equals("**"))){ 
				return true;
		}
		return false;
	}
	public static String removeDashes(String number){
		String total = "";
		total = total +number.substring(0,3);
		total = total +number.substring(4,6);
		total = total +number.substring(7,11);
		return total;
	}
	public static String scroll(String insert){
		String total = "";
		total = total + insert.substring(1,insert.length())+ insert.substring(0,1);
		return total;
	}
	public static String replace(String insert){
		String total = "";
		for (int i = 0; i <insert.length();i++){
			if (insert.substring(i,i+1).equals("1"))
				total = total+"0";
			else if (insert.substring(i,i+1).equals("0"))
				total = total+"1";
			else
				total = total +" ";
		}
		return total;
	}
	public static boolean check(String insert){
		String total = "";
		total = total + insert.substring(1,insert.length())+ insert.substring(0,1);
		return total.equals(insert);
	}
	public static String cutOut(String str, String cut){
		int length = cut.length();
		for (int i = 0 ; i < str.length()-length; i++)
			if (str.substring(i,i+length).equals(cut)){
					return str.substring(0,i)+str.substring(i+length);
			}
		return str;
	}
	public static int indexOf(char ch, String fromPosition){
		for (int i = 0; i< fromPosition.length(); i++){
			if (fromPosition.substring(i,i+1).equals(ch))
				return i;
		}
		return 0;
	}
	public static void none(String s1, String s2, int n1, int n2){
		System.out.println(s1.compareTo(s2));
		System.out.println(n1-n2);
	}
	public static ArrayList<String> hw1(ArrayList<String> st){
		ArrayList<String> nArray = new ArrayList<String>();
		for (int i = 0; i<st.size();i++){
			nArray.add(st.get(st.size()-1-i));
		}
		return nArray;
	}
	public static ArrayList<Integer> sort(ArrayList<Integer> ins){
		Integer temp = ins.get(0);
		for (int i=1;i<ins.size();i++){
			temp = temp.compareTo(ins.get(i));
		}
		ins.remove(temp);
		return ins;
	}
	public static void filter(ArrayList<Object> list1,ArrayList<Object> list2){
		for (int i = 0; i<list2.size();i++){
			for (int j = list1.size()-1; j>=0;j--){
				if (list2.get(i)==list1.get(j)){
					list1.remove(j);
				}
			}
		}
		System.out.println(list1);
	}
	public static void removeConsecutiveDuplicates(ArrayList<String> lst){
		for (int i = lst.size()-1;i>0;i--)
			if(lst.get(i-1) == lst.get(i))
				lst.remove(i-1);		
	}
	public static boolean contains(String str, String sub)	{
		int length = sub.length();
		for (int i = 0; i<str.length()-length;i++){
			if (str.substring(i,i+length).equals(sub)){
				return true;
			}
		
		}
		return false;
		}
	public int[] swapNums(int[] nums){
		int[] temp = new int[10] ;
		for(int i = 0; i<nums.length;i++){
			temp[i] = nums[nums.length-1-i];
		}
		return temp;
	}
	public static void insert(int[] items, int value, int index)	{
		int[] temp = new int[items.length+1];
		for(int i = 0; i<index;i++){
			temp[i] = items[i];
		}
		temp[index] = value;
		for(int j = index+1;j<items.length+1;j++){
			temp[j] = items[j-1];
		}
		items = temp;
		}
	public static int[] fibbonacci(int n) {
		int a = 0; 
		int b = 0; 
		int c = 1; 
		int[] result = new int[n]; 
		for (int i = 0; i < n; i++) {
			a = b; 
			b = c; 
			result[i] = c;
			c = a + b;
			} 
			return result;
		}
	private static int sqrt(double d) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

