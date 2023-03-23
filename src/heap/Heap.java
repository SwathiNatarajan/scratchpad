package heap;

import java.util.Map;

public class Heap {

    int[] heap;
    int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        heap = new int[this.capacity];
    }

    public int parent(int i) {
        if (i < 0 || i > this.capacity - 1) {
            return -1;
        }
        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        if (i < 0 || i > this.capacity - 1) {
            return -1;
        }
        return 2 * i + 1;
    }

    public int rightChild(int i) {
        if (i < 0 || i > this.capacity - 1) {
            return -1;
        }
        return 2 * i + 2;
    }

    public int getMax() {
        if (this.capacity == 0) {
            return -1;
        }
        return heap[0];
    }

    private void swap(int[] heap, int child, int parent){
         int temp = heap[child];
         heap[child] = heap[parent];
         heap[parent] = temp;
    }

    public void heapify(int key){
          if(heap.length == capacity){
              return;
          }
          int i = heap.length;
          heap[i]=key;
          int parentIndex = parent(i);
          // fix the heap
        while (i != 0 && heap[i] > heap[parentIndex]) {
            swap(heap,i,parentIndex);
            i = parentIndex;
        }
    }
}
