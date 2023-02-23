package queue;


import stack.Stack;

public class QueueWithDoubleStack {
  private Stack inbound;
  private Stack outbound;
  private int size;

  public QueueWithDoubleStack(int size) {
    this.size = size;
    inbound = new Stack(size);
    outbound = new Stack(size);
  }

  public void add(int data){
    inbound.push(data);
  }

  public boolean isEmpty(){
    return inbound.isEmpty() && outbound.isEmpty();
  }

  public int remove(){
    if(outbound.isEmpty()) {
      while (!inbound.isEmpty()) {
        outbound.push(inbound.pop());
      }
    }

    return outbound.pop();
  }

  public static void main(String[] args) {
    QueueWithDoubleStack stackQ = new QueueWithDoubleStack(10);
    for(int i=0; i<10; i++){
      stackQ.add(i);
    }

    for(int i=0; i<5; i++){
      System.out.print( stackQ.remove() +" ");;
    }

    for(int i=0; i<5; i++){
      stackQ.add(i);
    }

    while (!stackQ.isEmpty()){
      System.out.print( stackQ.remove() +" ");
    }
  }

}
