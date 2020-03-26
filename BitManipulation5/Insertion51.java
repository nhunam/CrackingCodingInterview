/* Insertion: You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method
to insert Minto N such that Mstarts at bit j and ends at bit i. You can assume that the bits j through
ihave enough space to fit all of M. That is, if M = 10011, you can assume that there are at least 5
bits between j and i. You would not, for example, have j = 3 and i= 2, because M could not fully
fit between bit 3 and bit 2
 * EXAMPLE Input: N=10000000000, M = 10011, i = 2, j = 6
 * Output N = 10001001100
 * 
 * Solution:
 * 1. Clear the bits j through i in N
 * 2. Shift Mso that it lines up with bits j through i
 * 3. Merge M and N
 */
package BitManipulation5;

public class Insertion51 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Insertion51 it = new Insertion51();
		System.out.println(it.updateBits(8, 4, 1, 3));
	}
	
	int updateBits(int n, int m, int i, int j) {
		/* Create a mask to clear bits i through j in n. 
		 * EXMPLE: i = 2, j = 4. Result should be 11100011. 
		 * For simplicity, we'll use just 8 bits for the example. */
		int allOne = ~0; // will equal sequence of all 1s
		// all 1s before position j, then 0s. left = 11100000
		int left = allOne << (j + 1);
		
		// 1's after position i. right = 0000011
		int right = ((1 << i) - 1);
		
		// Now create a mask:
		int mask = left | right;
		// Clear bits j through i then put m in there
		int n_cleared = n & mask;
		int m_shifted = m << i;
		
		return n_cleared | m_shifted; // Ok.
	}

}
