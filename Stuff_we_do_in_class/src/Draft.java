

public class Draft implements Horse {
	private String name;
	private int weight;
	private int towWeight;
	
	public Draft(String n, int w, int tow)	{
		name = n;
		weight = w;
		towWeight = tow;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public int getWeight() {
		return weight;
	}
	public int getMyPayload()	{
		return towWeight;
	}

	public String toString()	{
		return name + " (draft horse)";
	}
}

