package src;

import java.util.Random;

public class Assistent extends Thread {
    private final Esdeveniment esdeveniment;
    private final String nom;
    private final Random random = new Random();
    private static final int MAX_ITERACIONS = 10; // Nombre màxim d'operacions per assistent

    public Assistent(Esdeveniment esdeveniment, String nom) {
        this.esdeveniment = esdeveniment;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void run() {
        for (int i = 0; i < MAX_ITERACIONS && !Thread.currentThread().isInterrupted(); i++) {
            try {
                Thread.sleep(random.nextInt(1000));
                if (random.nextBoolean()) {
                    esdeveniment.ferReserva(this);
                } else {
                    esdeveniment.cancelaReserva(this);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println(nom + " ha finalitzat la seva execució.");

    }
}