package tree;

import java.util.*;

/**
 * Created by thotap on 4/20/2017.
 */
public class BinarySearchTree {
  private Node root;

  public Node getRoot() {
    return root;
  }

  public void add(int data) {
    Node newNode = new Node(data,0);
    if (root == null) {
      root = newNode;
      return;
    } else {
      root.addNode(newNode);
    }
  }
  public void add(int data, int relativity) {
    Node newNode = new Node(data, relativity);
    if (root == null) {
      root = newNode;
      return;
    } else {
      root.addNode(newNode);
    }
  }

  public void remove(){

  }

  public void shadowOrder(){
    if(root!=null){
      Map<Integer, List<Node>> relativityMap = new TreeMap<>();
      root.shadowOrder(relativityMap);

      for(Integer relativity: relativityMap.keySet()){
        List<Node> nodes = relativityMap.get(relativity);
        if(nodes!=null && !nodes.isEmpty()){

            System.out.print(nodes.get(nodes.size()-1).data() + " ");

        }
      }
    }
  }

  public void inOrder() {
    if (root != null) {
      root.inOrder();
    }
  }

  public void postOrder() {
    if (root != null) {
      root.postOrder();
    }
  }

  public void preOrder() {
    if (root != null) {
      root.preOrder();
    }
  }

  public void bfs() {
    if (root != null) {
      root.bfs();
    } else {
      System.out.println("Tree is empty");
    }
  }

  public Node search(int data) {
    Node node = null;
    if (root != null) {
      node = root.search(data);

    }
    return node;
  }

  public int maxDepth() {
    if (root != null) {
      return root.maxDepth();
    }
    return 0;
  }

  public boolean isMirror(BinarySearchTree tree) {

    if (tree == null) {
      return false;
    }
    if (this.root == null && tree.root == null) {
      return true;
    }
    if(this.root == null || tree.root == null){
      return false;
    }
//    return root.isMirror(tree.root);
    return isMirror(this.root, tree.root);
  }

  private boolean isMirror(Node node1, Node node2){
    if (node1 == null && node2 == null) {
      return true;
    }
    if(node1 == null || node2 == null){
      return false;
    }

    return node1.data() == node2.data() && isMirror(node1.left(), node2.right()) && isMirror(node1.right(), node2.left());

  }

  public static void main(String[] args) {
//    BinarySearchTree tree = new BinarySearchTree();
//    tree.add(40);
//    tree.root.setLeft(new Node(30));
//    tree.root.setRight(new Node(80));
//    tree.root.left().setLeft(new Node(10));
//    tree.root.left().setRight(new Node(35));
//    tree.root.right().setLeft(new Node(70));
//    tree.root.right().setRight(new Node(90));
//    tree.root.right().left().setLeft(new Node(50));
//    tree.root.right().left().setRight(new Node(75));
//    tree.root.right().right().setLeft(new Node(85));
//    tree.root.right().right().setRight(new Node(1001));

        BinarySearchTree tree = new BinarySearchTree();
    tree.add(1);
    tree.root.setLeft(new Node(2,-1));
    tree.root.setRight(new Node(3,1));
    tree.root.left().setLeft(new Node(4, -2));
    tree.root.left().setRight(new Node(9,-1));
    tree.root.right().setLeft(new Node(6,0));
    tree.root.right().setRight(new Node(7, 2));
    tree.shadowOrder();
//    tree.root.right().left().setLeft(new Node(50));
//    tree.root.right().left().setRight(new Node(75));
//    tree.root.right().right().setLeft(new Node(85));
//    tree.root.right().right().setRight(new Node(1001));

//    int[] nums = {10, 15, 20, 25, 30, 35, 40, 45, 50};
//    int[] nums = {30, 80, 10, 35, 70, 90, 50, 75, 85, 100};
//    for (int num : nums) {
//      tree.add(num);
//    }
//    BinarySearchTree mirror = new BinarySearchTree();
//    mirror.add(40);
//    mirror.root.setRight(new Node(30));
//    mirror.root.setLeft(new Node(80));
//    mirror.root.right().setRight(new Node(10));
//    mirror.root.right().setLeft(new Node(35));
//    mirror.root.left().setRight(new Node(70));
//    mirror.root.left().setLeft(new Node(90));
//    mirror.root.left().right().setRight(new Node(50));
//    mirror.root.left().right().setLeft(new Node(75));
//    mirror.root.left().left().setRight(new Node(85));
//    mirror.root.left().left().setLeft(new Node(1001));
//    int[] nums2 = {80, 30, 90, 70, 35, 10, 100, 85, 75, 50};
//    for (int num : nums2) {
//      mirror.add(num);
//    }
//    for(int i=1; i <20 ; i++){
//      tree.add(i);
//    }
//    tree.preOrder();
//    System.out.println();
//    tree.inOrder();
//    System.out.println();
//    tree.postOrder();
//    Node node = tree.search(20);
//    System.out.println("node.data() = " + node.data());
//    System.out.println("node.left().data() = " + node.left().data());
//    System.out.println("node.right().data() = " + node.right().data());
//    System.out.println("tree.maxDepth() = " + tree.maxDepth());
//    tree.bfs();
//    System.out.println(tree.isMirror(mirror));
  }


}

