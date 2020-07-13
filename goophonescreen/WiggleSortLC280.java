/*
 * Given an unsorted array nums, reorder it in-place such that 
 * nums[0] <= nums[1] >= nums[2] <= nums[3]....

For example, given nums = [3, 5, 2, 1, 6, 4], 
one possible answer is [1, 6, 2, 5, 3, 4].
the pattern is number in odd position is peak.
 */
package goophonescreen;

import java.util.Arrays;

public class WiggleSortLC280 {

	public static void main(String[] args) {
		int[] nums = {3, 5, 2, 1, 6, 4};
		wiggleSort(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	public static void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int split = 0;
		if(nums.length % 2 == 0) {
			split = nums.length/2;
		}else {
			split = nums.length/2 + 1;
		}
		
		int[] half1 = new int[split];
		int[] half2 = new int[nums.length - split];
		for (int i = 0; i < split; i++) {
			half1[i] = nums[i];
			if(i < half2.length)
				half2[i] = nums[split + i];
		}
		int i = 0, j = 0;
		for (int k = 0; k < nums.length; k++) {
			if(k % 2 == 0) {
				nums[k] = half1[i];
				i++;
			}else {
				nums[k] = half2[j];
				j++;
			}
		}
	}
}
