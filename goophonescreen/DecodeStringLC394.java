/*
 * Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
 */
package goophonescreen;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DecodeStringLC394 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "3[a2[c]]";
		String s1 = "2[abc]3[cd]ef";
		System.out.println(decodeString(s));
	}
	
	public static String decodeString(String s) {
		StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	st.push(c);
        }
        char c;
        StringBuilder tmp = new StringBuilder();
        while (!st.isEmpty()) {
        	c = st.pop();
        	if(Character.isAlphabetic(c))
        		sb.insert(0, c);
        	if(c == ']') {
        		c = st.pop();
	        	if (Character.isAlphabetic(c)) {
	        		tmp.insert(0, c);
	        	}
        	}
        	if (c == '[') {
        		c = st.pop();
	        		if (Character.isDigit(c)) {
	        		for (int i = 0; i < Character.getNumericValue(c) - 1; i++) {
	        			sb.insert(0, tmp);
	        		}
	        	}
        	}
        }
        return sb.toString();
    }

}
