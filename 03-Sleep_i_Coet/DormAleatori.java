
public class DormAleatori extends Thread {
    private Long horaMs;

    public static void main(String[] args) {

        DormAleatori usuari = new DormAleatori("Joan");
        DormAleatori usuari2 = new DormAleatori("Pep");

        usuari.start();
        usuari2.start();

        System.out.println("-- Fi de main -----------");

    }

    public DormAleatori(String name) {
        super(name);
        this.horaMs = System.currentTimeMillis();

    }

    @Override
    public void run() {
        Random ran
        System.out.printf("%s(%d) a dormir %dms total  %d ", this.getName(), this.getPriority(),/*Math.random()*/,this.horaMs);

        super.run();
    }
}