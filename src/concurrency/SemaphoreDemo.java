package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreDemo {

    private Semaphore semaphore;

    public class LongRunningTask implements Runnable {

        Semaphore semaphore;

        LongRunningTask(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                /// do some long activity
                semaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void runSimulation() throws InterruptedException {
        semaphore = new Semaphore(5);
        ExecutorService service = Executors.newFixedThreadPool(50);
        IntStream.of(1000).forEach(i -> service.submit(new LongRunningTask(semaphore)));
        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);
    }
}
