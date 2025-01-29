package src;

public class Associacio extends Thread {
    private int nSocis;
    private Soci[] socis;

    public Soci[] getSocis() {
        return socis;
    }

    public Associacio(int nSocis) {
        this.nSocis = nSocis;
        socis = new Soci[nSocis];
        for (int i = 0; i < nSocis; i++) {
            socis[i] = new Soci();

        }
    }

    public void iniciaCompteTempsSocis(Soci[] socis) {
        for (int i = 0; i < socis.length; i++) {
            socis[i].start();
        }
    }

    public void esperaPeriodeSocis() {
        for (int i = 0; i < socis.length; i++) {
            try {
                socis[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void mostraBalancComptes() {
        System.out.println("Saldo: " + Compte.getInstancia().getSaldo());
    }

}
