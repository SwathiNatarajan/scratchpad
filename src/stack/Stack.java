package stack;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by thotap on 5/2/2017.
 */
public class Stack {
  private int[] data;
  private int size;
  private AtomicInteger index;

  public Stack(int size) {
    this.size = size;
    this.index = new AtomicInteger(-1);
    this.data = new int[size];
  }

  public boolean isEmpty() {
    return index.get() < 0;
  }

  public void push(int num) {
    if (index.get() == size - 1) {
      throw new StackOverflowError("Stack is full");
    }
    index.getAndIncrement();
    data[index.get()] = num;

  }

  public int pop() {
    if (isEmpty()) {
      throw new RuntimeException("Stack is empty");
    }

    int num = data[index.get()];
    index.getAndDecrement();
    return num;
  }
}
