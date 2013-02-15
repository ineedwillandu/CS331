package queue;

import sLinkedList1.SLinkedList;
import recurList.RecurList;

public class TestListQueue {
	public static void main(String[] args){
		ListQueue<Integer> lq = new ListQueue<Integer>();
		System.out.println(lq.dequeue());
		for(int i=0; i<5; i++)
			lq.enqueue(i);
		System.out.println(lq.dequeue());
		SLinkedList<Integer> sll = new SLinkedList<Integer>();
		System.out.println(sll);
		for(int i=0; i<5; i++)
			sll.insertFront(i);
		//System.out.println(sll);
		RecurList rl = new RecurList();
		for(int i=0; i<5; i++)
			rl.insertFront(i);
		System.out.println(rl);
	}
}
