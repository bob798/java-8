package ObserverPattern;

import java.util.Vector;

abstract class Subject {

    private Vector<Observer> obs = new Vector<>();

    public void addObserver(Observer observer) {
        obs.add(observer);
    }

    public void delObserver(Observer observer) {
        obs.remove(observer);
    }

    public void notifyObserver() {
        obs.forEach(Observer::update);
    }

    public abstract void doSomething();

}
