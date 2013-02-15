package avlTree;

public class AVLTree {
	public class Node{
		private Node right;
		private Node left;
		private Integer data;
		private Integer balance;
		
		public Node(Node left, Node right, Integer data, Integer balance){
			this.left = left;
			this.right = right;
			this.data = data;
			this.balance = balance;
		}
	}
	
	private Node root;
	
	public AVLTree(){
		root = null;
	}
	public int size(){
		return sizeAux(root);
	}
	private int sizeAux(Node node){
		if(node==null)
			return 0;
		else
			return sizeAux(node.left)+1+sizeAux(node.right);
	}
	public void add(Integer data){
		if(root==null)
			root = new Node(null, null, data, 0);
		else
			addAux(data, root, root);
	}
	public void display(){
		if(root==null)
			return;
		MyQueue<AVLTree.Node> queue = new MyQueue<AVLTree.Node>();
		queue.enqueue(root);
		displayAux(queue);
	}
	private void displayAux(MyQueue<AVLTree.Node> queue){
		if(!queue.isEmpty()){
			Node tmp = queue.dequeue();
			System.out.println(tmp.data);
			if(tmp.left!=null)
				queue.enqueue(tmp.left);
			if(tmp.right!=null)
				queue.enqueue(tmp.right);
			displayAux(queue);
		}
		else
			return;
	}
	private Integer addAux(Integer data, Node cur, Node parent){
		if(data>=cur.data){
			if(cur.right==null)
				cur.right = new Node(null, null, data, 0);
			else{
				int rightBalance = addAux(data, cur.right, cur);
				if(rightBalance!=0)
					cur.balance--;
				if(cur.balance==-2){
					if(cur.balance*rightBalance<0){
						rightRotation(cur.right, true, parent);
						leftRotation(cur, true, parent);
					}
					else
						leftRotation(cur, true, parent);
				}
			}
		}
		else{
			if(cur.left==null)
				cur.left = new Node(null, null, data, 0);
			else{
				int leftBalance = addAux(data,cur.left, cur);
				if(leftBalance!=0)
					cur.balance--;
				if(cur.balance==2){
					if(cur.balance*leftBalance<0){
						leftRotation(cur.left, false, parent);
						rightRotation(cur, false, parent);
					}
					else
						rightRotation(cur, false, parent);
				}
			}
		}
		return cur.balance;	
	}
	public static void rightRotation(Node node, boolean isRight, Node parent){
		if(isRight)
			parent.right = node.left;
		else
			parent.left = node.left;
		Node tmp = node.left.right;
		node.left.right = node;
		node.left = tmp;
		
	}
	public static void leftRotation(Node node, boolean isRight, Node parent){
		Node tmp = node.right.left;
		Node tmp0 = node.right;
		node.right.left = node;
		node.left = tmp;
		if(isRight)
			parent.right = tmp0;
		else
			parent.left = tmp0;
	}
	public static void main(String args[]){
		AVLTree avlTree = new AVLTree();
		avlTree.add(16);
		avlTree.add(8);
		avlTree.add(32);
		avlTree.add(4);
		avlTree.add(12);
		avlTree.display();
		System.out.println();
		rightRotation(avlTree.root.left, false, avlTree.root);
		avlTree.display();
	}
}
