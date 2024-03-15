package Erasure;

import java.util.ArrayList;

public class equalization {
    public static void main(String[] args) {
        ArrayList<? extends String> l1 = new ArrayList<>();
        ArrayList<? extends Integer> l2 = new ArrayList<>();
        System.out.println(l1.getClass() == l2.getClass());
        System.out.println("l1 runtime class: " + l1.getClass());
        System.out.println("l2 runtime class: " + l2.getClass());

        // OUTPUT:
        //true
        //l1 runtime class: class java.util.ArrayList
        //l2 runtime class: class java.util.ArrayList
    }
}
