/* Draw Line: A monochrome screen is stored as a single array of bytes, allowing eight consecutive
pixels to be stored in one byte.The screen has width w, where w is divisible by 8 (that is, no byte will
be split across rows). The height of the screen, of course, can be derived from the length of the array
and the width. Implement a function that draws a horizontal line from (xl, y) to (x2, y).
The method signature should look something like:
drawLine(byte[] screen, int width, int xl, int x2, int y)
 * 
 * 
 */

package BitManipulation5;

public class DrawLine58 {
	void drawLine(byte[] screen, int width, int x1, int x2, int y) {
		int start = x1 % 8;
		int first_full_byte = x1/8;
		if (start != 0) {
			first_full_byte++;
		}
		
		int end = x2 % 8;
		int last_full_byte = x2/8;
		if (end != 7) {
			last_full_byte--;
		}
		
		// All the byte in the middle set to 0xFF
		for(int i = first_full_byte; i <= last_full_byte; i++) {
			screen[(width/8) * y + i] = (byte) ~0;
		}
		
		// Create mask for first byte and end byte
		byte a = (byte) ~0;
		byte start_mask = (byte) (a >> start);
		byte end_mask = (byte) (a >> (8-end));
		
		// Set this to byte screen:
		//screen[width/8 *y + x1/8] |= start_mask;
		//screen[width/8 * y + x2/8] |= end_mask;
		
		if (x1/8 == x2/8) {
			byte mask = (byte) (start_mask & end_mask);
					screen[width/8 *y + x1/8] |= mask;		
		}else {
			if (start != 0) {
				int byte_number = width/8 * y + first_full_byte - 1;
				screen[byte_number] |= start_mask;
			}
			
			if (end != 7) {
				int byte_number = width/8 * y + last_full_byte + 1;
				screen[byte_number] |= end_mask;
			}
		}
	}
}
