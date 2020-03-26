/*
 * 5.4 Next Number: Given a positive integer, print the next smallest and the next largest number that
have the same number of 1 bits in their binary representation.
   Solution:
 */
package BitManipulation5;

public class NextNumber54 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findNextLargest(3));
	}
	
	static int findNextLargest(int a) {
		if(~a == 0) return Integer.BYTES*8;
		// Count the number of 1 bit in a
		int countOne = 0;
		while (a != 0) {
			if ((a & 1) == 1)
				countOne++;
			a >>>=1;
		}
		// Next largest is the same 1 bit, but all go to right: 111...10000
		int allOne = ~0;
		return allOne << countOne;
	}

}
