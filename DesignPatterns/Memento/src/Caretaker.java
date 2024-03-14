import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    public static void main(String[] args) {
        //list of saved states
        List<Originator.Memento> savedStates = new ArrayList<>();

        Originator originator = new Originator();

        originator.set("State 1");
        savedStates.add(originator.saveToMemento());
        originator.set("State 2");
        savedStates.add(originator.saveToMemento());
        originator.set("State 2");
        savedStates.add(originator.saveToMemento());

        originator.restoreFromMemento(savedStates.get(1));
        System.out.println("Current state: " + originator.getState());
    }
}
