package cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCache {

    Map<String, String> cache = new ConcurrentHashMap<>();

    public String get(String key) {
        return cache.get(key);
    }


    public void put(String key, String value) {
        cache.putIfAbsent(key, value);
    }
}
