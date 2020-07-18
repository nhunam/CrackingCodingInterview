/*
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:

For 1-byte character, the first bit is a 0, followed by its unicode code.
For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
This is how the UTF-8 encoding would work:

   Char. number range  |        UTF-8 octet sequence
      (hexadecimal)    |              (binary)
   --------------------+---------------------------------------------
   0000 0000-0000 007F | 0xxxxxxx
   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
Given an array of integers representing the data, return whether it is a valid utf-8 encoding.

Note:
The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. This means each integer represents only 1 byte of data.

Example 1:

data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.

Return true.
It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
Example 2:

data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.

Return false.
The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
The next byte is a continuation byte which starts with 10 and that's correct.
But the second continuation byte does not start with 10, so it is invalid.
 */
package goophonescreen;

public class UTF8ValidationLC393 {

	public static void main(String[] args) {

		int[] data = {235, 140, 4};
		int[] data1 = {197, 130, 1};
		System.out.println(validUtf8(data));

	}
	
	// 0(n)
	
	public static boolean validUtf8(int[] data) {
		if(data == null) return false;
		int i  = 0;
		//StringBuilder sb = new StringBuilder();
		while (i < data.length) {
			StringBuilder d0 = new StringBuilder(Integer.toBinaryString(data[i]));
			if(d0.length() < 8) {
				for (int j = 0; j < 8 - d0.length(); j++)
					d0.insert(0, '0');
			}
			
			//String d0 = d.toString();
			
			// Check numbers of appear of 1
			if(d0.charAt(0) == '0')
				i = i + 1;
			else {
				int countOne = 1;
				int c = 1;
				while (c < d0.length() && d0.charAt(c) == '1') {
					countOne++;
					c++;
				}
				if(countOne == 1) return false;
				else if(countOne == 2) {
					if(data.length < 2 || !check(data[i+1])) return false;
					i = i+2;
				}
				else
				if(countOne == 3) {
					if(data.length < 3 || !check(data[i+1]) || !check(data[i+2])) return false;
					i = i+3;
				}
				else
				if(countOne == 4) {
					if(data.length < 4 || !check(data[i+1]) || !check(data[i+2]) || !check(data[i+3])) return false;
					i = i+4;
				}
				else
				if(countOne > 4) return false;
			}
		}
		
		return true;
    }
	
	static boolean check(int num) {
		StringBuilder d = new StringBuilder(Integer.toBinaryString(num));
		if(d.length() < 8) {
			for (int j = 0; j < 8 - d.length(); j++)
				d.insert(0, '0');
		}
		//String data = d.toString();
		if (d.charAt(0)== '1' && d.charAt(1) == '0') return true;
		return false;
	}


		// TODO Auto-generated method stub

	}
