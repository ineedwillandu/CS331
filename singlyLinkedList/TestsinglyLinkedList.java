package singlyLinkedList;

public class TestsinglyLinkedList {
	public static void main(String[] args){
		SinglyLinkedList<Integer> linkList = new SinglyLinkedList<Integer>();
		Integer a = 1;
		Integer b = 3;
		Integer c = 29;
		Integer d = 23;
		linkList.insertFront(a);
		linkList.insertFront(b);
		linkList.insertFront(c);
		linkList.insertFront(d);
		/*System.out.println(linkList.find(23));
		System.out.println(linkList);
		System.out.println(linkList.getSize());
		linkList.spDelete(1);
		System.out.println(linkList.getSize());
		System.out.println(linkList.find(1));
		linkList.spDelete(3);
		System.out.println(linkList.find(23));
		System.out.println(linkList);
		System.out.println(linkList.getHead()); 
		*/
		System.out.println(linkList.reverse());
	}
	
}

