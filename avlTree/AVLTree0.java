package avlTree;

import java.util.LinkedList;
/*
 * @Author lishuai
 * Each avltree node has a height, which record the height of its corresponding node
 * void add(data) take a data and add it to tree with necessary rotation
 * display() BFS display tree
 * printTree() BFS display each level of tree one time
 * int size() return the size of this tree in-order traversal
 * 
 */
public class AVLTree0 {
	public class Node{
		private Node right;
		private Node left;
		private Integer data;
		private Integer height;
		
		public Node(Node left, Node right, Integer data, Integer height){
			this.left = left;
			this.right = right;
			this.data = data;
			this.height = height;
		}
	}
	
	private Node root;
	
	public AVLTree0(){
		root = null;
	}
	public int size(){
		return sizeAux(root);
	}
	public void add(Integer data){
			root = addAux(data, root);
	}
	public void display(){
		if(root==null)
			return;
		MyQueue<AVLTree0.Node> queue = new MyQueue<AVLTree0.Node>();
		queue.enqueue(root);
		displayAux(queue);
	}
	// BFS modification version to display each level of the tree on time
	public void printTree(){
		if(root==null)
			return;
		else{
			LinkedList<AVLTree0.Node> currentLevel = new LinkedList<AVLTree0.Node>();
			currentLevel.add(root);
			while(currentLevel.size()>0){
				LinkedList<AVLTree0.Node> parents = currentLevel;
				currentLevel = new LinkedList<AVLTree0.Node>();
				for(AVLTree0.Node parent: parents){
					System.out.print(parent.data+" ");
					if(parent.left!=null)
						currentLevel.add(parent.left);
					if(parent.right!=null)
						currentLevel.add(parent.right);
				}
				System.out.println();
			}
		}
	}
	private int sizeAux(Node node){
		if(node==null)
			return 0;
		else
			return sizeAux(node.left)+1+sizeAux(node.right);
	}
	// BFS display
	private void displayAux(MyQueue<AVLTree0.Node> queue){
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
	// update each current node through the recursions and return it
	private Node addAux(Integer data, Node cur){
		if(cur==null)
			return new Node(null, null, data, 0);
		else{
			if(data<cur.data){
				cur.left = addAux(data, cur.left);
				if(balance(cur)==2){
					if(balance(cur)*balance(cur.right)>=0)
						cur = singleRightRotate(cur);
					else
						cur = doubleRightRotate(cur);
				}
			}
			else if(data>cur.data){
				cur.right = addAux(data, cur.right);
				if(balance(cur)==-2){
					if(balance(cur)*balance(cur.left)>=0)
						cur = singleLeftRotate(cur);
					else
						cur = doubleLeftRotate(cur);
				}
			}
			else{
				System.out.println("Duplicate "+data+"!");
			}
			cur.height = max(height(cur.right), height(cur.left))+1;
		}
		return cur;	
	}
	// crucial part is updating the height of rotation 
	// the height of subtree of the updating node is not changed
	private static Node singleLeftRotate(Node r){
		Node tmp = r.right;
		r.right = tmp.left;
		tmp.left = r;
		r.height = max(height(r.left), height(r.right))+1;// update higher node first
		tmp.height = max(height(tmp.left), height(tmp.right))+1;
		return tmp;
	}
	private static Node doubleLeftRotate(Node r){
		r.right = singleRightRotate(r.right);
		return singleLeftRotate(r);
	}
	private static Node singleRightRotate(Node r){
		Node tmp = r.left;
		r.left = tmp.right;
		tmp.right = r;
		r.height = max(height(r.left), height(r.right))+1;
		tmp.height = max(height(tmp.left), height(tmp.right))+1;
		return tmp;
	}
	private static Node doubleRightRotate(Node r){
		r.left = singleLeftRotate(r.left);
		return singleRightRotate(r);
	}
	private static int max(int right, int left){
		return right>left?right:left;
	}
	private static int balance(Node cur){
		return cur==null?0:height(cur.left) - height(cur.right);
	}
	private static int height(Node cur){
		return cur==null?-1:cur.height;
	}
	
	public static void main(String args[]){
		AVLTree0 avlTree = new AVLTree0();
		avlTree.add(4);
		avlTree.add(8);
		avlTree.add(12);
		avlTree.add(8);
		avlTree.add(16);
		avlTree.add(32);
		//avlTree.display();
		avlTree.printTree();
	}
}
