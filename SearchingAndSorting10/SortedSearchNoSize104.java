/*10.4 Sored Search, No Size: You are given an array-like data structure Listy which lacks a size
method. It does, however, have an elementAt(i) method that returns the element at index i in
0(1) time. If i is beyond the bounds of the data structure, it returns -1. (For this reason, the data
structure only supports positive integers.) Given a Listy which contains sorted, positive integers,
fnd the index at which an element x occurs. If x occurs multiple times, you may return any index
 * 
 * 
 */
package SearchingAndSorting10;

public class SortedSearchNoSize104 {
	class Listy {
		int elementAt(int i) {
			return -1;
		}
	}
	int search(Listy list, int value) {
		int index = 1;
		while (list.elementAt(index) != -1 && list.elementAt(index) < value)
			index *= 2;
		return binarySearch(list, value, index/2, index);
	}
	
	int binarySearch(Listy a, int x, int low, int high) {
		int mid;
		while (low <= high) {
			mid = (low + high)/2;
			int m = a.elementAt(mid);
			if (m > x || m == -1)
				high = mid - 1;
			else if (m < x)
				low = mid + 1;
			else
				return mid;
		}
		
		return -1;
	}
}
