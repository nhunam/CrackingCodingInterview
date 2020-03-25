/*
 *  First Common Ancestor: Design an algorithm and write code to find the first common ancestor
of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
necessarily a binary search tree.

//Solution 1: with link to its parent:
 * 1. Count the depth of each node
 * 2. MoveUp the deeper node to the same depth
 * 3. MoveUp two node at the same time to the common ancestor
This approach will take O(d) time, where d is the depth of the deeper node.
 */
package TreesAndGraphs4;

public class FirstCommonAncestor48 {
	
	class Node {
		Node left, right, parent;
		int val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FirstCommonAncestor48 fca = new FirstCommonAncestor48();
		Node r = fca.new Node();
		System.out.println(fca.hs(r));
	}
	
	Node hs(Node root) {
		Node first = root.parent;
		return first;
	}
	
	Node firstCommonAncestor(Node p, Node q) {
		int delta = countDepth(p) - countDepth(q);
		Node first = delta > 0 ? q : p; // get shallower node
		Node second = delta > 0 ? p : q; // get deeper node
		
		// Move second node upper, the same depth as first
		second = goUpBy(Math.abs(delta), second);
		// Now move up 2 nodes at the same time:
		while (first != second && first != null && second != null) {
			first = first.parent;
			second = second.parent;
		}
		
		return first;
	}
	
	Node goUpBy(int delta, Node n) {
		while (delta > 0 && n != null) {
			n = n.parent;
			delta--;
		}
		return n;
	}
	
	int countDepth(Node n) {
		int depth = 0;
		while (n != null) {
			n = n.parent;
			depth++;
		}
		return depth;
	}

}
