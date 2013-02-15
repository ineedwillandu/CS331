package doublelyLinkedLists;

import userDefinedInterface.MyIterator;

public class TestDoubly {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		Integer a = new Integer(1);
		Integer b = new Integer(2);
		Integer d = new Integer(4);
		Integer c = new Integer(3);
		Integer e = new Integer(4);
		Integer f = new Integer(7);
		Integer g = new Integer(3);
		dll.insertFront(a);
		dll.insertFront(b);
		dll.insertFront(d);
		dll.insertFront(c);
		dll.insertFront(e);
		dll.insertFront(f);
		dll.insertFront(g);
		MyIterator<Integer> fwdCur = dll.makeFwdIterator();
		for(int i=0; i<7; i++){
			System.out.println(fwdCur.get());
			fwdCur.next();
		}	
		System.out.println("");
		MyIterator<Integer> bwdCur = dll.makeBwdIterator();
		for(int i=0; i<7; i++){
			System.out.println(bwdCur.get());
			bwdCur.next();
		}
		System.out.println("");
		MyIterator<Integer> fwdFindCur = dll.makeFwdFindIterator(4);
		for(int i=0; i<10; i++){
			System.out.println(fwdFindCur.get());
			fwdFindCur.next();
		}
	}
}
