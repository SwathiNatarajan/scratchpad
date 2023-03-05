package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class DiningPhilosopherProblem {

    public class Fork {

        private Semaphore semaphore = new Semaphore(1);

        public boolean getFork() {
            try {
                semaphore.acquire();
                return true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void releaseFork() {
            semaphore.release();
        }

    }

    public class Philosopher implements Runnable {

        private Fork leftFork;
        private Fork rightFork;
        private int number;

        Philosopher(int number, Fork leftFork, Fork rightFork) {
            this.number = number;
            this.leftFork = leftFork;
            this.rightFork = rightFork;
        }

        public void eat() {
            try {
                int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
                System.out.println("philosopher " + (number) + " eats for " + sleepTime);
                Thread.sleep(sleepTime);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }

        @Override
        public void run() {
            while (true) {
                if (leftFork.getFork()) {
                    if (rightFork.getFork()) {
                        eat();
                        leftFork.releaseFork();
                        rightFork.releaseFork();
                    }
                }
            }
        }
    }

        public void runSimulation() {
            int numOfPhils = 5;
            Fork[] forks = new Fork[numOfPhils];
            for (int i = 0; i < forks.length; i++) {
                forks[i] = new Fork();
            }

            ExecutorService executorService = Executors.newFixedThreadPool(10);
            // incomplete!!
            for (int i = 0; i < numOfPhils ; i++) {
                executorService
                        .execute(new Philosopher
                                (i, forks[i], forks[(i + 1) % numOfPhils]));
            }
        }

        public static void main(String[] args) {
            DiningPhilosopherProblem problem = new DiningPhilosopherProblem();
            problem.runSimulation();
        }
}