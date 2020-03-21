package ArrayAndString1;

public class IsUnique11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUnique("abckogwef"));
		String s = "helloword";
		int val = s.charAt(2);
		System.out.println(val);
	}
	
	static boolean isUnique(String s) {
		String temp = Character.toString(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if(temp.indexOf(c) != -1) return false;
			temp +=c;
		}
		return true;
	}
	
	static boolean isUnique2(String s) {
		boolean[] char_set = new boolean[128];
		for (int i = 1; i < s.length(); i++) {
			int val = s.charAt(i);
			if(char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
}
