package ObserverPattern;

public class ConcreteSubject extends Subject {
    @Override
    public void doSomething() {
        System.out.println("I'm suject, send msg to subject");
        this.notifyObserver();
    }
}
