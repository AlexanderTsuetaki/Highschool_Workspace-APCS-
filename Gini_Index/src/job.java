
public class job {
	private String name;
	private int income;
	public job(String n, int i){
		name = n;
		income = i;
	}
	public String getName(){
		return name;
	}
	public int getIncome(){
		return income;
	}
	public int compare(Object other){
		if(other instanceof job){
			return (other.getIncome()-this.getIncome());
		}
	}
	
}
