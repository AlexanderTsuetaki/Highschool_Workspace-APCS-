
public class Thoroughbred implements Horse {
	private String name;
	private int weight;
	private int mph;
	
	public Thoroughbred(String n, int w, int mp)	{
		name = n;
		weight = w;
		mph = mp;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getWeight() {
		return weight;
	}
	
	public int getSpeed()	{
		return mph;
	}
	
	public String toString()	{
		return name + " (thoroughbred)";
	}

}
