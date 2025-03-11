public class Barber extends Thread {
    private String name;
    private Barberia barberia;

    public Barber(String name, Barberia barberia) {
        this.name = name;
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while (true) {
            Client client = barberia.seguentClient();
            if (client != null) {
                System.out.println("Li toca al client " + client.getNom());
                tallarCabell(client);
            } else {
                System.out.println("Ningú en espera");
                System.out.println("Barber " + name + " dormint");
                synchronized (barberia.getCondBarber()) {
                    try {
                        barberia.getCondBarber().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void tallarCabell(Client client) {
        System.out.println("Tallant cabell a " + client.getNom());
        try {
            Thread.sleep(900 + (int) (Math.random() * 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}