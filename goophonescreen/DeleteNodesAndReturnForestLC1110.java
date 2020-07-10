/*
 * Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.
Example 1:



Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]

Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000.

 */

package goophonescreen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForestLC1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Set<Integer> to_delete_set;
	List<TreeNode> res;
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        to_delete_set = new HashSet<>();
        res = new ArrayList<>();
        for (int i: to_delete)
        	to_delete_set.add(i);
        helper(root, true);
        return res;
    }
	
	private TreeNode helper(TreeNode node, boolean is_root) {
		if(node == null) return null;
		boolean deleted = to_delete_set.contains(node.val);
		if(is_root && !deleted) res.add(node);
		node.left = helper(node.left, deleted);
		node.right = helper(node.right, deleted);
		
		return deleted ? null : node;
	}
}

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode() {}
	 TreeNode(int val) { this.val = val; }
	 TreeNode(int val, TreeNode left, TreeNode right) {
		 		this.val = val;
		 		this.left = left;
		 		this.right = right;
	 		}
}
