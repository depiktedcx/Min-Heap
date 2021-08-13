//Kelvin
//1504568
class MyMinHeap implements MinHeapFace{
    int[] heap;
    public int[] check(){
    return heap;
    }
    //Create new min heap
    public MyMinHeap(){
	heap = new int[30];
	heap[0] = 0;
    }
    //Add int to heap
    public void add(int x){
	//Check if final spot is taken and resize if true
	if(heap[0] == heap.length - 1){
	    resize();
	}
        //Set next spot
        heap[size() + 1] = x;
	heap[0] += 1;
	
        upheap();
    }
    //Move bottom item up if required
    private void upheap(){
	if(size() == 1){
	    return;
	}
	//Get index of item being moved
	int currIndex = size();
	//Get index of parent of item
	int parentIndex = currIndex/2;
	while(heap[currIndex] < heap[parentIndex] && currIndex > 1){
	    //Store parental value
	    int tmp = heap[parentIndex];
	    //Store upheaped value into parental space
	    heap[parentIndex] = heap[currIndex];
	    //Store parental value into upheaped space
	    heap[currIndex] = tmp;
	    //Adjust indexes
	    currIndex = parentIndex;
	    parentIndex = parentIndex / 2;
	}
	return;
    }
    //Move top item down if required
    private void downheap(){
	//Check if only 1 item
	if(size() == 1){
	    return;
	}
	//Assign respective indexes
	int currIndex = 1;
	int leftIndex = currIndex * 2;
	int rightIndex = leftIndex + 1;
	//Check if indexes are within range and that curr is greater than both its children
	while(heap[currIndex] > heap[leftIndex] || heap[currIndex] > heap[rightIndex]){
		//Check if left is smaller than right or vice versa
		//Replace smallest child
		if(heap[leftIndex] > heap[rightIndex]){
		    int tmpS = heap[rightIndex];
		    heap[rightIndex] = heap[currIndex];
		    heap[currIndex] = tmpS;
		    currIndex = rightIndex;
		}else{
		    int tmpS = heap[leftIndex];
		    heap[leftIndex] = heap[currIndex];
		    heap[currIndex] = tmpS;
		    currIndex = leftIndex;
		}
	    //Adjust indexes
	    leftIndex = currIndex * 2;
	    rightIndex = leftIndex + 1;
	    //Check if still within bounds
	    if(leftIndex > size() || rightIndex > size()){
	    	return;
	    }
	}
	return;
    }
    //Get head of heap
    public int get(){
	if(isEmpty()){
	    System.err.println("The heap is empty!");
	    return -1;
	}
	return heap[1];
    }
    //Resize heap
    private void resize(){
	//Increase by 20%
	int tPercent = (heap.length / 10) * 2;
	int[] tmp = new int[tPercent + heap.length];
	//Copy values over
	for(int i = 0; i < heap.length; i++){
	    tmp[i] = heap[i];
	}
	heap = tmp;
    }
    //Remove head of heap
    public void remove(){
	//Check if emtpy
	if(isEmpty()){
	    return;
	}
	//Move lowest value to top
	heap[1] = heap[size()];
	//Adjust size
	heap[0] = size() - 1;
	downheap();
    }
    //Replace head with int x
    public void replace(int x){
	//Replace top and downheap
	heap[1] = x;
	if(size() == 0 ){
	    heap[0] = 1;
	}
	downheap();
    }
    //Clear the heap
    public void clear(){
    //Create heap as a new empty array
	heap = new int[heap.length];
	heap[0] = 0;
    }
    //Return whether or not the heap is empty
    public boolean isEmpty(){
    //Return true if no values exist
	if(size() == 0){
	    return true;
	}
	//Else false
	return false;
    }
    //Return the size of the heap
    public int size(){
    //Return the amount of values excluding counter
	return heap[0];
    }
}
