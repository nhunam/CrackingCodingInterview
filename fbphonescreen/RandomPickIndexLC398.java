package fbphonescreen;

import java.util.Random;

public class RandomPickIndexLC398 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 4, 3, 1, 4, 3, 4};
		System.out.println(maxRandomIndex(nums));
	}
	
	public static int maxRandomIndex(int[] nums) {
		  Random random = new Random();

		  int max = Integer.MIN_VALUE;
		  int maxIndex = -1;

		  int count = 0;

		  for (int i = 0; i < nums.length; i++) {
		    if (nums[i] > max) {
		      max = nums[i];
		      maxIndex = i;
		      count = 1;
		    } else if (nums[i] == max) {
		      count++;

		      // probability of 1/count
		      if (random.nextInt(count) == 0) {
		        maxIndex = i;
		      }
		    }
		  }
		  return maxIndex;
	  }

}
