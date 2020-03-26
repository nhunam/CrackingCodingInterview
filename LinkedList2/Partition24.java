package LinkedList2;
import LinkedList2.Node;

public class Partition24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(3);
		head.appendToTail(5);
		head.appendToTail(8);
		head.appendToTail(5);
		head.appendToTail(10);
		head.appendToTail(2);
		head.appendToTail(1);
		
		//printLL(head);
		printLL(partition(5, head));
	}
	
	static Node partition(int par, Node n) {
		Node lowerHead = null, lowerTail = null;
		Node upperHead = null, upperTail = null;
		
		while (n != null) {
			if (n.data < par) {
				lowerHead.appendToTail(n.data);
			}
			else {
				upperHead.appendToTail(n.data);
			}
			n = n.next;
		}
		
		lowerTail.next = upperHead;
		upperTail.next = null;
		return lowerHead;
	}
	
	static void printLL(Node head) {
		StringBuilder sb = new StringBuilder();
		while(head != null) {
			sb.append(head.data);
			sb.append(',');
			head = head.next;
		}
		System.out.println(sb.toString());
	}

}
