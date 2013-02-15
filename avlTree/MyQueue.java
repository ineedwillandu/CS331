package avlTree;
import java.util.LinkedList;

public class MyQueue<E>{
	private LinkedList<E> list;
	
	public MyQueue(){
		list = new LinkedList<E>();
	}
	
	public void enqueue(E e){
		list.addFirst(e);
	}
	public E dequeue(){
		if(list.size()>0)
			return list.removeLast();
		else
			return null;
	}
	public E peek(){
		if(list.size()>0)
			return list.getLast();
		else
			return null;
	}
	public boolean isEmpty(){
		return list.isEmpty();	
	}
}