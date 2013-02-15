package recurList;
import userDefinedInterface.Iterator;

public class RecurList{
	private class Node{
		private int data;
		private Node next;
	
		public  Node(){
			setNext(null);
		}
		public Node(int newData){
			setData(newData);
			setNext(null);
		}
		public Node(int newData, Node newNext){
			setData(newData);
			setNext(newNext);
		}
		public Node(Node newNext){
			setNext(newNext);
		}
		public void setData(int newData){
			data = newData;
		}
		public void setNext(Node newNext){
			next = newNext;
		}
		public Node getNext(){
			return next;
		}
		public int getData(){
			return data;
		}
	}	
	private class MyCursor implements Iterator{
		private Node cursor;
		public MyCursor(){
			cursor = sentinel.getNext();
		}
		public int get(){
				return cursor.getData();
		}
		public boolean isValid(){
			if(cursor!=sentinel)
				return true;
			else
				return false;
		}
		public void next(){
			cursor = cursor.getNext();
		}
	}
	private Node sentinel;
	private int size;
	private Node last;
	
	public RecurList(){
		sentinel = new Node();
		sentinel.setNext(sentinel);
		last = sentinel;
		size = 0;
	}
	public MyCursor makeIterator(){
		return new MyCursor();
	}
	public boolean isEmpty(){
		if(sentinel.getNext()==sentinel)
			return true;
		else
			return false;
	}
	public int getLast(){
		return last.getData();
	}
	public void insertFront(int elt){
		sentinel.setNext(new Node(elt, sentinel.getNext()));
		size++;
		if(size==1){
			last = sentinel.getNext();
		}
	}
	public boolean find(int elt){
		MyCursor cursor = makeIterator();
		boolean found = false;
		while(cursor.isValid()&&!found){
			if(cursor.get()==elt){
				found = true;
			}
			cursor.next();
		}
		return found;
	}
	public boolean findAndDel(int elt){
		Node prev = sentinel; 
		Node curr = sentinel.getNext();
		boolean found = false;
		while(curr!=sentinel&&!found){
			if(curr.getData()==elt){
				found = true;
				prev.setNext(curr.getNext());
			}
			curr = curr.getNext();
			prev = prev.getNext();
		}
		return found;
	}
	/*
	 * calculate the length of the list
	 */
	public int theLength(){
		return length(sentinel.getNext());
	}
	private int length(Node n){
		if(n==sentinel)
			return 0;
		else{
			return 1+length(n.getNext());
		}
	}
	/*
	 *  do increment to each element in list
	 */
	public void addList(int delta){
		increAllintlts(sentinel, delta);
	}
	private Node increAllintlts(Node n, int delta){
		if(n==sentinel){
			return new Node(sentinel); 
		}
		else{
			Node r = increAllintlts(n.getNext(), delta);
			return new Node(n.getData()+delta, r);
		}
	}
	
	public int findMax(){
		if(isEmpty()){
			return 0;
		}
		else 
			return findTheMax(sentinel);
	}
	private int findTheMax(Node n) {
		if(n.getNext()==sentinel)
			return n.getData();
		else{
			if(n.getData()>=findTheMax(n.getNext()))
				return n.getData();
			else 
				return findTheMax(n.getNext());
		}
	}
	public String toString(){
		String temp = "";
		Node cursor = sentinel.getNext();
		while(cursor!=sentinel){
			temp = temp + cursor.getData() + "\n";
			cursor = cursor.getNext();
		}
		return temp;
	}
}

