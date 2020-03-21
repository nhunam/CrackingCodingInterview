/* Leetcode 88*/
package ArrayAndString1;

import java.util.Arrays;

public class MergeSortArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1, 2, 3};
		int[] nums2 = {2, 5, 6};
		System.out.println(Arrays.toString(merge(nums1, nums2)));
	}
	
	public static int[] merge(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];
        int i1 = 0, i2 = 0;
        int index = 0;
        while(i1 < nums1.length || i2 < nums2.length){
        	int n1 = (i1 < nums1.length) ? nums1[i1] : Integer.MAX_VALUE;
        	int n2 = (i2 < nums2.length) ? nums2[i2] : Integer.MAX_VALUE;
            if(n1 < n2){
               merge[index] = n1;
               i1++;
            }else {
                merge[index] = n2;
                i2++;
            }
            index++;
        }
        return merge;
    }

}
