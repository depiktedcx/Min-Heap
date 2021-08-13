// Interface for a (min)heap
// Maintains a heap of integers where the root is the smallest value in the heap
// @author Tony C. Smith
//
public interface MinHeapFace{
    public void add(int x); // add int to MinHeap
    public int get(); // return but do not remove top of heap
    public void remove(); // remove top of heap
    public void replace(int x); // replace top of heap with int
    public void clear(); // remove everything from heap
    public boolean isEmpty(); // return true if nothing in heap, false otherwise
    public int size(); // return count of how many items in heap
}
