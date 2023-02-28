package hash;

import java.util.HashSet;
import java.util.Random;


//Medium-- https://leetcode.com/problems/insert-delete-getrandom-o1/
public class RandomizedSet {
    private HashSet<Integer> set;

    private Random random;

    public RandomizedSet() {
        set = new HashSet<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }
        set.add(val);
        return true;
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        // convert set to array
        Integer[] arr = set.toArray(size -> new Integer[set.size()]);
        return arr[random.nextInt(arr.length)];
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }

}
