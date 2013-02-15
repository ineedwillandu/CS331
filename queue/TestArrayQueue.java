package queue;

public class TestArrayQueue {
	public static void main(String[] args){
		ProArrayQueue pa = new ProArrayQueue(5);
		pa.deq();
		pa.deq();
		pa.enq(1);
		System.out.println(pa.peek());
	}
}
