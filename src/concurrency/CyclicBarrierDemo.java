package concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    private CyclicBarrier cyclicBarrier;

    private final Random random = new Random();
    private int PARTIAL_RESULTS;
    private int WORKERS;


    CyclicBarrierDemo(int workers, int partialResults){
        PARTIAL_RESULTS = partialResults;
        WORKERS = workers;
        cyclicBarrier = new CyclicBarrier(workers,new Aggregator());
    }

    private final List<List<Integer>> partialResults =
            Collections.synchronizedList(new ArrayList<>());


    public class NumberCruncher implements Runnable {
        @Override
        public void run() {
            List<Integer> partialResult = new ArrayList<>();
            int i = 0;
            while (i < PARTIAL_RESULTS) {
                partialResult.add(random.nextInt());
                i++;
            }
            partialResults.add(partialResult);
            try {
                cyclicBarrier.await(); // will be wait for other threads
            } catch (BrokenBarrierException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public class Aggregator implements Runnable {
        @Override
        public void run() {
            System.out.println("sum = " +partialResults.stream()
                    .flatMap(List::stream)
                    .reduce(0, Integer::sum));
        }
    }

    public void runSimulation(){
        System.out.println("Spawning " + WORKERS
                + " worker threads to compute "
                +  PARTIAL_RESULTS + " partial results each");
        for (int i = 0; i < WORKERS; i++) {
            Thread worker = new Thread(new NumberCruncher());
            worker.setName("Thread " + i);
            worker.start(); /// this will start
        }
    }

    public static void main(String[] args) {
        CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo(4,3);
        cyclicBarrierDemo.runSimulation();
    }
}
