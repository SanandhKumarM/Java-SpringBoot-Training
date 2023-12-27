package com.example.JavaCollection.collections;

import java.util.Iterator;
import java.util.LinkedList;

public class CollectionLinkedList {
    LinkedList<String> li = new LinkedList<>();

    li.add("Sanandh");
    li.add("Ayush");
    li.add("Adarsh");
    li.add("Parth");

    Iterator<String> itr = li.iterator();
    while(itr.hasNext()){
        System.out.println(itr.next());
    }
}
