package cache;

import org.junit.jupiter.api.Test;

public class LeastRecentlyUsedCacheTest {

    @Test
    public void test() {
        LeastRecentlyUsedCache lRUCache = new LeastRecentlyUsedCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }

    // [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]

    @Test
    public void test2() {
        LeastRecentlyUsedCache lRUCache = new LeastRecentlyUsedCache(2);
        lRUCache.put(2, 1); // cache is {2=1}
        lRUCache.put(1, 1); // cache is {1=1, 2=1}
        lRUCache.put(2, 3); // cache is {2=3, 1=1}
        lRUCache.put(4, 1); // cache is {4=1,2=3}
        System.out.println(lRUCache.get(1));    // returns -1 (not found)
        System.out.println(lRUCache.get(2));    // return 3
    }

    // [[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
    @Test
    public void test3() {
        LeastRecentlyUsedCache lRUCache = new LeastRecentlyUsedCache(3);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {2=2, 1=1}
        lRUCache.put(3, 3); // cache is {3=3, 2=2, 1=1}
        lRUCache.put(4, 4); // cache is {4=4, 3=3, 2=2}
        System.out.println(lRUCache.get(4));    // returns 4
        System.out.println(lRUCache.get(3));    // returns 4  cache is {3=3, 4=4, 2=2}
        System.out.println(lRUCache.get(2));    // returns 4  cache is {2=2, 3=3, 4=4}
        System.out.println(lRUCache.get(1));    //-1
        lRUCache.put(5, 5); // cache is {5=5, 2=2, 3=3}
        System.out.println(lRUCache.get(1));  // -1
        System.out.println(lRUCache.get(2));  // 2 // cache is { 2=2,5=5, 3=3}
        System.out.println(lRUCache.get(3));  // 3 // cache is { 3=3, 2=2,5=5}
        System.out.println(lRUCache.get(4));  // -1
        System.out.println(lRUCache.get(5));  // 5 // cache is {5=5, 3=3, 2=2}
    }
}
