package hash;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// leetcode , implement hashset
public class CustomHashSet {


    private static int BUCKET_SIZE = 100;
    private List<List<Integer>> masterList;

    public CustomHashSet() {
        masterList = new ArrayList<>(BUCKET_SIZE);
        // why to set the elements to null??
        // force init to NULL to help later
        for (int i = 0; i < BUCKET_SIZE; i++) {
            masterList.add(null);
        }
    }

    private int getHashcode(int key) {
        return key % BUCKET_SIZE;
    }


    public void add(int key) {
        int index = getHashcode(key);
        List<Integer> childList = masterList.get(index);
        if (childList == null) {
            // new element
            childList = new LinkedList<>();
            childList.add(key);
            masterList.add(index, childList);
        } else {
            if (!childList.contains(key)) {
                childList.add(key);
            }
        }
    }

    public void remove(int key) {
        int index = getHashcode(key);
        List<Integer> childList = masterList.get(index);
        if (childList != null) {
            // remove the actual value/object NOT the location or index.
            // hence counter box to object
            childList.remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        int index = getHashcode(key);
        List<Integer> childList = masterList.get(index);
        return childList != null && childList.contains(key);
    }

}
