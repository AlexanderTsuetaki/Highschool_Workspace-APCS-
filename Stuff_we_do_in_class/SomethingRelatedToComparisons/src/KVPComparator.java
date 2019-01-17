import java.util.Comparator;

public class KVPComparator implements Comparator<KeyValuePair>{
	private boolean asc;
	private int ktv;
	public KVPComparator(){
		asc = true;
		ktv = 0;
	}
	public KVPComparator(boolean sort, int ktvs){
		asc = sort;
		ktv = ktvs;
	}
	@Override
	public int compare(KeyValuePair kvp1, KeyValuePair kvp2){
		int diff = kvp1.getKey()-kvp2.getKey();
		if(ktv ==0){
			if (diff == 0)
				diff = kvp1.getValue().compareTo(kvp2.getValue());
		}
		else{
			diff = kvp1.getValue().compareTo(kvp2.getValue());
			if(diff == 0){
				diff = kvp1.getKey()-kvp2.getKey();
			}
		}
		return (asc)?diff:-diff;
	}
}
