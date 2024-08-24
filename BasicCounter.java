public class BasicCounter {
    private int number;

    public BasicCounter() {
        number = 0;
    }

    public synchronized void inc(){
        this.number++;
    }

    public synchronized void set(int x){
        this.number = x;
    }

    public synchronized int get(){
        return number;
    }
}
