package SearchingAndSorting10;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 3, 5, 7, 9, 11};
		System.out.println(binarySearch(arr, 11));
	}
	
	static int binarySearch(int[] arr, int tar) {
		int res = -1;
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high)/2;
			if (tar == arr[mid]) return mid;
			else if (tar > arr[mid]) {
				low = mid + 1;
			} else 
				high = mid - 1;
		}
		return res;
	}

}
