package ObserverPattern;

public class ConcreteObserver implements Observer {

    @Override
    public void update() {
        System.out.println("i'm observer, received subject msg");
    }

    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.addObserver(new ConcreteObserver());
        concreteSubject.addObserver(new ConcreteObserver());
        concreteSubject.doSomething();
    }
}
