import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;

public class KVPDB {
	private ArrayList<KeyValuePair> database;
	
	public KVPDB() {
		database = new ArrayList<KeyValuePair>();
		try {
			Scanner in  = new Scanner(new File("kvp_big.txt"));
			String[]temp ;
			while(in.hasNextLine()){
				temp = in.nextLine().split("\t");
				database.add(new KeyValuePair(Integer.parseInt(temp[0]),temp[1]));
			}
			in.close();
			Collections.sort(database, new KVPComparator(false,1));
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void printDB(){
		for (KeyValuePair kvp:database)
			System.out.println(kvp);
	}
	public void sortPromptAndDisplay(){
		int aod = 0;
		boolean a = true;
		int kov = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("input 0 if accending and 1 if decending");
		aod = Integer.parseInt(in.nextLine());
		System.out.println("input 0 if bykey and 1 if byValue");
		kov = Integer.parseInt(in.nextLine());
		if (aod == 0){
			a = true;
		}
		else{
			a = false;
		}
		Collections.sort(database, new KVPComparator(a,kov));
		printDB();
		in.skip("\n");
	}
	public static void main(String[]  args){
		KVPDB k = new KVPDB();
		k.printDB();
	}
}
