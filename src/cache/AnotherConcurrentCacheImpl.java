package cache;

import java.util.Map;
import java.util.concurrent.*;
import java.util.function.Function;

public class AnotherConcurrentCacheImpl implements AnotherConcurrentCache {
    private Map<Object, Future<Object>> cache = new ConcurrentHashMap<>();
    // like hashtable , no nulls allowed
    private LongRunningTask longRunningTask;
    @Override
    public Object get(Object key) {
        if (!cache.containsKey(key)) {
            //   cache.put(key,longRunningTask.doTask());
            // if value is null, it will not add it to the cache.
            Function<Object, Future<Object>> compute = k -> new FutureTask<>(() -> longRunningTask.doTask());
            cache.computeIfAbsent(key, compute);
        }
        try {
            return cache.get(key).get();// finally block as we need the value now!!!
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
