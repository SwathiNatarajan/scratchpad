package stack;

import java.util.*;

public class MinStack {
    List<Integer> stack;
    Queue<Integer> heap;

    int counter=0;

    public MinStack() {
        stack = new ArrayList<>();
        heap = new PriorityQueue<>((a, b) -> a < b ? a : b);
    }

    public void push(int val) {
       stack.add(counter++,val);
       heap.add(val);
    }

    public void pop() {
        Integer val = stack.remove(counter--);
        heap.remove(val);
    }

    public int top() {
        return stack.get(counter);
    }

    public int getMin() {
         return heap.poll();
    }
}
