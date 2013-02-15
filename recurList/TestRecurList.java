package recurList;

public class TestRecurList {
	public static void main(String[] args){
		RecurList recurList = new RecurList();
		recurList.insertFront(12);
		recurList.insertFront(23);
		recurList.insertFront(1);
		recurList.insertFront(2);
		System.out.println(recurList);
		//System.out.println(recurList.getLast());
		System.out.println(recurList.find(23));
		//recurList.increAll(5);
		//System.out.println(recurList);
		//System.out.println(recurList.findMax());
		recurList.findAndDel(23);
		System.out.println(recurList);
	}
}
