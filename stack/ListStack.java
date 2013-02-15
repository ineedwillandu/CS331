package stack;
import sLinkedList1.*;

public class ListStack<E> {
	SLinkedList<E> list; 
	
	public ListStack(){
		list = new SLinkedList<E>();
	}
	public void push(E elt){
		list.insertFront(elt);
	}
	public E pop(){
		E elt = list.getFirst();
		list.delFirst();
		return elt;
	}
	public E lookAtTop(){
		return list.getFirst();
	}
}
