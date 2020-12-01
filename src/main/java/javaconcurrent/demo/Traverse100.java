package me.bob.javaconcurrent.demo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Traverse100 implements Runnable {

  public static Traverse100 traverse = new Traverse100();
  static volatile int i = 0;

  public static void increase() {
    i++;
    System.out.println(i+" thread="+Thread.currentThread());
  }

  @Override
  public void run() {
    for (int i = 1; i <= 100; i++) {
      increase();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Executor executor = Executors.newFixedThreadPool(2);
    executor.execute(traverse);
    // 没有停止
//    Thread t1 = new Thread(traverse);
//    Thread t2 = new Thread(traverse);
//
//    t1.start();
//    t2.start();
//
//    t1.join();
//    t2.join();
    System.out.println(i);
  }
}
