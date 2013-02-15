package bst;
import queue.ListQueue;
import userDefinedInterface.MyBSTIterator;

public class BSTree<K extends Comparable<K>, V extends Comparable<V>> {
	private class Node implements Comparable<Node>{
		private K key; 
		private V value;
		private Node left;
		private Node right;
		
		public Node(Node newLeft, K newKey, V newValue, Node newRight){
			left = newLeft;
			key = newKey;
			value = newValue;
			right = newRight;
		}
		public int compareTo(Node n){
			return 0;
		}
	}
	private class BSTIterator implements MyBSTIterator<K>{
		private ListQueue<Node> repository;
		private Node cursor;
		
		public BSTIterator(){
			if(isEmpty()!=true){
				cursor = root;
				repository = new ListQueue<Node>();
				repository.enqueue(cursor);
			}
		}
		public K get(){
			return cursor.key;
		}
		public void next(){
			if(isValid()){
				cursor = repository.dequeue();
				if(cursor.left!=null)
					repository.enqueue(cursor.left);
				if(cursor.right!=null)
					repository.enqueue(cursor.right);
			}
		}
		public boolean isValid(){
			return repository.getSize()>0;
		}
	}
	private Node root;
	private int size;
	
	public BSTree(){
		root = null;
		size = 0;
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public MyBSTIterator<K> mkBSTIterator(){
		return new BSTIterator();
	}
	public boolean contains(K key){
		return containsAux(key, root);
	}
	private boolean containsAux(K key, Node n){
		if(n==null) return false;
		if(key.compareTo(n.key)>0) return containsAux(key, n.right);
		else if(key.compareTo(n.key)<0) return containsAux(key, n.left);
		else return true;
	}
	/*
	 * recursion add
	 */
	public void insert(K key, V value){
		if(isEmpty()){
			root = new Node(null, key, value, null);
			size++;
		}
		else{
			priInsert(new Node(null, key, value, null), root);
			size++;
		}
	}
	private void priInsert(Node n, Node cursor){
		if(n.key.compareTo(cursor.key)<0)
			if(cursor.left!=null)
				priInsert(n, cursor.left);
			else
				cursor.left = n;
		else
			if(cursor.right!=null)
				priInsert(n, cursor.right);
			else
				cursor.right = n;
	}
	public V find(K key){
		if(size>0)
			return findAux(key, root);
		else 
			return null;
	}
	private V findAux(K key, Node n){
		if(n==null)	return null;
		if(key.compareTo(n.key)==0)
			return n.value;
		else if(key.compareTo(n.key)<0)
			return findAux(key, n.left);
		else
			return findAux(key, n.right);
	}
	public K revFind(V value){
		if(size==0)
			return null;
		else
			return revFindAux(value, root);
	}
	private K revFindAux(V value, Node n){
		K key = null;
		if(n!=null){
			if(value.compareTo(n.value)==0)
				return n.key;
			key = revFindAux(value, n.left);
			key =  revFindAux(value, n.right);
		}
		return key;
	}
	/*
	 * find K using queue
	 */
	public K queueRevFind(V value){
		ListQueue<Node> repository = new ListQueue<Node>();
		Node cursor = null; 
		K result = null;
		boolean notFound = true;
		if(isEmpty()!=true){
			repository.enqueue(root);
			while(repository.getSize()>0&&notFound){
				cursor = repository.dequeue();
				if(cursor.value.compareTo(value)==0){
					result = cursor.key;
					notFound = false;
				}
				if(cursor.left!=null)
					repository.enqueue(cursor.left);
				if(cursor.right!=null)
					repository.enqueue(cursor.right);
			}
		}
		return result;
	}
	public void delete(K key){
		if(size == 1){
			if(key.compareTo(root.key)==0){
				root = null;
				size--;
			}
		}
		else if(size>1){
			if(key.compareTo(root.key)!=0)
				deleteAux(key, root, root);
			else{
				if(root.right!=null&&root.left==null)
					root = root.right;
				else if(root.right==null&&root.left!=null)
					root = root.left;
				else{
					Node predecessor = findPredecessor(root.left);
					deleteAux(predecessor.key, root, root);
					predecessor.right = root.right;
					predecessor.left = root.left;
					root = predecessor;
					size++;
				}
				size--;
			}
		}
		else return;
	}
	public void deleteAux(K key, Node cursor, Node parent){
		if(cursor!=null){
			if(key.compareTo(cursor.key)<0)	deleteAux(key, cursor.left, cursor);
			else if(key.compareTo(cursor.key)>0) deleteAux(key, cursor.right, cursor);
			else if(key.compareTo(cursor.key)==0){
				if(cursor.left==null&&cursor.right==null) chopLeaf(key, cursor, parent);
				else if(cursor.left!=null&&cursor.right==null)
					if(key.compareTo(parent.key)>0)	parent.right = cursor.left;
					else parent.right = cursor.left;
				else if(cursor.left==null&&cursor.right!=null)
					if(key.compareTo(parent.key)>0) parent.right = cursor.right;
					else parent.left = cursor.right;
				else{
					Node predecessor = findPredecessor(cursor.left);
					deleteAux(predecessor.key, cursor, cursor);
					predecessor.right = cursor.right;
					predecessor.left = cursor.left;
					if(key.compareTo(parent.key)>0) parent.right = predecessor;
					else parent.left = predecessor;
					size++;
				}
				size--;
			}
		}
	}
	private Node findPredecessor(Node cursor){
		if(cursor.right==null) return cursor; 
		else return findPredecessor(cursor.right);
	}
	private void chopLeaf(K key, Node cursor, Node parent){
		if(key.compareTo(parent.key)>0)	parent.right = null;
		else parent.left =null;
	}
	/*
	 * not a good delete(incomplete)
	 */
	public void cadelete(K key){
		Node parent = null;
		parent = recurFind(key);
		if(parent.left!=null)
			if(parent.left.key.compareTo(key)==0){
				judge(parent.left);
				
			}
			else{
				judge(parent.right);
			}
		else{
			judge(parent.right);
		}
	}
	private Node recurFind(K key){
		if(isEmpty()!=true){
			Node cursor = root;
			Node parent = root;
			return findNode(key, cursor, parent);
		}
		else
			return null;
	}
	private Node findNode(K key, Node cursor, Node parent){
		if(cursor.key.compareTo(key)==0)
			return parent;
		else if(key.compareTo(cursor.key)<0){
			parent = cursor;
			return findNode(key, cursor.left, parent);
		}
		else {
			parent = cursor;
			return findNode(key, cursor.right, parent);
		}
	}
	private String judge(Node node){
		if(node == root)
			return "root";
		else if(node.right==null&&node.left==null)
			return "leaf";
		else if(node.right==null&&node.left!=null&&(node.left.right==null&&node.left.left==null))
			return "hasLeftLeaf";
		else if(node.left==null&&node.left!=null&&(node.left.right==null&&node.left.left==null))
			return "hasRightLeaf";
		else 
			return "successor";
	}
}
