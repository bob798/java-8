package test;

import java.util.Vector;

abstract class Subject {

    private Vector<Obersver> obs = new Vector<>();

    public void addObverver(Obersver obersver) {
        obs.add(obersver);
    }

    public void delObserver(Obersver obersver) {
        obs.remove(obersver);
    }

    public void notifyObserver() {
        obs.forEach(Obersver::update);
    }

    public abstract void doSomething();

}
