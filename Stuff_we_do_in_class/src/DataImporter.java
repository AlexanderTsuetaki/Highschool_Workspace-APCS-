import java.util.Scanner;
import java.io.File;
public class DataImporter {
	private String[] words;
	public DataImporter(){
		words = new String[200000];
	}
	public void importData(){
		try{
			Scanner in = new Scanner(new File("words_all_os.txt"));
			int index = 0;
			while(in.hasNext()){
				words[index] = in.nextLine();
				index++;
			}

			
		}
		catch(Exception e){
			//e.printStackTrace();
			System.out.println("Error opening or reading data file.");
		}
		
	}
	public void outputData(){
		for(String word:words)
			if (word != null)
				System.out.println(word);
	}
	public String getRawNum(String sample){
		String newNum = new String();
		for(int i = 0; i <sample.length();i++)
			if (Character.isDigit(sample.charAt(i))){
				newNum+=sample.charAt(i);
			}
		return newNum;
	}
	public static void main(String[] args){
		DataImporter app = new DataImporter();
		app.importData();
		app.outputData();
		System.out.println(app.getRawNum("978-7092-2345-12"));
	}
}
