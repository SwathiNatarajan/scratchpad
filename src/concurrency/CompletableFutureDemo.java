package concurrency;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    private String doTask(){
        return "some";
    }


    public void runSimulation(){
        CompletableFuture.supplyAsync(this::doTask);
    }
}
