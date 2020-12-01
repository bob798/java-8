package me.bob.javaconcurrent.unit_2;

/**
 * 初建线程
 */
public class CreateThread implements Runnable{

    public static void main(String[] args) {

        System.out.println("我是线程"+Thread.currentThread().getName());
        // create thread 1
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("我是线程 thread");
            }
        };
        thread.start();

        // create thread 2
        Thread thread1 = new Thread(new CreateThread());
        thread1.start();
    }

    @Override
    public void run() {
        System.out.println("我是线程 runnable");
    }
}
