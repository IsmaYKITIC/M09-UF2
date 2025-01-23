package src;

public class Associacio extends Thread {
    int nSocis;
    Soci[] socis;

    public Associacio() {
        nSocis = 1000;
        socis = socis;
    }

    public void iniciaCompteTempsSocis() {
        for (int i = 0; i < nSocis; i++) {
            Soci soci = new Soci();
            soci.start();
        }
    }

}
