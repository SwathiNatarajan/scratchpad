package concurrency;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class ProducerConsumerUsingSemaphore<T> {

    private final Set<T> set;
    private final Semaphore semaphore;

    public ProducerConsumerUsingSemaphore(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        semaphore = new Semaphore(bound);
    }

    public boolean produce(T o) throws InterruptedException {
        semaphore.acquire();
        try {
            return set.add(o);
        } finally {
            semaphore.release();
        }
    }

    public boolean consumer(T o) throws InterruptedException {
        semaphore.acquire();
        try {
           return set.remove(0);
        }finally {
            semaphore.release();
        }
    }
}
