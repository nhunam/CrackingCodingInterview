package ArrayAndString1;

public class IsPalindPermu14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindPermu("abccddfba"));
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		System.out.println(a);
		System.out.println(z);
	}
	
	static boolean isPalindPermu(String s) {
		if (s.length() <= 1) return true;
		int[] char_set = new int[128];
		
		for(int i = 0; i < s.length(); i++) {
			int val = s.charAt(i);
			if(val !=32)
				char_set[val]++;
		}
		
		int countOdd = 0;
		
		for (int j = 0; j < char_set.length; j++) {
			if(char_set[j] % 2 != 0) {
				if (countOdd > 0) return false;
				countOdd++;
			}
		}
		
		return true;
	}

}
