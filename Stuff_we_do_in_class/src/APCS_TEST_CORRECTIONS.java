import java.util.ArrayList;

public class APCS_TEST_CORRECTIONS {
	public class Animal{
		public void eat(){
			
		}
	}
	public class Bear extends Animal{
		public void growl(){
			
		}
	}
	public class Foo{
		private String boo;
		private int woo;
		private boolean shmoo;
		
		public Foo(){
			boo = new String();
			woo = 0;
			shmoo = false;
		}
		public Foo(Foo Bar){
			
		}

	}
	private class ClassName{
		public String variableName = new String();
		
	

		public char[] getValue(ClassName objName) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	public abstract class Account{
		public Account(){
			
		}
	}
	public class BankAccount extends Account{
		private double balance;
		public BankAccount(double amount){
			super();
			balance = amount;
		}
	}
	public class CheckingAccount extends BankAccount{
		private String customerName;
		public CheckingAccount(String name, double amount){
			super(amount);
			customerName = name;
		}
	}
	public class Book{
		int pages;
		Book (int n){
			pages = n;
		}
	}
	public class Novel extends Book{
		int pages;
		Novel(int n){
			super(n);
		}
	}
	public interface InterfaceA{
		public void methodA();
	}
	public interface InterfaceB{
		public void methodB();
	}
	public abstract class ClassA implements InterfaceA{
		public void methodA(){
			
		}
		public void methodB(){
			
		}
	}
	public class ClassB extends ClassA implements InterfaceB{
		
	}
	public interface TV{
		void tuneTo(String channel);
	}
	public class MyTV implements TV{
		private ArrayList<String> myFacotiteChannels;
		public MyTV(ArrayList<String> channels){
			
		}
		public void tuneTo(int k){
			
		}
		public void tuneTo(int k , String Channel){
			
		}
		@Override
		public void tuneTo(String channel) {//Here
			// TODO Auto-generated method stub
			
		}
	}
	
	public class Employee implements Comparable<Employee>{
		private String fName,lName;
		private String ssNum;
		private Integer id;
		public Employee(String fn, String ln, String ss){
			fName = fn;lName = ln;ssNum = ss;
			id = new Integer(ssNum.substring(0, 3)+ssNum.substring(4,6)+ssNum.substring(7));
		}
		public String getFirstName(){
			return fName;
		}
		public String getLastNam(){
			return lName;
		}
		public String getSSNum(){
			return ssNum;
		}
		public int getID(){
			return id;
		}
		public int compareTo(Employee other){
			return this.ssNum.compareTo(other.ssNum);
		}
	}
	public class HourlyEmployee extends Employee implements Comparable<Employee>{
		private double wage;
		public HourlyEmployee(String fn, String ln, String ss, double w){
			super(fn,ln,ss);
			wage = w;
		}
		public int compareTo(Employee other){
			if(other instanceof HourlyEmployee){
				Double d1 = new Double(this.wage);
				Double d2 = new Double (((HourlyEmployee)other).wage);
				return d2.compareTo(d1);
			}
			else{
				return super.compareTo(other);
			}
		}
		public int compareTo(HourlyEmployee other){
			Double d1 = new Double(this.wage);
			Double d2 = new Double (((HourlyEmployee)other).wage);
			return d2.compareTo(d1);
		}
	}
	public class Person{
		private String name;
		
		public Person(String nm){name = nm;}
		public String getName(){return name;}
		public String toString(){return getName();}
		
	}
	public class ElderlyPerson extends Person{
		private int age;
		private boolean isMale;
		public ElderlyPerson(String nm,boolean male, int yrs){
			super(nm);
			age = yrs;
			isMale = male;
		}
		public String getName(){
			return((isMale)? "Mr.":"Ms.")+ super.getName();
		}
		public int getAge(){
			return age;
		}
	}
	public class Fraction implements Comparable<Fraction>{
		private int num, denom;
		public Fraction(int n, int d){
			num = n; denom = d;
		}
		public int getNum(){return num;
		}
		public  int getDenom(){return denom;}
		public double doubleValue(){
			return (double)num/denom;
		}
		public int compareTo(Object other){
			Fraction f = (Fraction)other;
			return getNum()*f.getDenom()- getDenom()*f.getNum();//q23 doesnt work
		}
		public int compareTo(Fraction other){//does work
			double x = doubleValue();
			double y = other.doubleValue();
			if(x<y)
				return -1;
			else if (x<y)
				return 1;
			else
				return 0;
		}
		
	}
	public abstract class Pet{
		private String name;
		public Pet (String petName) {name = petName;}
		public String getName(){return name;}
		public abstract String speak();
	}
	public class Dog extends Pet{
		public Dog(String petName){
			super(petName);
		}
		public String speak(){
			
		}
	}
	public class cat extends Pet{//A
		public cat(String petName){
			super(petName);
		}
		public String speak(){
			return "meow";
		}
	}
	public class LoudDog extends Dog{
		public LoudDog(String petName){
			super(petName);
		}
		public String speak(){
			return super.speak().toUpperCase()+super.speak().toUpperCase();
		}
	}
	public class Kennel{
		private ArrayList<Pet> petList;
		public void allSpeak(){
			for (int i = 0;i<petList.size();i++){
				System.out.print(petList.get(i).getName());
				System.out.println(petList.get(i).speak());
			}
		}
	}
	public static void main(String[] args){
		String newValue = "Hello";
		APCS_TEST_CORRECTIONS AP = new APCS_TEST_CORRECTIONS();
		Animal b = AP.new Bear();
		b.eat();
		b.growl();//here
		((Bear)b).growl();
		
		ClassName objName = new ClassName();
		System.out.println(objName.getValue(objName));
		objName.variableName= newValue;
		
		CheckingAccount acct1 = new BankAccount(100.00);//here
		Account acct2 = new BankAccount(100.00);
		BankAccount acct3 = new CheckingAccount("Joe Smith",100.00);
		
		Book b2 =new Book(450);
		Novel n = new Novel(450);
		
		b2 = new Novel(450);
		n2 = new Book(450);//Here
		
		InterfaceB[] obj = new InterfaceB[2];
		InterfaceA obj = new ClassA();//Here
		
		Person p = new ElderlyPerson("Robinson", false, 92);
		System.out.println(p+", "+ ((ElderlyPerson)p).getAge());//Mrs.Robinson, 92
		
		Integer i = new Integer(123);
		System.out.println(i.compareTo("123"));//error, points back? q22
	}
	
}
