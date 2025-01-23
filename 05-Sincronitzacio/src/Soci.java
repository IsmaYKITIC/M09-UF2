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
    }

    public Compte getCompte() {
        return compte;
    }

}
