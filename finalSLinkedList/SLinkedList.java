package finalSLinkedList;
import userDefinedInterface.MyIterator;
/*
 * having mergesort
 */
public class SLinkedList<E extends Comparable<E>> {
	public class Node{
		protected Node next;
		protected E data;
		
		public Node(E newData, Node newNode){
			data = newData;
			next = newNode;
		}
	}
	private class Iterator implements MyIterator<E>{
		private Node cursor;
		
		public Iterator(){
			cursor = head.next;
		}
		public E get(){
			if(cursor!=head)
				return cursor.data;
			else 
				return null;
		}
		public void next(){
			if(isValid())
				cursor = cursor.next;
		}
		public boolean isValid(){
			if(cursor.next != head)
				return true;
			else
				return false;
		}
	}
	
	private Node head;
	
	public SLinkedList(){
		head = new Node(null, null);
		head.next = head;
	}
	private SLinkedList(Node sentinel){
		head = sentinel;
	}
	public int getSize(){
		return size(head.next);
	}
	private int size(Node cursor){
		if(cursor == head)
			return 0;
		else
			return 1 + size(cursor.next);
	}
	public void insertFront(E data){
		Node newNode = new Node(data, head.next);
		head.next = newNode;
	}
	/*
	 * return the data of first element then delete it
	 */
	public E getFront(){
			Node temp = head.next;
			head.next = head.next.next;
			return temp.data;
	}
	public boolean find(E desire){
		return findData(desire, head.next);
	}
	private boolean findData(E desire, Node cursor){
		if(cursor == head)
			return false;
		else if(cursor.data.compareTo(desire)==0)
			return true;
		else 
			return findData(desire, cursor.next);
	}
	public boolean delete(E desire){
		return delete(desire, head.next, head.next);
	}
	private boolean delete(E desire, Node cursor, Node prev){
		if(cursor == head)
			return false;
		else if(cursor.data.compareTo(desire) == 0){
			prev.next = cursor.next;
			return true;
		}	
		else 
			return delete(desire, cursor.next, cursor);
	}
	public Iterator mkFwdIterator(){
		return new Iterator();
	}
	public SLinkedList<E> reverse(){
		return new SLinkedList<E>(priReverse(head));
	}
	private Node priReverse(Node node){
		Node newHead = new Node(null, null);
		newHead.next = newHead;
		Node cursor = node.next;
		while(cursor!=node){
			newHead.next = new Node(cursor.data, newHead.next);
			cursor = cursor.next;
		}
		return newHead;
	}
	public SLinkedList<E> sort(){
		return new SLinkedList<E>(priReverse(mergesort(head)));
	}
	private Node mergesort(Node sentinel){
		if(sentinel.next.next == sentinel)
			return sentinel;
		else{
			Node first = new Node(null, null);
			first.next = first; 
			Node second = new Node(null, null); 
			second.next = second;
			Node cursor = sentinel.next;
			int x = 1;
			while(cursor!=sentinel){
				if(x == 1)
					first.next = new Node(cursor.data, first.next);
				else
					second.next = new Node(cursor.data, second.next);
				x = 3-x;
				cursor = cursor.next;
			}
			mergesort(first);
			mergesort(second);
			return merge(first, second);
		}
	}
	private Node merge(Node first, Node second){
		Node result = new Node(null, null);
		result.next = result;
		while(first.next!=first&&second.next!=second){
			if(first.next.data.compareTo(second.next.data)<=0){
				result.next = new Node(first.next.data, result.next);
				first.next = first.next.next;
			}
			else{
				result.next = new Node(second.next.data, result.next);
				second.next = second.next.next;
			}
		}
		while(first.next!=first){
				result.next = new Node(first.next.data, result.next);
				first.next = first.next.next;
			}
		while(second.next!=second){
				result.next = new Node(second.next.data, result.next);
				second.next = second.next.next;
			}
		return result;
	}
}
