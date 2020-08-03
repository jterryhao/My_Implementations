import java.util.ArrayList;

public abstract class Subject {

    private ArrayList<Observer> observers = new ArrayList<>();

    void attach(Observer ob) {
        observers.add(ob);
    }

    void detach(Observer ob) {
        observers.remove(ob);
    }

    void notifyObservers() {
        for (Observer ob: observers) {
            ob.inform();
        }
    }
}
