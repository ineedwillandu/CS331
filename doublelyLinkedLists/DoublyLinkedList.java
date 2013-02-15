package doublelyLinkedLists;
import userDefinedInterface.MyIterator;

public class DoublyLinkedList<E extends Comparable<E>>{
	private class Node{
		protected Node next;
		protected Node prev;
		protected E data;
		
		public Node(){
			next = null;
			prev = null;
			data = null;
		}
		public Node(Node newPrev, E newData, Node newNext){
			prev = newPrev;
			data = newData;
			next = newNext;
		}
	}
	private abstract class AllIterator implements MyIterator<E>{
		protected Node cursor;
	
		public AllIterator(){
			cursor = head.next;
		}
		public  boolean isValid(){
			if(cursor.data!=null)
				return true;
			else
				return false;
		}
		public E get(){
			if(isValid())
				return cursor.data;
			else
				return null;
		}
		public void delete(){
			if(cursor.data!=null){
				cursor.prev.next = cursor.next;
				cursor.next.prev = cursor.prev;
				next();
			}
		}
		public abstract void next();
	}

	public class FwdIterator extends AllIterator{
		public void next(){
			if(isValid())
				cursor = cursor.next;
		}	
	}
	public class BwdIterator extends AllIterator{
		public BwdIterator(){
			cursor = last;
		}
		public void next(){
			if(isValid()){
				cursor = cursor.prev;
			}
		}
	}
	public class FwdFindIterator extends FwdIterator{
		private E data;
		private Node tempCursor = null;
		
		public FwdFindIterator(E desire){
			data = desire;
			while(cursor!=head&&cursor.data.compareTo(data)!=0){
				cursor = cursor.next;
			}
		}
		public void next(){
			tempCursor = cursor.next;
			while(tempCursor!=head){
				if(tempCursor.data.compareTo(data)==0){
					cursor = tempCursor;
					break;
				}
				else
					tempCursor = tempCursor.next;
			}
		}
	}
	public class BwdFindIterator extends BwdIterator{
		private E data;
		private Node tempCursor = null;
		
		public BwdFindIterator(E desire){	
			data = desire;
			while(cursor!=head&&cursor.data.compareTo(data)!=0){
				cursor = cursor.next;
			}
		}
		public void next(){
			tempCursor = cursor.prev;
			while(tempCursor!=head){
				if(tempCursor.data.compareTo(data)==0){
					cursor = tempCursor;
					break;
				}
				else
					tempCursor = tempCursor.prev;
			}
		}
	}
	
	private Node head;
	private Node last;
	private int size;
	
	public DoublyLinkedList(){
		head = new Node();
		head.next = head;
		size = 0;
	}
	public int getSize(){
		return size;
	}
	public void insertFront(E elt){
		Node insertion = new Node(head, elt ,head.next);
		head.next = insertion;
		insertion.next.prev = insertion;
		size++;
		if(size == 1){
			last = head.next;
		}
	}
	public void insertEnd(E elt){
		Node insertion = new Node(last, elt, head);
		last.next = insertion;
		last = insertion;
	}
	public MyIterator<E> makeFwdIterator(){
		return new FwdIterator();
	}
	public MyIterator<E> makeBwdIterator(){
		return new BwdIterator();
	}
	public MyIterator<E> makeFwdFindIterator(E desire){
		return new FwdFindIterator(desire);
	}
	public MyIterator<E> makeBwdFindIterator(E desire){
		return new BwdFindIterator(desire);
	}
}
