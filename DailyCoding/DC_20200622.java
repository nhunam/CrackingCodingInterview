/*
 * This problem was asked by Amazon.

Given a string s and an integer k, 
break up the string into multiple lines such that each line has a length of k or less. 
You must break it up so that words don't break across lines. 
Each line has to have the maximum possible amount of words. 
If there's no way to break the text up, then return null.

You can assume that there are no spaces at the ends of the string and 
that there is exactly one space between each word.

For example, given the string "the quick brown fox jumps over the lazy dog" and k = 10, 
you should return: ["the quick", "brown fox", "jumps over", "the lazy", "dog"].
 No string in the list has a length of more than 10.
 */
package DailyCoding;

import java.util.ArrayList;
import java.util.List;

public class DC_20200622 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<String> getList(String inp, int k){
		List<String> res = new ArrayList<String>();
		String[] spl = inp.split(" ");
		if(spl.length > 0) {
			String first = spl[0];
			if (first.length() > k) return null;
			int i = 0, len = 0;
			while (i < spl.length) {
				len += spl[i].length();
				if (len < k) {
					i++;
				}
			}
		}
		return res;
	}

}
