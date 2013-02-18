package redBlackTree;

public class RBNode {
	public enum Color{
		RED, BLACK;
	}
	
	protected RBNode left, right, parent;
	protected Integer data;
	Color color;
	
	public RBNode(RBNode parent, Integer data){
		left = new RBNode(this);
		right = new RBNode(this);
		this.parent = parent;
		this.data = data;
		color = Color.RED;
	}
	
	public RBNode(RBNode parent){
		left = null;
		right = null;
		this.parent = parent;
		data = null;
		color = Color.BLACK;
	}
}
