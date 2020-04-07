/*
 * Group Anagrams: Write a method to sort an array ot strings so that all the anagrams are next to
each other.
 */
package SearchingAndSorting10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GroupAnagrams102 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(checkAnagram("baa", "cab"));
		List<String> li = new ArrayList<String>();
		li.add("abcd");
		li.add("bcad");
		li.add("dcab");
		li.add("cdae");
		
		Collections.sort(li, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				//return checkAnagram(s1, s2) ? -1 : 1;
				return sort(s1).compareTo(sort(s2));
			}
		});
		
		for(String l : li) {
			System.out.println(l);
		}
	}
	
	static String sort(String s) {
		char[] c = s.toCharArray();
		java.util.Arrays.sort(c);
		return new String(c);
	}

	static boolean checkAnagram(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		int[] count = new int[26];
		char[] c1 = s1.toCharArray();
		for (int i = 0; i < c1.length; i++) {
			int as = c1[i] - 'a';
			count[as]++;
		}
		
		char[] c2 = s2.toCharArray();
		for (int i = 0; i < c2.length; i++) {
			int as = c2[i] - 'a';
			count[as]--;
			if(count[as] < 0) return false;
		}
		
		return true;
	}
}
