/*
 * 5.3: Flip Bit to Win: You have an integer and you can flip exactly one bit from a O to a 1. Write code to
fnd the length of the longest sequence of 1 s you could create.
EXAMPLE
Input: 1775 (or: 11011101111)
Output: 8

Solution:
we canjust walk through the integer doing this, tracking the current 1 s sequence length and the
previous ls sequence length. When we see a zero, update previous Length:
- If the next bit is a 1, previous Length should be set to currentLength.
- If the next bit is a 0, then we can't merge these sequences together. So, set previousLength to 0.
*/

package BitManipulation5;

public class FlipBitoWin53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Integer.BYTES * 8);
		int a = 4;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(a & 1);
		a >>>=1;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(a & 1);
		a >>>=1;
		System.out.println(a & 1);
		//System.out.println(flipBit(1775));
	}
	
	static int flipBit(int a) {
		/* If all 1s, this is already the longest sequence */
		if (~a == 0) return Integer.BYTES * 8;
		int curLen = 0;
		int preLen = 0;
		int maxLen = 1; // We can always have a sequence of at least one 1
		
		while (a != 0) {
			if ((a & 1) == 1) { // current bit is 1
				curLen++;
			} else if ((a & 1) == 0) { // current bit is 0
				/* Update to 0 if next bit is 0 or curLen if next bit is 1 */
				preLen = (a & 2) == 0 ? 0: curLen;
				curLen = 0;
			}
			maxLen = Math.max(preLen + curLen + 1, maxLen);
			a >>>= 1;
		}
		return maxLen;
	}

}
