package list;

public class LinkedList {
    private Node head;

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next() != null) {
            current = current.next();
        }
        current.next(newNode);

    }

    private void append(Node newNode) {

        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next() != null) {
            current = current.next();
        }
        current.next(newNode);
    }

    public void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data() + ", ");
            current = current.next();

        }

    }

    public LinkedList reverse() {
        if (head == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.append(head.reverse());
        return linkedList;
    }

    public LinkedList itReverse() {
        if (head == null) {
            return null;
        }
        Node prev, curr, next;
        prev = null;
        curr = head;
        next = null;
        while (curr != null) {
            next = curr.next();
            curr.next(prev);
            prev = curr;
            curr = next;
//      next = next.next();
        }
        LinkedList reverse = new LinkedList();
        reverse.append(prev);
        return reverse;
    }

    public void reverse(Node previous, Node current, LinkedList list) {
        if (current == null) {
            list.append(previous.data());
        } else if (current.next() == null) {
            current.next(previous);
        } else {
            reverse(current, current.next(), list);

        }
    }

    public LinkedList iterativeReverse() {
        if (head == null) {
            return null;
        }

        Node previous = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next();
            current.next(previous);
            previous = current;
            current = next;
        }

        LinkedList reverse = new LinkedList();
        reverse.append(previous);
        return reverse;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 10; i++) {
            linkedList.append(i);
        }
        linkedList.print();
        System.out.println();
//    LinkedList reversedList = linkedList.reverse();
//    reversedList.print();
        System.out.println();
        LinkedList reversedList = linkedList.iterativeReverse();
        reversedList.print();
    }


}


class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node next() {
        return this.next;
    }

    public void next(Node node) {
        this.next = node;
    }

    public int data() {
        return this.data;
    }

    public Node reverse() {
        if (next() == null) {
            return this;
        }
        Node rNode = next.reverse();
        next.next = this;
        next = null;
        return rNode;
    }

}
