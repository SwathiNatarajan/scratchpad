package hash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomHashmap {

    private static int BUCKET_SIZE = 100;
    private List<List<MyKeyValueEntry>> masterList;

    public CustomHashmap() {
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


    public void put(int key, int value) {
        int index = getHashcode(key);
        List<MyKeyValueEntry> childList = masterList.get(index);
        if (childList == null) {
            // new element
            childList = new LinkedList<>();
            childList.add(new MyKeyValueEntry(key, value));
            masterList.add(index, childList);
        } else {
            childList.add(new MyKeyValueEntry(key, value));
        }
    }

    public int get(int key) {
        int index = getHashcode(key);
        List<MyKeyValueEntry> childList = masterList.get(index);
        if (childList != null) {
            // get the first index
            if(childList.contains(key)) {
                return childList.get(key).value;
            }
        }
        return 0;
    }

    public void remove(int key) {
        int index = getHashcode(key);
        List<MyKeyValueEntry> childList = masterList.get(index);
        if (childList != null) {
            // remove the actual value/object NOT the location or index.
            // hence counter box to object
            childList.remove(key);
        }
    }

    public boolean contains(int key) {
        int index = getHashcode(key);
        List<MyKeyValueEntry> childList = masterList.get(index);
         return childList != null && childList.contains(key);
    }

    public static class MyKeyValueEntry {
        int key;
        int value;

        public MyKeyValueEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public boolean equals(Object o){
             if(o instanceof MyKeyValueEntry){
                 return this.key == ((MyKeyValueEntry) o).key;
             }
             return false;
        }
    }

}
