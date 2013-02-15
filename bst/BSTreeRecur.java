package bst;

import avlTree.AVLTree;
import avlTree.AVLTree.Node;

public class BSTreeRecur {
	public class Node{
		private Node right;
		private Node left;
		private Integer data;
		
		public Node(Node left, Node right, Integer data){
			this.left = left;
			this.right = right;
			this.data = data;
		}
	}
	
	private Node root;
	
	public BSTreeRecur(){
		root = null;
	}
	public int size(){
		return sizeAux(root);
	}
	private int sizeAux(Node cur){
		if(cur==null)
			return 0;
		else
			return 1+sizeAux(cur.left)+sizeAux(cur.right);
	}
	public void add(Integer data){
		root = addAux(root, data);
	}
	private Node addAux(Node cur , Integer data){
		if(cur==null)
			return new Node( null, null, data);
		else{
			if(data<cur.data)
				cur.left= addAux(cur.left, data);
			else 
				cur.right = addAux(cur.right, data);
			return cur;
		}
	}
	public void delete(Integer data){
		root = deleteAux(root, data);
	}
	private Node deleteAux(Node cur, Integer data){
		if(cur==null)
			return null;
		else{
			if(data<cur.data)
				cur.left = deleteAux(cur.left, data);
			else if(data>cur.data)
				cur.right = deleteAux(cur.right, data);
			else{
				int leftSize = sizeAux(cur.left);
				int rightSize = sizeAux(cur.right);
				if(leftSize==0&&rightSize==0)
					cur = null;
				else if(leftSize==0&&rightSize==1)
					cur = cur.right;
				else if(leftSize==1&&rightSize==0)
					cur = cur.left;
				else
					cur = predecessor(cur.left, cur);
			}
			return cur;
		}
	}
	private Node predecessor(Node cur, Node parent){
		if(cur.right==null){
			parent.right = cur.left; //cut predecessor off
			return cur;
		}
		else
			return predecessor(cur.right, cur);
	}
	public int getTreeHeight(){
		return heightAux(root);
	}
	public int heightAux(Node cur){
		if(cur==null)
			return 0;
		else{
			int leftHeight = heightAux(cur.left);
			int rightHeight = heightAux(cur.right);
			return leftHeight>rightHeight?1+leftHeight:1+rightHeight;
		}
	}
	public static void main(String args[]){
		BSTreeRecur tree = new BSTreeRecur();
		tree.add(16);
		tree.add(8);
		tree.add(32);
		tree.add(4);
		tree.add(12);
		System.out.println(tree.size());
		System.out.println(tree.getTreeHeight());
	}
}