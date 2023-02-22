package cache;

import java.util.Map;
import java.util.concurrent.*;


// good example of concurrent cache... cache the future
public class ConcurrentCache<T, V> {

    Map<T, Future<V>> cache = new ConcurrentHashMap<>();

    public V get(T key) throws ExecutionException, InterruptedException {
        return cache.get(key).get();
    }


    // lock on entire block ???
    public V compute(T key, V value) {
        Future<V> val = cache.get(key);
        if (val == null) {
            Callable<V> eval = () -> {
                // just example ... obv bad coding
                // here is where we call the complex compute
                return (V) new Object();
            };
            FutureTask<V> ft = new FutureTask<>(eval);
            val = cache.putIfAbsent(key, ft);
            if (val == null) {
                val = ft;
                ft.run();
            }
        }

        try {
            return val.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
