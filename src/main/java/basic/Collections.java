package basic;

import java.util.*;

/**
 * Collections
 */
public class Collections {
    public static void main(String[] args) {
        Random rand = new Random(42);

        List<Set<Integer>> collections = new ArrayList<Set<Integer>>();
        collections.add(new HashSet<Integer>());
        collections.add(new TreeSet<Integer>());
        collections.add(new LinkedHashSet<Integer>());

        for (int i = 100; i > 0; i--) {
            Integer newItem = rand.nextInt(10);
            for (Set<Integer> collection : collections) {
                collection.add(newItem);
            }
        }

        for (Collection<Integer> collection : collections) {
            System.out.println(collection.getClass().getSimpleName() + " : " + collection);
        }
    }    
}