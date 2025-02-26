import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {
    private int num;
    private Lock bloqueig;

    public Forquilla(int num) {
        this.num = num;
        this.bloqueig = new ReentrantLock();
    }

    public boolean agafar(String filosof) {
        return bloqueig.tryLock();
    }

    public void deixar(String filosof) {
        bloqueig.unlock();
        System.out.println("Filòsof " + filosof + " deixa forquilla " + num);
    }

    public int getNum() {
        return num;
    }
}