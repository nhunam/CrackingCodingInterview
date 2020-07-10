/*
 * Good morning! Here's your coding interview problem for today.

This problem was asked by Amazon.

An sorted array of integers was rotated an unknown number of times.

Given such an array, find the index of the element in the array in faster than linear time. 
If the element doesn't exist in the array, return null.

For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).

You can assume all the integers in the array are unique.
 */
package DailyCoding;

public class DC_20200623 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 13, 18, 25, 2, 8, 9};
		System.out.println(DC_20200623.findSlideSortedArray(arr, 8));
	}
	
	public static int findSlideSortedArray(int[] arr, int target) {
		int low = 0, high = arr.length;
		while(low < high) {
			for(int i = 0; i < arr.length; i++) {
				int mid = (low + high)/2;
				if (arr[mid] == target) return mid;
				if (arr[mid] < target) {
					low = mid+1;
				}else {
					high = mid-1;
				}
			}
		}
		return -1;
	}

}
