
public class Main {

    static int counter = 0;
    static AtomicCounter acounter = new AtomicCounter();
    static BasicCounter basicCount = new BasicCounter();
    static BasicCounterNoSync noSyncCount = new BasicCounterNoSync();

    public static void main(String[] args) {
        //Part A
        // Create new threads in a forloop, observe behavior.
        boolean partA = true;
        if (partA == true) {
            // Each new instance is at a new memory location, is it thread safe???
            for (int i = 0; i < 3; i++) {
                RaceCondition rc = new RaceCondition();
                // Without this sleep, the first instance 
                // is asigning all the variables 
                // to the same memory location...
                if (i == 0) {
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        System.out.println("Timer was interrupted.");
                    }
                }
                int inClassCounter = rc.counter;
                int atomicCounter = rc.acounter.get();
                int synchronizedCount = rc.basicCount.get();
                int noSyncCounter = rc.noSyncCount.get();
                System.out.println("\n(" + i + "|" + System.identityHashCode(rc) + ")\nClassCounter: " + inClassCounter + "(" + System.identityHashCode(inClassCounter) + ")" + "\nAtomicCounter: " + atomicCounter + "(" + System.identityHashCode(atomicCounter) + ")" + "\nSynchronized Counter: " + synchronizedCount + "(" + System.identityHashCode(synchronizedCount) + ")" + "\nNonSyncCounter: " + noSyncCounter + "(" + System.identityHashCode(noSyncCounter) + ")" + "\n!!");
            }
        }

        // Part B
        // Create 10 threads one at a time then call them in succession.
        Boolean partB = false;
        if (partB == true) {
            int inc = 2500;
            Thread t1 = new Thread(() -> {
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
            });

            Thread t2 = new Thread(() -> {
                try {
                    Thread.sleep(50 + inc);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
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
            });

            Thread t3 = new Thread(() -> {
                try {
                    Thread.sleep(100 + inc);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
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
            });

            Thread t4 = new Thread(() -> {
                try {
                    Thread.sleep(150 + inc);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
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
            });

            Thread t5 = new Thread(() -> {
                try {
                    Thread.sleep(200 + inc);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
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
            });

            Thread t6 = new Thread(() -> {
                try {
                    Thread.sleep(250 + inc);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
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
            });

            Thread t7 = new Thread(() -> {
                try {
                    Thread.sleep(300 + inc);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
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
            });
            Thread t8 = new Thread(() -> {
                try {
                    Thread.sleep(350 + inc);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
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
            });
            Thread t9 = new Thread(() -> {
                try {
                    Thread.sleep(400 + inc);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
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
            });
            Thread t0 = new Thread(() -> {
                try {
                    Thread.sleep(450 + inc);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
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
            });

            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
            t6.start();
            t7.start();
            t8.start();
            t9.start();
            t0.start();

            try {
                t1.join();
                t2.join();
                t3.join();
                t4.join();
                t5.join();
                t6.join();
                t7.join();
                t8.join();
                t9.join();
                t0.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Final Counter Value: " + counter);
            System.out.println("Final basic counter: " + basicCount.get());
            System.out.println("Final Atomic counter: " + acounter.get());
            System.out.println("Final non-sync counter class:" + noSyncCount.get());
        }
    }
//End Part B
}
//End Main