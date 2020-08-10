/*
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into sets of k consecutive numbers
Return True if its possible otherwise return False.

 

Example 1:

Input: nums = [1,2,3,3,4,4,5,6], k = 4
Output: true
Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
Example 2:

Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
Output: true
Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
Example 3:

Input: nums = [3,3,2,2,1,1], k = 3
Output: true
Example 4:

Input: nums = [1,2,3,4], k = 3
Output: false
Explanation: Each array should be divided in subarrays of size 3.
 */
package goophonescreen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DivideArrayKLC1296 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 3, 4, 5, 4, 5, 6};
		int[] nums2 = {1, 1, 1, 2, 2, 2, 3, 3, 5};
		int[] nums3 = {3,2,1,2,3,4,3,4,5,9,10,11};
		int[] nums4 = {3,2,1,2,3,4,3,4,5,9,19,11};
		int k = 3;
		System.out.println(isPossibleDivide(nums3, k));
		System.out.println(isPossibleDivide2(nums3, k));
	}
	
	public static boolean isPossibleDivide(int[] nums, int k) {
		// brute-force
        if(nums.length == 0 || nums.length % k != 0) return false;
        if (k == 1) return true;
        Arrays.sort(nums);
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
        	li.add(nums[i]);
        }
        
        while (!li.isEmpty()) {
        	int start = li.get(0);
        	int c = 0;
        	Hashtable<Integer, Boolean> ht = new Hashtable<>();
        	for (int p = 0; p < k; p++) {
        		ht.put(start + p, false);
        	}
	        for(int i = 0; i < li.size(); i++) {
	        	for (int j = 0; j < k; j++)
	        		if(li.get(i) == start + j && !ht.get(start+j)) {
	        			li.remove(i);
	        			ht.put(start + j, true);
	        			c++;
	        		}
	        }
	        if(c != k) return false;
        }
        
        return true;
    }
	
	public static boolean isPossibleDivide2(int[] A, int k) {
		Map<Integer, Integer> c = new TreeMap<>();
        for (int i : A) c.put(i, c.getOrDefault(i, 0)+1);
        for (int it : c.keySet())
            if (c.get(it) > 0)
                for (int i = k - 1; i >= 0; --i) {
                    if (c.getOrDefault(it + i, 0) < c.get(it)) return false;
                    c.put(it + i, c.get(it + i) - c.get(it));
                }
        return true;
	}

}
