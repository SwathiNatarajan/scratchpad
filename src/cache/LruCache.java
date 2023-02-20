package cache;

/**
 * Created by thotap on 6/9/2017.
 */
public class LruCache {
  private Node head;
  private Node tail;
  private int size;
  private int maxSize;

  public LruCache(int size){
    this.maxSize = size;
  }

  public void put(int key, int value){
    if(head==null && tail==null){
      head=tail=new Node(key, value);
      size++;
    }else{
      Node temp = head;
      while (temp!=null){
        if(temp.key()==key){
          temp.value(value);
          return;
        }
        temp = temp.next();
      }
      if(maxSize==size){
        Node removableNode = head;
        Node nextNode = removableNode.next();
        nextNode.previous(null);
        head = nextNode;
        size--;
      }
      Node newNode = new Node(key, value);
      newNode.previous(tail);
      tail.next(newNode);
      tail = tail.next();
      size++;
    }
  }

  public Integer get(int key){
    Node temp = null;
    if(head.key()==key){
      temp = head;
      head = temp.next();
    } else {
      temp = head.next();
      while (temp != null) {
        if (temp.key() == key) {
          break;
        }
        temp = temp.next();
      }
    }

      if (temp == null) {
        return null;
      } else {
        Node previous = temp.previous();
        Node next = temp.next();
        if (previous != null) {
          previous.next(next);
        }
        next.previous(previous);
        temp.previous(tail);
        tail.next(temp);
        temp.next(null);
        tail = tail.next();
        return tail.value();
      }


  }

  public void print(){
    Node temp = head;
    while (temp!=null){
      System.out.print(temp.key()+ ":" + temp.value() + " ");
      temp = temp.next();
    }
  }

  public static void main(String[] args) {
    LruCache cache = new LruCache(4);
    cache.put(1,1);
    cache.put(2,2);
    cache.put(3,3);
    cache.put(4,4);
    cache.print();
    cache.put(5,5);
    System.out.println();
    cache.print();
    System.out.println("cache.get(2) = " + cache.get(2));
    cache.print();
    cache.put(6,6);
    System.out.println();
    cache.print();
  }







}
class Node{
  private Integer key;
  private Integer value;
  private Node next;
  private Node previous;
  public Node(int key, int value){
    this.key = key;
    this.value = value;
    }

    public Node next(){
    return this.next;
    }

    public void next(Node next){
      this.next = next;
    }

    public int key(){
      return this.key;
    }

    public int value(){
      return this.value;
    }

    public void value(int value){
      this.value = value;
    }

    public Node previous(){
     return this.previous;
    }

    public void previous(Node previous){
      this.previous = previous;
    }
}
