package com.example.JavaCollection.maps;

import java.util.HashMap;

public class MapInterface {
    public static void main(String[] args) {
        HashMap<String,Integer> numbers = new HashMap<>();

        numbers.put("One" , 1);
        numbers.put("Two", 2);
        numbers.put("Three", 3);
        numbers.put("Four", 4);
        numbers.put(null, null);
        numbers.put(null, 11);
        System.out.println("Hash Map" + numbers);
    }
}
