package cache;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LeastRecentlyUsedCache {

    Map<Integer, Integer> cache;
    // add head and also can remove tail.
    // used in fork and join
    Deque deque;
    ListNode head;
    ListNode tail;
    int capacity;

    class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int value) {
            val = value;
        }
    }

    public LeastRecentlyUsedCache(int capacity) {
        cache = new HashMap<Integer, Integer>(capacity);
        this.capacity = capacity;
    }

    void add(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
            head.prev = null;
        }
    }

    int removeLast() {
        int last = 0;
        if (tail != null) {
            last = tail.val;
            tail = tail.prev;
            tail.next = null;
        }
        return last;
    }

    void findAndMakeHead(int val) {
        if (head.val == val) {
            return;
        }

        if (tail.val == val) {
            tail.next = head;
            head.prev = tail;
            head = tail;
            tail = tail.prev;
            tail.next = null;
            return;
        }

        ListNode temp = head.next;
        while (temp != null) {
            if (temp.val == val) {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                temp.next = head;
                head.prev = temp;
                head = temp;
                head.prev = null;
                return;
            }
            temp = temp.next;
        }
    }

    public int get(int key) {
        Integer val = cache.get(key);
        // cache miss
        if (val == null) {
            return -1;
        }
        // find the key and move to head;
        findAndMakeHead(key);
        return val;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key,value);
            findAndMakeHead(key);
            return;
        }
        if (cache.size() >= capacity) {
            // evict
            int last = removeLast();
            cache.remove(last);
        }
        cache.put(key, value);
        add(key);
    }

}