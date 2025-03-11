import java.util.LinkedList;
import java.util.Queue;

public class Barberia {
    private Queue<Client> salaEspera;
    private int maxCadires;
    private Object condBarber;
    private static Barberia instance;

    private Barberia(int maxCadires) {
        this.salaEspera = new LinkedList<>();
        this.maxCadires = maxCadires;
        this.condBarber = new Object();
    }

    public static Barberia getInstance(int maxCadires) {
        if (instance == null) {
            instance = new Barberia(maxCadires);
        }
        return instance;
    }

    public synchronized void entrarClient(Client client) {
        if (salaEspera.size() < maxCadires) {
            salaEspera.add(client);
            System.out.println(client.getNom() + " en espera");
            synchronized (condBarber) {
                condBarber.notify();
            }
        } else {
            System.out.println("No queden cadires, client " + client.getNom() + " se'n va");
        }
    }

    public synchronized Client seguentClient() {
        return salaEspera.poll();
    }

    public Object getCondBarber() {
        return condBarber;
    }

    public void executa() {
        for (int i = 1; i <= 10; i++) {
            entrarClient(new Client(i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 11; i <= 20; i++) {
            entrarClient(new Client(i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Barberia barberia = Barberia.getInstance(3);
        Barber barber = new Barber("Pepe", barberia);
        barber.start();
        barberia.executa();
    }
}