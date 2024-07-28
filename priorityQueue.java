public class priorityQueue {
    
    int[] heap;
    int size;
    int capacity;

    priorityQueue(int capacity){

        this.capacity=capacity;
        this.size=0;
        this.heap=new int[capacity];
    }

    int parent(int i){
         return (i-1)/2;
    }

    int left(int i){
        return i*2+1;
    }

    int right(int i){
        return i*2+2;
    }

    int peek(){
        if(size==0){
            throw new IllegalStateException("Queue is empty");
        }

        return heap[0];
    }

    int poll(){
        if(size==0){
            throw new IllegalStateException("Queue is empty");
        }

        int min=heap[0];
        heap[0]=heap[size-1];
        size--;
        downHeapify(0);
        return min;
    }

    void insert(int ele){

        if(size==capacity){
            throw new IllegalStateException("Queue is full!!");
        }

        heap[size]=ele;
        size++;
        upHeapify(size-1);

    }

   private void upHeapify(int i) {

       if(i==0){
         return;
       }

       int parent=(i-1)/2;

       if(parent>=0 && heap[parent]>heap[i]){
         swap(parent,i);
         upHeapify(parent);
       }
   }

 private void downHeapify(int i) {

        int min=i;

        int left=2*i+1;
        if(left<size && heap[left]<heap[min]){
            min=left;
        }

        int right=2*i+2;
        if(right<size && heap[right]<heap[min]){
            min=right;
        }

        if(min!=i){
            swap(min,i);
            downHeapify(min);
        }
    }

    private void swap(int min, int i) {

        int temp=heap[min];
        heap[min]=heap[i];
        heap[i]=temp;
    }
}
