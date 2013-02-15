package tries;

import java.util.LinkedList;
import java.util.ListIterator;
/*
 * @Author lishuai
 * Trie is a tree mostly for spelling search
 * each node normally stores a character
 * boolean search(String s) search in the tree whether has this word or not
 * void printTire() pre-order traversal
 * void insert(String s) insert a String into tree
 */
public class Trie{
	private Node root;
	
	public Trie(){
		root = new Node(null,true);
	}
	
	public boolean search(String s){
		if(s!=null&&s.length()>0)
			return searchAux(root,getStrIter(s));
		return false;
	}
	public void insert(String s){
		if(s!=null)
			root = insertAux(root, getStrIter(s));
	}
	public void printTrie(){
		printTrie(root);
	}

	// bug : iterator and current are not on the same page
	private boolean searchAux(Node cur, ListIterator<Character> itr){
		Character tmp = itr.next();
		if(isContained(tmp, cur)){
			if(itr.hasNext())
				return searchAux(cur.children.get(indexOf(tmp, cur)), itr);
			else
				return !cur.children.get(indexOf(tmp,cur)).marker;
		}
		return false;
	}
	private ListIterator<Character> getStrIter(String s){
		LinkedList<Character> str = new LinkedList<Character>();
		for(int i=0;i<s.length();i++)
			str.add(s.charAt(i));
		ListIterator<Character> itr = str.listIterator();
		return itr;
	}
	/*
	 * take an iterator pointing to the string
	 * update each node by updating its children through recursions
	 * be careful with iterator bug (iterator and current node are not on the same page)
	 */
	private Node insertAux(Node cur, ListIterator<Character> itr){
		if(cur.children.size()==0){
			if(itr.hasNext())
				cur.children.add(newInsertAux(itr));
		}
		else{
			if(itr.hasNext()){
				Character tmp = itr.next();
				if(isContained(tmp, cur)){
					Node tmpNode = insertAux(cur.children.get(indexOf(tmp, cur)), itr);
					cur.children.set(indexOf(tmp,cur), tmpNode);
				}
				else{
					itr.previous();// iterator bug
					cur.children.add(newInsertAux(itr));
				}
			}
			else{
				if(cur.marker)
					cur.marker=false;
			}
		}
		return cur;
	}
	private void printTrie(Node cur){
		if(cur!=null){
			System.out.println(cur.content);
			for(int i=0;i<cur.children.size();i++)
				printTrie(cur.children.get(i));
		}
	}
	private static boolean isContained(Character tmp, Node cur){
		for(int i=0;i<cur.children.size();i++){
			if(cur.children.get(i).content.equals(tmp))
				return true;
		}
		return false;
	}
	private int indexOf(Character tmp, Node cur){
		int i=0;
		for(;i<cur.children.size();i++){
			if(cur.children.get(i).content.equals(tmp))
				break;
		}
		return i;
	}
	private Node newInsertAux(ListIterator<Character> itr){
		Node cur = new Node(itr.next(), true);
		if(itr.hasNext())
			cur.children.add(newInsertAux(itr));
		else
			cur.marker=false;
		System.out.println(cur.content+": "+cur.marker);
		return cur;
	}
	
	public static void main(String args[]){
		Trie trie = new Trie();
		trie.insert("Ji Rong");
		trie.printTrie();   
		
		System.out.println(trie.search("Ji Rong"));
	}
}
