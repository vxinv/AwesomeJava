package org.vxinv.algorithm.哈希相关;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class q146LRU缓存 {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }

    static class LRUCache {

        LinkedHashMap<Integer, Integer> map = null;
        int capa;

        public LRUCache(int capacity) {
            capa = capacity;
            map = new LinkedHashMap<>(capacity);
        }

        public int get(int key) {
            Integer integer = map.get(key);
            if (integer == null) {
                System.out.println(-1);
                return -1;
            }
            map.remove(key);
            map.put(key, integer);
            System.out.println(integer);
            return integer;
        }

        public void put(int key,int value){
            if (map.containsKey(key)){
                map.remove(key);
            }else if (map.size() == capa){
                Iterator iterator = map.entrySet().iterator();
                iterator.hasNext();
                iterator.next();
                iterator.remove();
            }
            map.put(key,value);
        }

        /*public void put1(int key, int value) {
            if (map.size() < capa) {
                if (map.containsKey(key)) {
                    map.remove(key);
                    map.put(key, value);
                }else {
                    map.put(key, value);
                }
                return;
            }
            if (map.containsKey(key)) {
                map.remove(key);
                map.put(key, value);
            }
            Iterator iterator = map.entrySet().iterator();
            iterator.hasNext();
            iterator.next();
            iterator.remove();
            map.put(key, value);
        }*/
    }
}

