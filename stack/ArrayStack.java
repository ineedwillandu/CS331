package stack;

public class ArrayStack {
	private int[] anArray;
	private int topPointer;
	
	public ArrayStack(){
		anArray = new int[10];
		topPointer = 0;
	}
	public ArrayStack(int cap){
		anArray = new int[cap];
		topPointer = 0;
	}
	public void push(int elt){
		if(topPointer<anArray.length){
			anArray[topPointer] = elt;
			topPointer++;
		}
		else
			doubleArray(elt);
	}
	private void doubleArray(int elt){
		int newArray[] = new int[anArray.length*2];
		for(int i=0;i<anArray.length;i++){
			newArray[i] = anArray[i];
		}
		anArray = newArray;
		push(elt);
	}
	public int pop(){
		int topElt = anArray[topPointer-1];
		topPointer--;
		return topElt;
	}
	public int lookAtTop(){
		return anArray[topPointer-1];
	}
}
