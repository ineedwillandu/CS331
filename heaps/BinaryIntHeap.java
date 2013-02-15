package heaps;

public class BinaryIntHeap {
	private int[] heapData;
	private int size;
	
	public BinaryIntHeap(){
		heapData = new int[100];
		size = 0;
	}
	
	public int size(){
		return size;
	}
	public void add(int e){
		if(++size<heapData.length){
			heapData[size-1] = e;
			keepHeap();
		}
	}
	public int retriveRoot(){
		if(size>0){
			int root = heapData[0];
			heapData[0] = heapData[--size];
			percolateDown();
			return root;
		}
		else
			return Integer.MAX_VALUE;
	}
	private void percolateDown(){
		int i = 0;
		int min = i;
		while(i*2+1<size){
			if(heapData[min]>heapData[i*2+1])
				min = i*2+1;
			if(i*2+2<size){
				if(heapData[min]>heapData[i*2+2])
					min = i*2+2;
			}
			if(min==i*2+1){
				int temp = heapData[i];
				heapData[i] = heapData[i*2+1];
				heapData[i*2+1] = temp;
				i = i*2+1;
			}
			else if(min==i*2+2){
				int temp = heapData[i];
				heapData[i] = heapData[i*2+2];
				heapData[i*2+2] = temp;
				i = i*2+2;
			}
			else
				break;
		}
	}
	private void keepHeap(){
		int i = size-1;
		while(i>0){
			if(heapData[(i-1)/2]>heapData[i]){
				int temp = heapData[i];
				heapData[i] = heapData[(i-1)/2];
				heapData[(i-1)/2] = temp;
				i = (i-1)/2;
			}
			else 
				break;
		}
	}
	
	public int[] heapData(){
		return heapData;
	}

	public static void main(String args[]){
		BinaryIntHeap heap = new BinaryIntHeap();
		heap.add(19);
		heap.add(10);
		heap.add(11);
		heap.add(2);
		heap.add(22);
		System.out.println("The current root is: "+heap.retriveRoot());
		for(int i=0;i<heap.size();i++){
			System.out.print(heap.heapData()[i]+",");
		}
	}
}