package cache;

public interface AnotherConcurrentCache<K,V> {
    public V get(K key);
}
