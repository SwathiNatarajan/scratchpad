package hash;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// https://leetcode.com/problems/design-hashmap/
public class MyHashMap {

    private List<List<Node>> lists;
    public static final int ARRAY_SIZE = 1000000;
    public static final int MAP_SIZE = 10000;

    public MyHashMap() {
        lists = new ArrayList<>(MAP_SIZE);
        IntStream.of(MAP_SIZE).forEach(i -> lists.add(null));
    }

    private int index(int key) {
        return key % MAP_SIZE;
    }

    public void put(int key, int value) {
        List<Node> list = lists.get(index(key));
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(new Node(key, value));
        lists.add(index(key), list);
    }

    public int get(int key) {
        List<Node> listInt = lists.get(index(key));
        if (listInt == null) {
            return -1;
        }
        for (Node n : listInt) {
            if (n.key == key) {
                return n.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        lists.remove(index(key));
    }

    public class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
