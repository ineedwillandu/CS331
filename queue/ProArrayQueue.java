package queue;

public class ProArrayQueue {
	private int[] a;
	private int b;
	private int f;
	
	public ProArrayQueue(int cap){
		a = new int[cap];
		b = 0;
		f = 0;
	}
	public void enq(int elt){
        a[b]=elt;
        b=(b+1)%a.length;
	}

	public int deq(){
        int elt =a[f];
        f=(f+1)%a.length;
        return elt;
	}
	public int peek(){
		return a[f];
	}
}
