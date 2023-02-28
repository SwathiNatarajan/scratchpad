package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class Adder {

    public static void main(String[] args) throws InterruptedException {
       // AtomicLong counter = new AtomicLong(0);

        LongAdder adder = new LongAdder();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.of(1000).forEach(i -> executorService.submit(new Task(adder)));

        Thread.sleep(2000); // bad code
        System.out.printf("counter "+ adder.sum());
    }


    // Long Added will create a local copy of counter and update its own counter per thread.
    // no sync required while incrementing

    private record Task(LongAdder counter) implements Runnable {
        @Override
        public void run() {
            counter.add(1);
        }
    }
}
