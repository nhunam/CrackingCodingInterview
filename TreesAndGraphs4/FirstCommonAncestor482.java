/*
 *  First Common Ancestor: Design an algorithm and write code to find the first common ancestor
of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
necessarily a binary search tree.

//Solution 2: Node has no link to its parent:
 * 1. Check p & q on the same side or not.
 * 2. If p & q on the same side, for example left side, branch left to look for common ancestor: recursion
 * 3. If p & q on the different side, => first common ancestor is the root.
 * 
 */
package TreesAndGraphs4;


public class FirstCommonAncestor482 {

	class Node {
		Node left, right;
		int val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	Node firstCommonAncestor(Node r, Node p, Node q) {
		// Error check - one node is not in the tree
		if(!covers(r, p) || !covers(r, q)) {
			return null;
		}
		return ancestorHelper(r, p, q);
	}
	
	Node ancestorHelper(Node r, Node p, Node q) {
		if(r == null || r == p || r == q) return r;
		
		boolean pOnLeft = covers(r.left, p);
		boolean qOnLeft = covers(r.left, q);
		if(pOnLeft != qOnLeft) return r; // Nodes on different side
		Node childSide = pOnLeft ? r.left : r.right;
		// Continue to look
		return ancestorHelper(childSide, p, q);
	}
	
	boolean covers(Node r, Node p) {
		if (r == null) return false;
		if (r == p) return true;
		return covers(r.left, p) || covers(r.right, p);
	}

}
