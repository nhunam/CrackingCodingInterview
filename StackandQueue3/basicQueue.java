package StackandQueue3;

import java.util.PriorityQueue;
import java.util.Queue;

public class basicQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new PriorityQueue<>();
		q.add(1);
		q.add(2);
		q.add(5);
		q.add(10);
		q.offer(15);
		//System.out.println(q.size());
		System.out.println(q.poll());
		System.out.println(q.size());
		q.remove();
		System.out.println(q.size());
		 int n = 0000111110;
		 System.out.println(n);
	}

}
