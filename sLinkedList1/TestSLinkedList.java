package sLinkedList1;

public class TestSLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SLinkedList<Integer> linkedList = new SLinkedList<Integer>();
		Integer a = 2;
		Integer b = 45;
		Integer c = 23;
		Integer d = 25;	
		linkedList.insertFront(a);
		linkedList.insertFront(b);
		linkedList.insertFront(c);
		linkedList.insertFront(d);
		System.out.println(linkedList.reverse());
		System.out.println(linkedList.findElt(45));
		linkedList.cpDelete(2);
		System.out.println(linkedList);
	}
}
