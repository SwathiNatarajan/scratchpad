package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RandomRobinRing {


    public class ColorPrinter implements Runnable{
        private String color;

        ColorPrinter(String color){
            this.color = color;
        }

        @Override
        public void run() {
            System.out.println(this.color);
        }
    }

    public void runSimulation(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new ColorPrinter("blue"));
        executorService.submit(new ColorPrinter("red"));
        executorService.submit(new ColorPrinter("yellow"));
        executorService.shutdown();
    }


    public static void main(String[] args) {
        new RandomRobinRing().runSimulation();
    }
}
