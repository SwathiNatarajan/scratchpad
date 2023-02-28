package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

public class Accumulator {

    public static void main(String[] args) throws InterruptedException {
        // AtomicLong counter = new AtomicLong(0);

        LongAccumulator accumulator = new LongAccumulator(Long::sum, 0);
        LongAccumulator accumulator1 = new LongAccumulator((x, y) -> x * y, 1);
        LongAccumulator accumulator2 = new LongAccumulator(Math::max, 0);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.of(1000).forEach(i -> executorService.submit(new Task(accumulator)));

        Thread.sleep(2000); // bad code
        System.out.printf("counter " + accumulator.get());
    }


    // Long Added will create a local copy of counter and update its own counter per thread.
    // no sync required while incrementing

    private record Task(LongAccumulator counter) implements Runnable {
        @Override
        public void run() {
            counter.accumulate(1);
        }
    }
}
