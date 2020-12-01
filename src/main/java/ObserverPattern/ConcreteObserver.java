package test;

public class ConcreteObserver implements Obersver {

    @Override
    public void update() {
        System.out.println("i'm observer, received subject msg");
    }

    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.addObverver(new ConcreteObserver());
        concreteSubject.addObverver(new ConcreteObserver());
        concreteSubject.doSomething();
    }
}
