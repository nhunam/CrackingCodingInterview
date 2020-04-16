package facebookonsite;

import java.util.Arrays;

public class Plusone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] digits = {8, 9, 9, 9};
		System.out.println(Arrays.toString(plusOne(digits)));
	}
	
	public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >=0; i--){
            if (digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] newNum = new int[digits.length + 1];
        newNum[0] = 1;
        
        return newNum;
    }
}
