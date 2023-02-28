package cache;

public interface LongRunningTask<T> {

    public T doTask();
}
