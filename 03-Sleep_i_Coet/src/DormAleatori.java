import java.util.Random;

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
        Random ran = new Random();

        for (int i = 0; i < 10; i++) {
            int tempsDormir = 100 + ran.nextInt(900);
            long temps = System.currentTimeMillis() - this.horaMs;
            System.out.printf("%s(%d) a dormir %dms total  %d %n", this.getName(), i, tempsDormir,
                    temps);
            try {
                Thread.sleep(tempsDormir);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}