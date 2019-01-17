/**
 * q2 a,b
 * @author 18tsuetaki
 *
 */
public class q2 {
	public String decodeString(ArrayList<StringPart> parts){
		String total = "";
		for (part:parts){
			total+= master.substring(part.getStart(),part.getStart()+part.getLength();
		}
	}
	public ArrayList<StringPart> encodeString(String word){
		ArrayList<StringPart> arr = new ArrayList<StringPart>;
		int c = 0;
		while (word.length()<=0){
			arr.add(word.findPart());
			word= masterString.substring(arr.get(c).getStart()+arr.get(c).getLength());
			c++;
		}
		return arr;
	}
}