class Node {
  private int data;
  private Node left;
  private Node right;
  private int relativity;


  public Node(int data, int relativity) {
    this.data = data;
    this.left = null;
    this.right = null;
    this.relativity = relativity;
  }

  public Node left() {
    return this.left;
  }

  public Node right() {
    return this.right;
  }

  public int data() {
    return this.data;
  }

  public void addNode(Node newNode) {
    if (newNode.data() < this.data()) {
      Node leftNode = this.left();
      if (leftNode == null) {
        this.left = newNode;
      } else {
        this.left().addNode(newNode);
      }
    } else {
      Node rightNode = this.right();
      if (rightNode == null) {
        this.right = newNode;
      } else {
        this.right().addNode(newNode);
      }
    }
  }


  public void inOrder() {
    if (this.left() != null) {
      this.left().inOrder();
    }
    System.out.print(this.data + ", ");
    if (this.right() != null) {
      this.right().inOrder();
    }
  }

  public void postOrder() {


    if (this.left() != null) {
      this.left().postOrder();
    }
    if (this.right() != null) {
      this.right().postOrder();
    }
    System.out.print(this.data + ", ");
  }

  public void preOrder() {

    System.out.print(this.data + ", ");
    if (this.left() != null) {
      this.left().preOrder();
    }

    if (this.right() != null) {
      this.right().preOrder();
    }
  }

  public void shadowOrder(Map<Integer, List<Node>> relativityMap){
    List<Node> showNodes = relativityMap.get(relativity);
    if(showNodes== null|| showNodes.isEmpty()){
      showNodes = new ArrayList<>();
      showNodes.add(this);
      relativityMap.put(relativity,showNodes);
    } else{
      showNodes.add(this);
    }
//    if(showNodes.get(showNodes.size()-1).data == this.data){
//      System.out.print(this.data);
//    }
    if (this.left() != null) {
      this.left().shadowOrder(relativityMap);
    }
    if (this.right() != null) {
      this.right().shadowOrder(relativityMap);
    }
  }



  public Set<Node> shadowNodes(){
    Set<Node> nodes = new HashSet<>();
    if(this.left()!=null){
      Node left = this.left();
      if(left.right()!=null){
        Node right = left.right();
        nodes.add(this);
        nodes.add(right);
      }
    }
    if(this.right()!=null){
      Node right = this.right();
      if(right.left()!=null){
        Node left = right();
        nodes.add(this);
        nodes.add(left);
      }
    }
    return nodes;
  }


  public Node search(int data) {
    if (data < this.data()) {
      if (this.left != null) {
        return this.left.search(data);
      }
    } else if (data > this.data) {
      if (this.right != null) {
        return this.right.search(data);
      }
    } else {
      return this;
    }
    return null;
  }

  private int leftDepth() {
    if (this.left != null) {
      return 1 + this.left().leftDepth();
    }
    return 1;
  }

  private int rightDepth() {
    if (this.right() != null) {
      return 1 + this.right().rightDepth();
    }
    return 1;
  }

  public int maxDepth() {
    return Math.max(leftDepth(), rightDepth());
  }

  public void bfs() {
    Queue<Node> nodes = new LinkedList<>();
    nodes.add(this);
    bfs(nodes);
  }

  private void bfs(Queue<Node> nodes) {
    if (!nodes.isEmpty()) {
      Node node = nodes.remove();
      System.out.print(node.data() + " ");
      if (node.left != null) {
        nodes.add(node.left);
      }
      if (node.right() != null) {
        nodes.add(node.right);
      }
      bfs(nodes);
    }
  }

  public boolean isMirror(Node node) {
    if (node == null) {
      return false;
    }
    if (this.left() != null) {
      return this.data == node.data() && this.left().isMirror(node.right);
    }
    if (this.right() != null) {
     return this.data == node.data() && this.right().isMirror(node.left());
    }
    return false;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public void setRight(Node right) {
    this.right = right;
  }
}
