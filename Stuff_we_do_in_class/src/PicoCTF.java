import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PicoCTF {
	public ArrayList<String> myDictionary;
	public void populateList(){
		Scanner in = null;
		try{
			in = new Scanner(new File(".txt"));	
			while (in.hasNext()){
				myDictionary.add(in.nextLine());
			}
		in.close();
		Collections.sort(myDictionary);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public String findQ1(){
		for(int i = 0;i< myDictionary.size();i++){
			if(myDictionary.get(i).substring(0,5).equals("Robin")){
				if(myDictionary.get(i).substring(myDictionary.get(i).length()-6,myDictionary.get(i).length()).equals("Robin")){
					return myDictionary.get(i);
				}
			}
		}
		return null;
	}
	public String findQ(){
		String al ="";
		for (int i = 0;i<546;i++){
			al =al+"V"; 
		}
		return al+"9";
	}
	PicoCTF(){
		myDictionary = new ArrayList<String>();
	}
	
	
	public static void main(String[] args){
		PicoCTF P = new PicoCTF();
		
		System.out.println(P.findQ());
	}
}
