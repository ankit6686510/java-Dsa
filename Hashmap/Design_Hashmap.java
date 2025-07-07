package Hashmap;

import java.util.*;

public class Design_Hashmap {

    class Pair<U, V> {

        U first;
        V second;

        public Pair(U f, V s) {
            first = f;
            second = s;
        }
    }

    class Bucket {

        private List<Pair<Integer, Integer>> list;

        public Bucket() {
            list = new LinkedList<Pair<Integer, Integer>>();
        }

        public void put(int key, int value) {
            for (Pair<Integer, Integer> p : list) {
                if (p.first == key) {
                    p.second = value;
                    return;
                }
            }
            list.add(0, new Pair<>(key, value)); // Insert at beginning
        }

        public int get(int key) {
            for (Pair<Integer, Integer> p : list) {
                if (p.first == key) {
                    return p.second;
                }
            }
            return -1;
        }

        public void remove(int key) {
            Iterator<Pair<Integer, Integer>> it = list.iterator();
            while (it.hasNext()) {
                Pair<Integer, Integer> p = it.next();
                if (p.first == key) {
                    it.remove(); // Safe removal
                    return;
                }
            }
        }
    }

    class MyHashMap {

        private final int keyRange = 769;
        private Bucket[] bucket;

        public MyHashMap() {
            bucket = new Bucket[keyRange];
            for (int i = 0; i < keyRange; i++) {
                bucket[i] = new Bucket();
            }
        }

        private int getBucketIndex(int key) {
            return key % keyRange;
        }

        public void put(int key, int value) {
            int bucketIdx = getBucketIndex(key);
            bucket[bucketIdx].put(key, value);
        }

        public int get(int key) {
            int bucketIdx = getBucketIndex(key);
            return bucket[bucketIdx].get(key);
        }

        public void remove(int key) {
            int bucketIdx = getBucketIndex(key);
            bucket[bucketIdx].remove(key);
        }
    }

}
