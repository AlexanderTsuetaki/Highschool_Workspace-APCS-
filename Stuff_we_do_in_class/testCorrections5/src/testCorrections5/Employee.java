package testCorrections5;

public class Employee {
	String name = "";
	double yearsOfService = 0;
	int ID = 0;
	public int compareTo(Employee other){
		if(this.getName().compareTo(other.getName())==0){
			if(this.getYearsOfService()-(other.getYearsOfService())==0){
				return this.getID()-other.getID();
			}
			else if(this.getYearsOfService()-(other.getYearsOfService())>0){
				return 1;
			}
			else{
				return -1;
			}
		}
		return this.getName().compareTo(other.getName());
	}
	public String getName(){return name;}
	public double getYearsOfService(){return yearsOfService;}
	public int getID(){return ID;}
	
}
