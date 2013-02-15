package finalSLinkedList;
import userDefinedInterface.MyIterator;

public class TestFSL {

	/**
	 * For testing final singly linked list. 
	 */
	public static void main(String[] args) {
		SLinkedList<Integer> list = new SLinkedList<Integer>();
		System.out.println(list.getSize());
		list.insertFront(new Integer(1));
		list.insertFront(new Integer(2));
		list.insertFront(new Integer(18));
		list.insertFront(new Integer(12));
		SLinkedList<Integer> sortedList = list.sort();
		MyIterator<Integer> iterator = sortedList.mkFwdIterator();
		System.out.println(list.find(10));
		System.out.println(list.getSize());
		//System.out.println(list.delete(10));
		for(int i=0;i<4;i++){
			System.out.println(iterator.get());
			iterator.next();
		}
	}
}
