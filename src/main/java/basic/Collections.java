package basic;

import java.util.*;

/**
 * Collections
 */
public class Collections {
    public static void main(String[] args) {
        testMapCollections();
    }

    private static void testMapCollections() {
        Random rand = new Random(42);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        IdentityHashMap<Integer, Integer> identityHashMap = new IdentityHashMap<>();
        for (int i = 0; i < 100; i++) {
            Integer newItem = rand.nextInt(10);
            hashMap.put(i, newItem);
            hashtable.put(i, newItem);
            linkedHashMap.put(i, newItem);
            identityHashMap.put(i, newItem);

        }

        System.out.println(hashMap);
        System.out.println(hashtable);
        System.out.println(linkedHashMap);
        System.out.println(identityHashMap);
    }

    private static void testArrayCollections() {
        Random rand = new Random(42);
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Vector<Integer> vector = new Vector<>();
        Stack<Integer> stack = new Stack<>();
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 100; i > 0; i--) {
            Integer newItem = rand.nextInt(10);
            arrayList.add(newItem);
            linkedList.add(newItem);
            vector.add(newItem);
            stack.push(newItem);
            arrayDeque.push(newItem);
            priorityQueue.add(newItem);
        }

        System.out.println(arrayList);
        System.out.println(linkedList);
        System.out.println(vector);
        System.out.println(stack);
        System.out.println(arrayDeque);
        System.out.println(priorityQueue);
    }

    private static void testSetCollections() {
        Random rand = new Random(42);

        List<Set<Integer>> collections = new ArrayList<>();
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