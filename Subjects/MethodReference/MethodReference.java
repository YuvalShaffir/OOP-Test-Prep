package MethodReference;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MethodReference {
    private final String questionMark = " ?";

    public void printWithQuestionMark(String msg){
        System.out.println(msg + questionMark);
    }

    public static void main(String[] args) {
        MethodReference ref = new MethodReference();
        List<String> messages = List.of("OOP", "IS", "COOL");
        // for each item in the list we send it to the referenced method
        messages.forEach(ref::printWithQuestionMark);
    }
}
