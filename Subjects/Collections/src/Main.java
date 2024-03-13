import com.sun.source.tree.Tree;

import java.util.*;
import java.util.function.BiFunction;

public class Main {


    public static final int INITIAL_CAPACITY = 4;

    private static void createArrayList(){
        System.out.println("Creating ArrayList");
        ArrayList<Integer> list = new ArrayList<>();
        // add numbers to the list
        list.add(1);
        list.add(2);

        // Another way of initializing a list
        ArrayList<Integer> list2 = new ArrayList<>() {
            // this is an anonymous inner class that inherit from ArrayList
            {
                // this is the instance initialization block
                add(1);
                add(2);
                add(2);
            }
        };
        for(var i: list2) System.out.println(i);
        //remove index
        list2.remove(1);

        //contains
        System.out.println(list2.contains(2));

        //size
        System.out.println(list2.size());

        //get
        System.out.println(list2.get(1));

        //set
        System.out.println(list2.set(1, 5));

        //get the element in the index 1
        System.out.println(list2.get(1));

        // we can create an Arraylist with an initial capacity
        int capacity = 4;
        ArrayList<Integer> list3 = new ArrayList<>(capacity);

    }

    private static void createLinkedList() {
        System.out.println("Creating linked list");
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(4);

        Collection<Integer> collection = new ArrayList<>(4){
            {
                add(1);
                add(2);
                add(3);
                add(4);
            }
        };
        linkedList.addAll(collection);

        System.out.println("first element: "+linkedList.getFirst());
        System.out.println("last element: "+linkedList.getLast());
        System.out.println("All elements");
        for(var i: linkedList) System.out.println(i);
    }

    private static void createHashSet() {
        System.out.println("Creating HashSet");
        HashSet<Integer> set = new HashSet<>(INITIAL_CAPACITY){
            {
                add(10);
                add(20);
                add(30);
            }
        };
        set.size();
        // clone a set
        HashSet<Integer> clonedset = (HashSet<Integer>) set.clone();
        // copy a set
        HashSet<Integer> copiedSet = new HashSet<>(set);

        //add all the original objects to a new set
        HashSet<Integer> newSet = new HashSet<>();
        newSet.addAll(set);

        //clears all the set
        newSet.clear();

        //check if it contains all of the object in the list
        Collection<Integer> collection = new ArrayList<>(){{ add(1); add(2) ; add(3);}};
        System.out.println(newSet.containsAll(collection));


    }

    private static void createTreeSet() {
        System.out.println("Creating TreeSet");
        // Requires less memory than hashset, has predictable runtime, has more functionality
        TreeSet<Integer> tree = new TreeSet<>(){{
            add(1); add(2); add(-1); add(-5); add(10); add(2);
        }};

        // the least element in the set greater or equal to the value
        System.out.println(tree.ceiling(0) == 1); // should return true

        // the greatest element in the set smaller or equal to the value
        System.out.println(tree.floor(0) == -1); // should return true


        System.out.println("ascending order");
        for (var i: tree) System.out.println(i);

        System.out.println("descending order");
        for (var i: tree.descendingSet()) System.out.println(i);

        System.out.println("working with iterator");
        Iterator<Integer> iter = tree.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

    }

    private static void createVector() {
        System.out.println("Create vector");
        // Vector doubles its capacity when it needs to grow beyond its current capacity.
        // ArrayList increases its capacity by 50% when it needs to grow beyond its current capacity.
        // This typically results in less memory wastage than Vector, especially for large collections.
        Vector<Integer> vec = new Vector<>();
        System.out.println("Initial capacity of the vector: "+vec.capacity());
        vec.add(1);
        vec.add(2);
        vec.add(2);
        vec.add(2);
        vec.add(2);
        vec.add(2);
        vec.add(2);
        vec.add(2);
        vec.add(2);
        vec.add(2);
        vec.add(2);
        System.out.println("new vector capacity is 2 times the size of the previous one: "+ vec.capacity());
    }

    public static void main(String[] args) {
        createArrayList();
        createLinkedList();
        createVector();
        createHashSet();
        createTreeSet();
        createHashMap();
        createTreeMap();
    }

    static class Student {
        String name;
        int grade;

        public Student(String name, int grade){
            this.name = name;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public Integer getGrade() {
            return grade;
        }
    }

    // the comparator compares only the keys of the map
    static class AccordingToGrade implements Comparator<Student>{

        @Override
        public int compare(Student s1, Student s2) {
            return s1.getGrade().compareTo(s2.getGrade());
        }
    }
    private static void createTreeMap() {
        System.out.println("Create TreeMap");
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("A", 1);
        map.put("B", 10);

        TreeMap<Student, Integer> studentMap = new TreeMap<>(new AccordingToGrade());
        studentMap.put(new Student("Akshay", 400), 1);
        studentMap.put(new Student("Bina", 500), 2);
        studentMap.put(new Student("Chintu", 300), 3);
        System.out.println(
                "TreeMap keys sorting in ascending order of the marks:");

        // Print map using Entry
        for (var entry : studentMap.entrySet()) {
            System.out.println("Name : (" + entry.getKey().getName()
                    + "), Grade : "
                    + entry.getKey().getGrade());
        }


    }


    private static void createHashMap() {
        System.out.println("Create Hashmap");
        HashMap<String, String> map = new HashMap<>(){{
            put("john", "software dev");
            put("sarah", "pizza delivery");
        }};

        System.out.println(map.get("john"));
        map.compute("john", new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return "Not a " + s2;
            }
        });
        System.out.println(map.get("john"));

        // if the key exists! computer a new value using a mapping BiFunction
//        map.computeIfPresent()

        for(var i: map.values()) System.out.println("value = " + i);

        for(var i: map.keySet()) System.out.println("key = " + i);
    }


}