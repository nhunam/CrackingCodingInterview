package LinkedList2;
import java.util.HashMap;

import LinkedList2.Node;

public class ReturnKthToLast22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(12);
		head.appendToTail(6);
		head.appendToTail(8);
		head.appendToTail(10);
		
		System.out.println(findKthToLast(1, head).data);

	}
	
	static Node findKthToLast(int k, Node head) {
		if (head == null) return null;
		int count = 1;
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		
		while (head.next != null) {
			map.put(count, head);
			head = head.next;
			count++;
		}
		map.put(count, head); // add tail
		return map.get(count - k + 1);
	}

}
