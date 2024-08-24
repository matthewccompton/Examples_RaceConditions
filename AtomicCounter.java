import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private AtomicInteger acounter = new AtomicInteger();

    public void increment() {
        acounter.incrementAndGet();
    }

    public synchronized void set(int x){
        acounter.set(x);
    }

    public synchronized int get() {
        return acounter.get();
    }
}