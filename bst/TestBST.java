package bst;
import userDefinedInterface.MyBSTIterator;

public class TestBST {

	/**
	 * for testing BSTree.java
	 */
	public static void main(String[] args) {
		BSTree<Integer, Integer> bst = new BSTree<Integer, Integer>();
		bst.insert(2, 3);
		bst.insert(5, 10);
		bst.insert(1, 12);
		System.out.println(bst.size());
		bst.delete(5);
		MyBSTIterator<Integer> cur = bst.mkBSTIterator();
		do{
			cur.next();
			System.out.println(cur.get());
		}while(cur.isValid());
		System.out.println(bst.size());
		System.out.println(bst.find(2));
		System.out.println(bst.queueRevFind(10));
		System.out.println(bst.revFind(12));
	}
}
