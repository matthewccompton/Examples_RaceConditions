public class BasicCounterNoSync {
    private int number;

    public BasicCounterNoSync() {
        number = 0;
    }

    public void inc(){
        this.number++;
    }

    public void set(int x){
        this.number = x;
    }

    public int get(){
        return number;
    }
}
