package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserAsCyclicBarrier {

    private Phaser phaser;

    public class Task implements Runnable{

        private Phaser phaser;

        Task(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            phaser.arriveAndAwaitAdvance();// similar to barrier await
        }
    }

    public void runSimulation() throws InterruptedException {
        phaser = new Phaser(3);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new Task(phaser));
        executorService.submit(new Task(phaser));
        executorService.submit(new Task(phaser));
    }
}
