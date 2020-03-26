package ArrayAndString1;

public class CheckPermutation12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkPermu("abcdef", "fbdace"));
	}
	
	public static boolean checkPermu(String s1, String s2) {
		// if character is only ASCII
		// Time complexity: O(n+m): n length string s1, m length string s2
		if(s1.length() != s2.length()) return false;
		int[] char_count = new int[128];
		
		for(int i = 0; i < s1.length(); i++) {
			int val = s1.charAt(i);
			char_count[val]++;
		}
		
		for(int j = 0; j < s2.length(); j++) {
			int va = s2.charAt(j);
			char_count[va]--;
			if(char_count[va] < 0) return false;
		}
		
//		for (int i = 0; i < char_count.length; i++) {
//			if(char_count[i] != 0) return false;
//		}
		
		return true;
	}

}
