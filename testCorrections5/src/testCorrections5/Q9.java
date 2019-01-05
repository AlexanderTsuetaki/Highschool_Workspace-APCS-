package testCorrections5;

public class Q9 {
	public class Student{
		public Student(){
			
		}
		// overides the object equals method versus making a different comparison between two students. 
		public boolean equals(Object other){
			return false;
		}
		public boolean equals2(Student other) {
			return false;
		}
	}
}

