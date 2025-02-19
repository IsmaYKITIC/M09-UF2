public class Filosof extends Thread {
    int compGana;
    Forquilla esquerra;
    Forquilla dreta;

    public Filosof(String nom, Forquilla esquerra, Forquilla dreta) {
        super(nom); // Passem el nom al constructor de la classe Thread
        this.compGana = 0;
        this.esquerra = esquerra;
        this.dreta = dreta;
    }

    @Override
    public void run() {
        while (true) {
            try {
                pensar();
                menjar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void menjar() throws InterruptedException {
        boolean menjat = false;
        while (!menjat) {
            if (esquerra.agafar(this.getName())) {
                if (dreta.agafar(this.getName())) {
                    System.out.println("Filòsof " + this.getName() + " està menjant.");
                    Thread.sleep((long) (Math.random() * 1000 + 1000));
                    compGana = 0;
                    esquerra.deixar(this.getName());
                    dreta.deixar(this.getName());
                    menjat = true;
                } else {
                    esquerra.deixar(this.getName());
                }
            }
            if (!menjat) {
                compGana++;
                System.out.println("Filòsof " + this.getName() + " té gana: " + compGana);
                Thread.sleep((long) (Math.random() * 1000 + 1000));
            }
        }
    }

    public void pensar() throws InterruptedException {
        System.out.println("Filòsof " + this.getName() + " està pensant.");
        Thread.sleep((long) (Math.random() * 1000 + 1000));
    }
}