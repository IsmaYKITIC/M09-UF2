package src;

import java.util.Random;

public class Soci extends Thread {
    private Compte compte;
    private float aportacio;
    private int maxAnys;
    private Random random;
    private int esperaMax;

    public Soci() {
        compte = Compte.getInstancia();
        this.aportacio = 10f;
        this.maxAnys = maxAnys = 10;
        this.esperaMax = 100;
        random = new Random();
    }

    public Compte getCompte() {
        return compte;
    }

    @Override
    public void run() {
        for (int a = 0; a < maxAnys; a++) {
            for (int m = 0; m < 12; m++) {
                if (m % 2 == 0) {
                    float saldoActual = compte.getSaldo();
                    compte.setSaldo(saldoActual + aportacio);
                } else {
                    float saldoActual = compte.getSaldo();
                    compte.setSaldo(saldoActual - aportacio);
                }

                try {
                    Thread.sleep(random.nextInt(esperaMax));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
