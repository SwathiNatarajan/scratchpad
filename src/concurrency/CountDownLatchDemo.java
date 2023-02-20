package concurrency;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public class Latch implements Runnable{

        private List<String> outputScraper;
        private CountDownLatch startLatch;
        private CountDownLatch progressLatch;
        private CountDownLatch doneLatch;

        Latch(){

        }

        @Override
        public void run() {

        }
    }
}
