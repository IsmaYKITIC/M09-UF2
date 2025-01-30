package src;

import java.util.Random;

public class Assistent extends Thread {
    Esdeveniment esdeveniment;
    String nom;
    Random random = new Random();

    public Assistent(Esdeveniment esdeveniment, String nom) {
        this.esdeveniment = esdeveniment;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
