/*
 * 4.2 Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algo­
rithm to create a binary search tree with minimal height.
Complex: O(n log n)
 */
package TreesAndGraphs4;
//import TN;

public class MinimalTree42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vals = {2, 4, 6, 8, 10, 12, 15};
		MinimalTree42 m = new MinimalTree42();
		TN r = m.initBST(vals);
		System.out.println("In order:");
		m.inOrderTraversal(r);
		System.out.println("Post order:");
		m.postOderTraversal(r);
		
	}

	TN initBST(int[] vals) {
		return createBST(vals, 0, vals.length - 1);
	}
	
	TN createBST(int[] vals, int low, int high) {
		if (low > high)
			return null;
		int mid = (low+high)/2;
		TN n = new TN(vals[mid]);
		n.left = createBST(vals, low, mid-1);
		n.right = createBST(vals, mid+1, high);
		return n;
	}
	
	void visit(TN node) {
		System.out.print(node.val + ",");
	}
	
	void inOrderTraversal(TN node) {
		if(node != null) {
			inOrderTraversal(node.left);
			visit(node);
			inOrderTraversal(node.right);
		}
	}
	
	void postOderTraversal(TN node) {
		if(node != null) {
			postOderTraversal(node.left);
			postOderTraversal(node.right);
			visit(node);
		}
	}
}

class TN {
	TN right;
	TN left;
	int val;
	public TN(int x) {
		val = x;
	}
}
