package Hashmap;

import java.util.*;

public class Design_Hashset {

    // Bucket class – handles collision using LinkedList
    static class Bucket {

        private LinkedList<Integer> container;

        public Bucket() {
            this.container = new LinkedList<>();
        }

        public void insert(Integer val) {
            if (!container.contains(val)) {
                container.addFirst(val);
            }
        }

        public void remove(Integer val) {
            container.remove(val);
        }

        public boolean contains(Integer val) {
            return container.contains(val);
        }
    }

    // Custom HashSet implementation
    static class MyHashSet {

        private final int numBuckets = 769; // prime number of buckets
        private Bucket[] buckets;

        public MyHashSet() {
            this.buckets = new Bucket[numBuckets];
            for (int i = 0; i < numBuckets; i++) {
                this.buckets[i] = new Bucket();
            }
        }

        private int getIndex(int key) {
            return key % numBuckets;
        }

        public void add(int key) {
            int bucketIndex = getIndex(key);
            this.buckets[bucketIndex].insert(key);
        }

        public void remove(int key) {
            int bucketIndex = getIndex(key);
            this.buckets[bucketIndex].remove(key);
        }

        public boolean contains(int key) {
            int bucketIndex = getIndex(key);
            return this.buckets[bucketIndex].contains(key);
        }
    }

    // Main method to test MyHashSet
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();

        // Add elements
        set.add(10);
        set.add(20);
        set.add(769); // 769 % 769 = 0 → same index as 0

        // Check contains
        System.out.println("Contains 10? " + set.contains(10)); // true
        System.out.println("Contains 20? " + set.contains(20)); // true
        System.out.println("Contains 30? " + set.contains(30)); // false

        // Remove an element
        set.remove(10);
        System.out.println("Contains 10 after removal? " + set.contains(10)); // false

        // Add again
        set.add(10);
        System.out.println("Contains 10 after re-adding? " + set.contains(10)); // true
    }
}
