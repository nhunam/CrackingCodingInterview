package TreesAndGraphs4;

public class BinaryTreeTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode("F");
		TreeNode left = new TreeNode("B");
		TreeNode right = new TreeNode("G");
		root.left = left;
		root.right = right;
		TreeNode rr = new TreeNode("I");
		right.right = rr;
		rr.left = new TreeNode("H");
		TreeNode right2 = new TreeNode("D");
		left.left = new TreeNode("A");
		left.right = right2;
		right2.left = new TreeNode("C");
		right2.right = new TreeNode("E");
		
		System.out.println("In Order:");
		inOrderTraversal(root);
		System.out.println();
		System.out.println("Pre Order:");
		preOderTraversal(root);
		System.out.println();
		System.out.println("Post Order:");
		postOderTraversal(root);
	}

	static void inOrderTraversal(TreeNode node) {
		if(node != null) {
			inOrderTraversal(node.left);
			visit(node);
			inOrderTraversal(node.right);
		}
	}
	
	static void preOderTraversal(TreeNode node) {
		if(node != null) {
			visit(node);
			preOderTraversal(node.left);
			preOderTraversal(node.right);
		}
	}
	
	static void postOderTraversal(TreeNode node) {
		if(node != null) {
			postOderTraversal(node.left);
			postOderTraversal(node.right);
			visit(node);
		}
	}
	
	static void visit(TreeNode node) {
		System.out.print(node.val + ",");
	}
}

class TreeNode {
	String val;
	TreeNode left;
	TreeNode right;
	TreeNode(String x) { val = x;}
	
}
