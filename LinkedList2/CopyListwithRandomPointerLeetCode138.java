package LinkedList2;

import java.util.HashSet;
import java.util.Set;

public class CopyListwithRandomPointerLeetCode138 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Node1 copyRandomList(Node1 head) {
        Node1 tmp = head;
        Set<Node1> sn = new HashSet<>();
        while(head != null){
        	sn.add(head);
            head = head.next;
            //appendToTail(tmp, head);
        }
        
        for (Node1 s: sn) {
        	
        }
        
        return tmp;
    }
    void appendToTail(Node1 head, Node1 end){
        while (head.next != null)
            head = head.next;
        head.next = end;
    }
}

class Node1 {
    int val;
    Node1 next;
    Node1 random;

    public Node1(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
