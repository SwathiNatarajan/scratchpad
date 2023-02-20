package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.util.concurrent.Executors.newFixedThreadPool;
import static java.util.concurrent.Executors.newSingleThreadExecutor;

public class ExecutorServiceDemo {

    private static final int UPPER_LIMIT = 10;
    private List<Integer> results = new ArrayList<>();

    private Random random;

    private ExecutorService executor;

    ExecutorServiceDemo(){
        random= new Random();
    }

    public class NumberCruncher implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < UPPER_LIMIT; i++) {
                   results.add(random.nextInt());
            }
        }
    }

    public class NumberCruncher2 implements Callable<List<Integer>>{

        @Override
        public List<Integer> call() throws Exception {
            for (int i = 0; i < UPPER_LIMIT; i++) {
                results.add(random.nextInt());
            }
            return results;
        }
    }

    public void runSimulation() throws ExecutionException, InterruptedException {
        //executor = newSingleThreadExecutor();
        executor = newFixedThreadPool(10);
        executor.execute(new NumberCruncher());
        Future<List<Integer>> res = executor.submit( new NumberCruncher2());
        List<Integer> listOfIn = res.get();
    }

    public void shutDown(){
        executor.shutdown();
    }
}
