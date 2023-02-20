package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

  BlockingQueue<Integer> queue;

  public Consumer(BlockingQueue<Integer> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {

    try {
      Integer num = queue.poll(5, TimeUnit.SECONDS);
      if (num != null) {
        System.out.println("Consumer " + num);
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
