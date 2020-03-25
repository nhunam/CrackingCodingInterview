package TreesAndGraphs4;
/*
 * Successor: Write an algorithm to fnd the "next" node (i.e., in-order successor) of a given node in a
binary search tree. You may assume that each node has a link to its parent.
 */

public class Successor46 {

	class TreeNode {
		TreeNode parent = null;
		TreeNode right;
		TreeNode left;
		int val;
		
		public TreeNode(int x) {
			val = x;
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Successor46 s = new Successor46();
		TreeNode r = s.new TreeNode(6);
		r.parent = null;
		r.left = s.new TreeNode(4);
		r.left.parent = r;
		r.right = s.new TreeNode(8);
		r.right.parent = r;
		
		System.out.println(s.findNextInorder(r.right));
		
	}
	
	TreeNode findNextInorder(TreeNode n) {
		// In-order: left, node, right
		if (n == null) return null;
		/* Found right children -> return leftmost node of right subtree */
		if (n.right != null) {
			return leftMostChild(n.right);
		} else {
			TreeNode q = n;
			TreeNode x = q.parent;
			// Go up until we're on left instead of right
			while (x != null && x.left != q) {
				q = x;
				x = x.parent;
			}
			return x;
		}
		
	}
	
	TreeNode findNextPreorder(TreeNode n) {
		// Pre-order: node, left, right
		if(n == null) return null;
		if(n.left != null) return n.left;
		
		TreeNode q = n;
		TreeNode p = q.parent;
		
		while(p!= null && p.right == q) {
			q = q.parent;
			p = p.parent;
		}
		
		// If we reach root, then the given node has no successor
		if(p == null)
			return null;
		return p.right;
	}
	
	TreeNode findNextPostOrder(TreeNode n) {
		// Post-order: left, right, node
		if(n == null) return null;
		if(n.left != null) return n.left;
		
		TreeNode q = n;
		TreeNode p = q.parent;
		
		while(p!= null && p.right == q) {
			q = q.parent;
			p = p.parent;
		}
		
		// If we reach root, then the given node has no successor
		if(p == null)
			return null;
		return p.right;
	}
	
	TreeNode leftMostChild(TreeNode n) {
		if (n == null)
			return null;
		while (n.left != null) {
			n = n.left;
		}
		return n;
	}
	
}

