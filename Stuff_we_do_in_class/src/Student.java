
public class Student {
	private String fName, lName;
	private int age, grade;
	private double gpa;
	
	/**
	 * class constructor for Student
	 */
	public Student(String nf, String ln, int a, int gr,double gp){
		fName=nf;
		lName=ln;
		age= a;
		grade= gr;
		gpa= gp;
		};
		/**
		 * 
		 * accessor method for clas student
		 */
		public String getFirstName(){return fName;}
		public String getLastName(){return lName;}
		public int getAge(){return age;}
		public int getGrade(){return grade;}
		public double getGPA(){return gpa;}
		
		public void setFristname(String newFristName){
			fName=newFristName;
		}
		public void setLastname(String newLastName){
			fName=newLastName;
		}
		public void setAge(int newAge){
			age=newAge;
		}
		public void setGrade(int newGrade){
			grade=newGrade;
		}
		public void setGPA(double newGPA){
			gpa=newGPA;
		}
	public boolean equals(Object other){
		Student temp = (Student)other;
		return this.fName.equals(temp.fName) && this.lName.equals(temp.lName) && this.age==temp.age && this.grade == temp.grade && 
				this.gpa == temp.gpa;
	}
		
	public static void main(String[] args){
		Student s= new Student("Nijel","Hunt",17,12,4.62);
		//Student s2=s;
		//Student s2= new Student("Nijel","Hunt",17,12,4.62);
		//if (s==s2){
			//System.out.println("they are equal");
		//}
		//else{
			//System.out.print("they are not equal");
		//}
		//if (s.equals(s2)){
			//System.out.println("they are equal");
		//}
		//else{
			//System.out.print("they are not equal");
		//}
		System.out.print(s);
	};
};
