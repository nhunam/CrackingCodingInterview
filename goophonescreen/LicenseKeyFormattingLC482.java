/*
 * You are given a license key represented as a string S which consists only alphanumeric character and dashes. The string is separated into N+1 groups by N dashes.

Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except for the first group which could be shorter than K, but still must contain at least one character. Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.

Given a non-empty string S and a number K, format the string according to the rules described above.

Example 1:
Input: S = "5F3Z-2e-9-w", K = 4

Output: "5F3Z-2E9W"

Explanation: The string S has been split into two parts, each part has 4 characters.
Note that the two extra dashes are not needed and can be removed.
Example 2:
Input: S = "2-5g-3-J", K = 2

Output: "2-5G-3J"

Explanation: The string S has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
Note:
The length of string S will not exceed 12,000, and K is a positive integer.
String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).
String S is non-empty.
 */
package goophonescreen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LicenseKeyFormattingLC482 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "5F3Z-2e-9-w";
		int K = 4;
		String s1 = "2-5g-3-J";
		String s2 = "2-4A0r7-4k";
		int k1 = 2;
		System.out.println(licenseKeyFormatting(s2, K));
	}
	
	public static String licenseKeyFormatting(String S, int K) {
		StringBuilder sb = new StringBuilder();
        String[] s = S.split("-");
        if (s.length == 1 && s[0].length() < K) {
            return s[0].toUpperCase();  
          }
        String tmp = "";
        for(int i = 0; i < s.length; i++) {
        	tmp += s[i];
        }
        String fi = "";
        int r = tmp.length() % K;
        if (r != 0) {
        	fi = tmp.substring(0, r);
        	sb.append(fi.toUpperCase());
        	sb.append("-");
        	tmp = tmp.substring(r, tmp.length());
        }
        String[] remain = tmp.split("(?<=\\G.{"+K+"})");
        for (int i = 0; i < remain.length; i++) {
        	sb.append(remain[i].toUpperCase());
        	if (i != remain.length-1)
        		sb.append("-");
        }
        return sb.toString();
    }

}
