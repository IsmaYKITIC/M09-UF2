public class Filosof extends Thread {
    int compGana;
    Forquilla esquerra;
    Forquilla dreta;

    public Filosof(String nom, Forquilla esquerra, Forquilla dreta) {
        super(nom);
        this.compGana = 0;
        this.esquerra = esquerra;
        this.dreta = dreta;
    }

    public void menjar() {

    }

    public void pensar() {

    }

}