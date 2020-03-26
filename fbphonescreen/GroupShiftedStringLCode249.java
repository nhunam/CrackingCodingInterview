/*
 * Caesar Cipher Encrpytion
You are given a list of string, group them if they are same after using Ceaser Cipher Encrpytion.
Definition of "same", "abc" can right shift 1, get "bcd", here you can shift as many time as you want, the string will be considered as same.

Example:

Input: ["abc", "bcd", "acd", "dfg"]
Output: [["abc", "bcd"], ["acd", "dfg"]]
 */

package fbphonescreen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStringLCode249 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> inputs = new ArrayList<>();
		inputs.add("abc");
		inputs.add("bcd");
		inputs.add("acd");
		inputs.add("dfg");
		inputs.add("a");
		inputs.add("b");
		inputs.add("abcd");
		inputs.add("defg");
		inputs.add("");
		inputs.add("");
		
		Map<String, List<String>> res = GroupShiftString(inputs);
		for (Map.Entry<String, List<String>> entry : res.entrySet()) {
			System.out.println(entry.getValue());
		}
	}
	
	public static Map<String, List<String>> GroupShiftString(List<String> strs){
		Map<String, List<String>> res = new HashMap<>();
		
		for (String s: strs) {
			if(s == "") {
				List<String> empty = res.get("empty");
				if (empty == null) {
					empty = new ArrayList<>();
				}
				empty.add(s);
				res.put("empty", empty);
			}
			char[] arr = s.toCharArray();
			String hash = "";
			for (int i = 0; i < arr.length; i++) {
				int dif = arr[i] - arr[0];
				hash += Integer.toString(dif);
			}
			
			// add to the Map
			List<String> ls = res.get(hash);
			if (ls == null) {
				ls = new ArrayList<>();
				
			}
			ls.add(s);
			res.put(hash, ls);
		}
		return res;
	}


}
