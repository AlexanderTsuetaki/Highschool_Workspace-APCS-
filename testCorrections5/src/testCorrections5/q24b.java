package testCorrections5;

import java.util.ArrayList;

public class q24b {
	public ArrayList<Employee> merge (ArrayList<Employee>  list1, ArrayList<Employee> list2){
		int i = list1.size();
		int j = list2.size();
		ArrayList<Employee> result = new ArrayList<Employee>();
		while(i>0&&j>0){
			if(list1.get(i).compareTo(list2.get(i))>0){
				result.add(list2.get(j));
				j--;
			}
			else if(list1.get(i).compareTo(list2.get(i))<0){
				result.add(list1.get(i));
				i--;
			}
			else{
				result.add(list1.get(i));
				i--;
				j--;
			}
		}
		if(i>0){
			for (int a = 0;a<i;i--){
				result.add(list1.get(i));
			}
		}
		else{
			for(int a = 0;a<j;j--){
				result.add(list2.get(j));
			}
		}
		return result;
	}
}
