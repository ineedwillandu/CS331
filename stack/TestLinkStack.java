package stack;

public class TestLinkStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListStack<Integer> ls1 = new ListStack<Integer>();
		for(Integer i=0;i<10;i++){
			ls1.push(i);
		}
		System.out.println(ls1.lookAtTop());
	}

}
