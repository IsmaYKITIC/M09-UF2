public class Forquilla {
    int num;
    boolean enUs;
    public static final int LLIURE = -1;

    public Forquilla(int num) {
        this.num = num;
        this.enUs = false;
    }

    public synchronized boolean agafar(String filosof) throws InterruptedException {
        while (enUs) {
            wait();
            return false;
        }
        enUs = true;
        System.out.println("Filòsof " + filosof + " agafa forquilla " + num);
        return true;
    }

    public synchronized void deixar(String filosof) {
        enUs = false;
        System.out.println("Filòsof " + filosof + " deixa forquilla " + num);
        notifyAll();
    }
}