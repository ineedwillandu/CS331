package singlyLinkedList;

public class SinglyLinkedList<E>{
	private class Node<E>{
		private E data;
		private Node next;
		public Node(){
			setData(null);
			setNextNode(null);
		}
		public Node(E elt, Node nextNode){
			setData(elt);
			setNextNode(nextNode);	
		}
		public Node(E elt){
			setData(elt);
			setNextNode(null);
		}
		
		private void setData(E elt){
			data = elt;
		}
		private void setNextNode(Node nextNode){
			next = nextNode;
		}
		public Node getNextNode(){
			return next;
		}
		public E getData(){
			return data;
		}
	}
	private Node head; 
	private int size;
	private Node last;
	private Node cursor;
	
	public SinglyLinkedList(){
		head = null;
		cursor = head;
		last = head;
	}
	public E getFirstElt(){
		return (E)head.getData();
	}
	
	public boolean find(E elt){
		boolean found = false;
		Node tempPointer = head;
		if(elt!=null){
			while(tempPointer!=null&&!found){
				if(elt.equals(tempPointer.getData())){
					found = true;
				}
				tempPointer = tempPointer.getNextNode();
			}
			return found;
		}
		else
			return found;
	}
	public void insertFront(E elt){
		Node newNode = new Node();
		newNode.setData(elt);
		if(head!=null){
			newNode.setNextNode(head.getNextNode());
			head.setNextNode(newNode);
		}
		else{
			head = new Node();
			head.setNextNode(newNode);
		}
		size++;
	}
	public void insertBack(E elt){
		last = new Node(elt, last);
		size++;
	}
	public boolean cpDelete(E elt){
		boolean found = false;
		Node tempPointer = head.getNextNode();
		Node prev = null;
		while(tempPointer!=null){
			if(elt.equals(tempPointer.getData())){
				if(tempPointer.getNextNode()!=null&&tempPointer.getNextNode().getNextNode()!=null){
					found = true;
					tempPointer.setData(tempPointer.getNextNode().getData());
					tempPointer.setNextNode(tempPointer.getNextNode().getNextNode());
				}
				else if(tempPointer.getNextNode()==null){
					prev.setNextNode(null);
				}
				else{
					prev.setNextNode(tempPointer.getNextNode());
				}
				size--;
			}
			prev = tempPointer;
			tempPointer = tempPointer.getNextNode();
		}
		return found;
	}
	public int getSize(){
		return size;
	}
	public boolean spDelete(E elt){
		Node tempPointer = head.getNextNode();
		Node prev = null;
		boolean found = false;
		while(tempPointer!=null&&!found){
			if(elt.equals(tempPointer.getData())){
				found = true;
				if(tempPointer.getNextNode()!=null){
					prev.setNextNode(tempPointer.getNextNode());
				}
				else{
					prev.setNextNode(null);
				}
				size--;
			}
			prev = tempPointer;
			tempPointer = tempPointer.getNextNode();
		}
		return found;
	}
	
	private E findEnd(){
		E end = null;
		Node tempPointer = head;
		while(tempPointer!=null){
			if(tempPointer.getNextNode()==null){
				end = (E)tempPointer.getData();
			}
			tempPointer = tempPointer.getNextNode();
		}
		return end;
	}
	public SinglyLinkedList reverse(){
		SinglyLinkedList<E> revList = new SinglyLinkedList<E>();
		Node tempPointer = head;
		Node prev = head;
		while(tempPointer.getNextNode()!=null){
			revList.insertFront((E)head.getNextNode().getData());
			if(tempPointer.getNextNode().getNextNode()!=null){
				head.setNextNode(tempPointer.getNextNode().getNextNode());
				//prev = tempPointer;
				//tempPointer = tempPointer.getNextNode();
			}
			else
				tempPointer.setNextNode(null);
		}
		return revList;
	
	}
	public String toString(){
		String listView = "";
		Node tempPointer = head;
		while(tempPointer!=null){
			listView = listView + tempPointer.getData() + "\n";
			tempPointer = tempPointer.getNextNode();
		}
		return listView;
	}
}
