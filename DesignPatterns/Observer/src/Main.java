public class Main {
    public static void main(String[] args) {
        Subject subj = new Subject(new Observer[]{new ConcreteObserver1(), new ConcreteObserver2()});
        subj.updateObservers();
    }
}