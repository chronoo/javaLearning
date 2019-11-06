package basic;

import java.util.*;

/**
 * Collections
 */
public class Collections {
    public static void main(String[] args) {
        Set<Integer> collection = new HashSet<Integer>();
        for (int i = 100; i > 0; i--) {
            collection.add(i % 10);
        }
        System.out.println(collection);
    }    
}