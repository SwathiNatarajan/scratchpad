package concurrency;

import java.util.concurrent.*;

public class Producer implements Runnable {
  private BlockingQueue<Integer> queue;

  public Producer(BlockingQueue<Integer> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    int num = Double.valueOf(Math.random() * 100).intValue();
    System.out.println("Producer " + num);
    try {
      queue.offer(num, 5 , TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    BlockingQueue<Integer> queue =  new LinkedBlockingQueue<>(2*5);
    ExecutorService executor =  Executors.newFixedThreadPool(2);
    while (true){
      Producer producer = new Producer(queue);
      Consumer consumer = new Consumer(queue);
      executor.execute(producer);
      executor.execute(consumer);
    }
  }
}