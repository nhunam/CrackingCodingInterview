/*
 * 5.6 Conversion: Write a function to determine the number of bits you would need to flip to convert
integer A to integer B
	EXAMPLE
	Input: 29 (or: 11101), 15 (or: 01111)
	Output: 2
 */
package BitManipulation5;

public class Conversion56 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(conversion(29, 15));
		System.out.println(bitSwapRequired(29, 15));
	}
	
	static int conversion(int a, int b) {
		if (a == b) return 0;
		String aS = Integer.toBinaryString(a);
		String bS = Integer.toBinaryString(b);
		
		if (aS.length() >= bS.length()) {
			return numOfSteps(aS, bS);
		}
		else 
			return numOfSteps(bS, aS);
	}
	
	private static int numOfSteps(String aS, String bS) {
		StringBuilder sb = new StringBuilder(bS);
		int dif = aS.length() - bS.length();
		for (int i = 0; i < dif; i++) {
			sb.insert(0, '0');
		}
		int cntDif = 0;
		for (int j = 0; j < aS.length(); j++) {
			if (aS.charAt(j) != sb.toString().charAt(j))
				cntDif++;
		}
		return cntDif;
	}
	
	// Solution 2:
	// Each 1 in the XOR represents a bit that is different between A and B. Therefore, to check the number of bits
	// that are different between A and B, we simply need to count the number of bits in AAB that are 1
	static int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c >> 1) {
			count += c & 1;
		}
		return count;
	}
}
