package queue;

public class ArrayQueue {
	private int[] anArray; 
	private int front;
	private int back;
	
	public ArrayQueue(int cap){
		anArray = new int[cap];
		front = 0;
		back = 0;
	}
	public void enqueue(int elt){
		if(front<anArray.length){
			anArray[front] = elt;
			front++;
		}
		else{
			front = 0;
			anArray[front] = elt;
		}
	}
	public void dequeue(){
		if(back!=front&&back<anArray.length)
			back++;
		else if(back==anArray.length)
			back = 0;
	}
	public int peep(){
		return anArray[back];
	}
}
