
public abstract class Animal {
	private int numLegs;
	private Boolean isFemale;
	private Boolean hasFur;
	private Boolean hasFeathers;
	public Animal(int i, boolean f, boolean fur, boolean feathers){
		numLegs = i;
		isFemale = f;
		hasFur = fur;
		hasFeathers = feathers;
	}
	public String toString(){
		return null;
		
	}
	public abstract String speak();
		return "A " + ((isFemale)? "female")
}
