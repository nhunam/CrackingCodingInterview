package goophonescreen;

import java.util.Arrays;

public class ThreeSumSmallerLC259 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -2, 0, 1, 3};
		int target = 2;
		System.out.println(threeSumSmaller(nums, target));
	}

	public static int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		int c = 0;
		
		for(int i = 0; i < nums.length - 2; i++) {
			int j = i+1, k = nums.length - 1;
			while(j<k) {
				if((nums[i] + nums[j] + nums[k]) >= target) k--;
                else{
                    c += k -j; // all the combine between k-j are good triplet.
                    j++;

                }
			}
		}
		return c;
	}
}
