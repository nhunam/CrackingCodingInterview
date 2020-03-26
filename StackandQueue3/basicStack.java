package StackandQueue3;

import java.util.Stack;

public class basicStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> st = new Stack<>();
		st.add(1);
		st.add(2);
		st.add(20);
		st.add(50);
//		System.out.println(st.pop());
//		System.out.println(st.pop());
//		System.out.println("stack size:" + st.size());
//		System.out.println(st.get(0));
		System.out.println(st.peek());
		st.pop();
		System.out.println(st.peek());
//		for (int i = 0; i < st.size(); i++)
//			System.out.println(st.get(i));
	}

}
