public class Subject {
    private final Observer[] observers;

    public Subject(Observer[] observers) {
        this.observers = observers;
    }

    public void updateObservers(){
        for(var observer: observers){
            observer.update();
        }
    }
}
