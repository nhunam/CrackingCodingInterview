package facebookonsite;

import java.util.ArrayList;
import java.util.List;

public class CheckSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canSwap("abcd", "dbca"));
	}
	
	static boolean canSwap(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		List<Integer> dif = new ArrayList<>();
		for (int i = 0; i<s1.length(); i++) {
			int c1 = s1.charAt(i);
			int c2 = s2.charAt(i);
			if(c1 != c2) {
					dif.add(i);
			}
		}
		return (dif.size() == 2 && s1.charAt(dif.get(0)) ==  s2.charAt(dif.get(1))) && (s2.charAt(dif.get(1)) ==  s1.charAt(dif.get(0)));
		
	}

}
