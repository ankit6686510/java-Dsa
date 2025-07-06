package Hashmap;

import java.util.*;

public class Design_Hashset {

    class Bucket {

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

    class MyHashSet {

        private final int numBuckets = 769;
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
}
