package me.bob.javaconcurrent.flowtest;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class FlowApiTest {


  public static void main(String[] args) throws InterruptedException {

    SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
//      subscrite
    Flow.Subscriber<String> subscriber = new Flow.Subscriber<String>() {
      private Flow.Subscription subscription;

      @Override
      public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
      }

      @Override
      public void onNext(String item) {
        System.out.println(" 【订阅者】接收消息 <-----" + item);
        this.subscription.request(1);
//        this.subscription.cancel();

      }

      @Override
      public void onError(Throwable throwable) {
        System.out.println("【订阅者】接收消息发生异常" + throwable);
        this.subscription.cancel();

      }

      @Override
      public void onComplete() {
        System.out.println("【订阅者】接收消息完成");

      }
    };

    publisher.subscribe(subscriber);
    for (int i = 0; i < 10; i++) {
      String message = "Hello Flow Api " + i;
      System.out.println("【发布者】发送消息--->" + message);
      publisher.submit(message);
    }
    publisher.close();

    Thread.currentThread().join(20000);
  }
}
