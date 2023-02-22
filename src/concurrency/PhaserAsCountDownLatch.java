package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserAsCountDownLatch {

    private Phaser phaser;

    public class Task implements Runnable{

        private Phaser phaser;

        Task(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            phaser.arrive(); // similar to countdown
        }
    }

    public void runSimulation() throws InterruptedException {
        phaser = new Phaser(3);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new Task(phaser));
        executorService.submit(new Task(phaser));
        executorService.submit(new Task(phaser));
        // now wait for all 3 threads to start;
        phaser.awaitAdvance(3); // similar to await until countdown is 0
    }
}
