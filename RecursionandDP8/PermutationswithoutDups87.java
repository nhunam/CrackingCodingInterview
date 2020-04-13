package RecursionandDP8;

import java.util.ArrayList;
import java.util.List;

public class PermutationswithoutDups87 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> arr = permu("abcde");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		
	}

	static List<String> permu(String s){
		if (s.length() == 0) return new ArrayList<>();
		List<String> arr = new ArrayList<>();
		if(s.length() == 1) {
			arr.add(s);
			return arr;
		}
		char c = s.charAt(0);
		StringBuilder s1 = new StringBuilder(s);
		s1.delete(0,1);
		List<String> tmp = permu(s1.toString());
		for (int i = 0; i < tmp.size(); i++) {
			for(int j = 0; j <= s1.length(); j++) {
				StringBuilder sb = new StringBuilder(tmp.get(i));
				sb.insert(j, c);
				arr.add(sb.toString());
			}
		}
		
		return arr;
	}
	
}
