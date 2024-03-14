public class Originator {
    private String state;

    public void set(String state){
        this.state = state;
        System.out.println("Originator: Setting state to " + state);
    }

    public Memento saveToMemento() {
        System.out.println("Originator: Saving to Memento");
        return new Memento(this.state);
    }

    public void restoreFromMemento(Memento memento) {
        this.state = memento.state; // memento private members are accessible from the Originator
        System.out.println("Originator: State after restoring from Memento: " + state);
    }

    public String getState(){
        return state;
    }

    /** Nested static class */
    // Why static?
    // ANSWER: the Memento class is often made static because it
    // represents a snapshot of the state of another object (the originator) at a specific point in time.
    // By making it static, you can ensure that it is independent of any particular instance of the
    // originator class.
    public static class Memento{
        private final String state; // accessible from only the outer class 'Originator'

        private Memento(String stateToSave) {
            this.state = stateToSave;
        }
    }
}
