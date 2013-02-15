package queue;
import finalSLinkedList.SLinkedList;

public class ListQueue<E extends Comparable<E>> {
	private SLinkedList<E> front;
	private SLinkedList<E> back;
	private int size;
	
	public ListQueue(){
		front = new SLinkedList<E>();
		back = new SLinkedList<E>();
		size = 0;
	}
	public int getSize(){
		return size;
	}
	public void enqueue(E elt){
		front.insertFront(elt);
		size++;
	}
	public E dequeue(){
		if(size>0){
			if(back.getSize()>0){
				size--;
				return back.getFront();
			}
			else{
				while(front.getSize()>0)
					back.insertFront(front.getFront());
				size--;
				return back.getFront();
			}
		}
		else
			return null;
	}
}
