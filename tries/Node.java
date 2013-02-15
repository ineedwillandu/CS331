package tries;

import java.util.ArrayList;


public class Node{
	protected Character content;
	protected boolean marker; //false means ending mark
	protected ArrayList<Node> children;
	
	public Node(Character content, boolean marker){
		this.content = content;
		this.marker = marker;
		children = new ArrayList<Node>();
	}
}