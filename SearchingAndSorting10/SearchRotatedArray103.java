/*
 * Search in Rotated Array: Given a sorted array of n integers that has been rotated an unknown
number of times, write code to fnd an element in the array. You may assume that the array was
originally sorted in increasing order.
EXAMPLE
lnput:find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
Output: 8 (the index of 5 in the array)
 */

package SearchingAndSorting10;

import jdk.nashorn.internal.runtime.FindProperty;

public class SearchRotatedArray103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		int x = 5;
		// Find the rotate index:
		int find = -1;
		int rIndex = findRIndex(arr);
		if (rIndex > 0) {
			int[] arr1 = new int[rIndex];
			int[] arr2 = new int[arr.length - rIndex];
			for (int i = 0 ; i < rIndex; i++)
				arr1[i] = arr[i];
			for (int j = rIndex; j < arr.length; j++) {
				arr2[j-rIndex] = arr[j];
			}
			
			find = (binarySearch(arr1, x) != -1) ? binarySearch(arr1, x): binarySearch(arr2, x)+rIndex;
		}
		else {
			find = binarySearch(arr, x);
		}
		
		System.out.println(find);
	}
	
	static int findRIndex(int[] a) {
		int rIndex = 0;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i+1])
				return i+1;
		}
		return rIndex;
	}

	static int binarySearch(int[] a, int x) {
		int low = 0;
		int high = a.length - 1;
		int mid;
		while (low <= high) {
			mid = (low+high)/2;
			if (a[mid] < x) {
				low = mid + 1;
			}else if (a[mid] > x) {
				high = mid - 1;
			}else 
				return mid;
		}
		
		return -1; // Can't find x
	}
	
}
