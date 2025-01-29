package src;

public class Compte {
    private float saldo;
    private static Compte instancia;

    private Compte() {
        this.saldo = 0;
    }

    public static synchronized Compte getInstancia() {
        if (instancia == null) {
            instancia = new Compte();
        }
        return instancia;
    }

    public synchronized void ingresar(float cantidad) {
        saldo += cantidad;
    }

    public synchronized void retirar(float cantidad) {
        saldo -= cantidad;
    }

    public synchronized float getSaldo() {
        return saldo;
    }
}