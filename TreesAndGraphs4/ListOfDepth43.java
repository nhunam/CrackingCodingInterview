/*
 * 4.3 List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
Solution 1: Using BFS.
Complex time: O(n) need to loop all the element of the tree.
Complex space: O(n)

Solution 2: using recursive, (DFS), to search each level follow pre-order travelsal
Complex time and space is the same.
 */
package TreesAndGraphs4;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TreesAndGraphs4.MinimalTree42;

public class ListOfDepth43 {

	List<LinkedList<TN>> ll;
	
	public ListOfDepth43() {
		ll = new ArrayList<>();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vals = {2, 4, 6, 8, 10, 12, 15, 17 , 20};
		MinimalTree42 m = new MinimalTree42();
		TN root = m.initBST(vals);
		ListOfDepth43 lod = new ListOfDepth43();
		//lod.ListofDepthBFS(root);
		lod.ListofDepthDFS(root, 0);
		
		for (int i = 0; i < lod.ll.size(); i++) {
			LinkedList<TN> tmp = lod.ll.get(i);
			for (int j = 0; j < tmp.size(); j++) {
				System.out.print(tmp.get(j).val + ",");
			}
			System.out.println();
		}
	}
	
	void ListofDepthBFS(TN root) {
		//BFS
		if(root == null) return;
		Queue<TN> q = new LinkedList<>();
		q.offer(root);
		
		while (!q.isEmpty()) {
			int size = q.size();
			LinkedList<TN> tmp = new LinkedList<>();
			for(int i = 0; i < size; i++) {
				TN n = q.poll();
				tmp.add(n);
				if(n.left != null) q.offer(n.left);
				if(n.right != null) q.offer(n.right);
			}
			ll.add(tmp);
		}
	}
	
	void ListofDepthDFS(TN root, int level) {
		if (root == null) return; // base level
		LinkedList<TN> list = null;
		if(ll.size() == level) {
			// level is not contain in this list
			// create new LinkedList;
			/* Levels are always traversed in order. So, if this is the first time we've
			* visited level i, we must have seen levels 0 through i - 1. We can
			* therefore safely add the level at the end*/
			list = new LinkedList<>();
			ll.add(list);
		}else {
			list = ll.get(level);
		}
		list.add(root);
		ListofDepthDFS(root.left, level+1);
		ListofDepthDFS(root.right, level+1);
	}
	
}
