import java.util.Random;


public class RaceCondition {
    static public int counter;
    static public AtomicCounter acounter = new AtomicCounter();
    static public BasicCounter basicCount = new BasicCounter();
    static public BasicCounterNoSync noSyncCount = new BasicCounterNoSync();

    public RaceCondition(){

        Thread t = new Thread(() -> {
            Random rand = new Random();
            acounter.set(0);
            basicCount.set(0);
            noSyncCount.set(0);
            counter = 0;
            for (int i = 0; i < 1000; i++) {
                counter++;
                acounter.increment();
                basicCount.inc();
                noSyncCount.inc();
            }
            //System.out.println("**\nClassCounter: "+counter +"\nAtomicCounter: "+acounter.get() +"\nSynchronized Counter: "+ basicCount.get() + "\nNonSyncCounter: " + noSyncCount.get()+"\n**");
        });
        t.start();
    }
}
