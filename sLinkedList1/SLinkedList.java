package sLinkedList1;

public class SLinkedList<E>{
	private class Node<E>{
		private E data;
		private Node next;
		
		public Node(){
			setData(null);
			setNext(null);
		}
		public Node(E newData){
			setData(newData);
			setNext(null);
		}
		public Node(E newData, Node newNext){
			setData(newData);
			setNext(newNext);
		}
		
		public void setData(E newData){
			data = newData;
		}
		public void setNext(Node newNext){
			next = newNext;
		}
		public E getData(){
			return data;
		} public Node getNext(){
			return next;
		}
	}
	
	private Node<E> head;
	private int size;
	private Node<E> last;
	private Node<E> cursor;
	
	public SLinkedList(){
		setHead(null);
		last = head;
		cursor = head;
		setSize(0);
	}
	public void insertBack(E elt){
		last = new Node<E>(elt, last);
		size++;
	}
	public E getFirst(){
		if(empty()!=true)
			return (E)head.getData();
		else
			return null;
	}
	public void delFirst(){
		if(empty()!=true){
			if(head.getNext()!=null)
				head = head.getNext();
			else
				head = null;
			size--;
		}
	}
	public boolean empty(){
		if(head==null)
			return true;
		else
			return false;
	}
	private void setHead(Node newNode){
		head = newNode;
	}
	private void setSize(int newSize){
		size = newSize;
	}
	public void insertFront(E elt){
		head = new Node(elt, head);
		size++;
	}
	public boolean findElt(E elt){
		boolean found = false;
		Node cursor = head;
		while(cursor!=null&&!found){
			if(elt.equals(cursor.getData())){
				found = true;
			}
			else{
				cursor = cursor.getNext();
			}
		}
		return found;
	}
	public boolean cpDelete(E elt){
		boolean found = false;
		Node cursor = head;
		Node prev = head;
		while(cursor!=null&&!found){
			if(elt.equals(cursor.getData())){
				if(size==1){
					setHead(null);
				}
				else if(cursor.getNext().getNext()!=null){
					cursor.setData(cursor.getNext().getData());
					cursor.setNext(cursor.getNext().getNext());
				}
				else if(cursor.getNext()!=null){
					prev.setNext(cursor.getNext());
				}
				else
					prev.setNext(null);
				size--;
				found = true;
			}
			else{
				prev = cursor;
				cursor = cursor.getNext();
			}
		}
		return found;
	}
	public SLinkedList reverse(){
		SLinkedList<E> revList = new SLinkedList<E>();
		Node cursor = head;
		while(cursor!=null){
			revList.insertFront((E)cursor.getData());
			cursor = cursor.getNext();
		}
		return revList;
	}
	public int getSize(){
		return size;
	}
	public String toString(){
		Node cursor = head;
		String temp = "List:\n";
		while(cursor!=null){
			temp = temp + cursor.getData() + "\n";
			cursor = cursor.getNext();
		}
		return temp;
	}
} 