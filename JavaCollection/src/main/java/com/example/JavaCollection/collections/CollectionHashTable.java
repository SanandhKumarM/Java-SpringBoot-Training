package com.example.JavaCollection.collections;

import java.util.Hashtable;

public class CollectionHashTable {
    public static void main(String[] args) {
        Hashtable<Integer, String> hashT = new Hashtable<>();
        hashT.put(1,"S");
        hashT.put(2,"A");
        hashT.put(3,"N");
        hashT.put(4,"A");
        hashT.put(5,"N");
        hashT.put(7,"D");
        hashT.put(8,"H");
        System.out.println(hashT);
    }
}
