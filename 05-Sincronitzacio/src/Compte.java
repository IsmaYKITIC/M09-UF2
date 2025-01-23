package src;

public class Compte {
    private float saldo;
    private static Compte instancia;

    private Compte() {
        this.saldo = 0;
    }

    public static Compte getInstancia() {
        if (instancia == null) {
            instancia = new Compte();
        }
        return instancia;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

}