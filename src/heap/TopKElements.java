package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKElements {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // using the map, now heapify
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for(int n:map.keySet())
        {
            heap.add(n);
            if(heap.size()>k) heap.poll();
        }

        int[] top = new int[k];
        for (int i = k-1; i >=0; i--) {
            top[i] = heap.poll();
        }

        return top;
    }
}
