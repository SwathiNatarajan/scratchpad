package concurrency;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

    private CountDownLatch countDownLatch;

    public class Latch implements Runnable{
        private List<String> outputScraper;
        private CountDownLatch countDownLatch;
        Latch(CountDownLatch countDownLatch){
           this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
             countDownLatch.countDown();
             // do something

        }
    }

    public void runSimulation() throws InterruptedException {
        countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new Latch(countDownLatch));
        executorService.submit(new Latch(countDownLatch));
        executorService.submit(new Latch(countDownLatch));
        // now wait for all 3 threads to start;
        countDownLatch.await();
    }
}
