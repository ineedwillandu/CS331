package stack;

public class TestArrayStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayStack as1 = new ArrayStack();
		for(int i=0;i<14;i++){
			as1.push(i);
		}
		System.out.println(as1.lookAtTop());
	}
		
}
