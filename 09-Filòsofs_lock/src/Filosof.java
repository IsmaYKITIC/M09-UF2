public class Filosof extends Thread {
    private int iniciGana;
    private int fiGana;
    private int gana;
    private Forquilla esquerra;
    private Forquilla dreta;

    public Filosof(String nom, Forquilla esquerra, Forquilla dreta) {
        super(nom);
        this.esquerra = esquerra;
        this.dreta = dreta;
        this.gana = 0;
    }

    @Override
    public void run() {
        while (true) {
            try {
                pensar();
                agafarForquilles();
                menjar();
                deixarForquilles();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void pensar() throws InterruptedException {
        iniciGana = (int) System.currentTimeMillis();
        System.out.println(getName() + " pensant.");
        Thread.sleep((long) (Math.random() * 1000 + 1000));
    }

    private void agafarForquilles() throws InterruptedException {
        while (true) {
            if (esquerra.agafar(getName())) {
                if (dreta.agafar(getName())) {
                    System.out.println(
                            getName() + " té forquilles esq(" + esquerra.getNum() + ") dreta(" + dreta.getNum() + ")");
                    break;
                } else {
                    esquerra.deixar(getName());
                }
            }
            Thread.sleep((long) (Math.random() * 500 + 500));
        }
    }

    private void menjar() throws InterruptedException {
        fiGana = (int) System.currentTimeMillis();
        gana = (fiGana - iniciGana) / 1000; // Convertir a segons
        System.out.println(getName() + " menja amb gana " + gana);
        Thread.sleep((long) (Math.random() * 1000 + 1000));
        System.out.println(getName() + " ha acabat de menjar");
    }

    private void deixarForquilles() {
        dreta.deixar(getName());
        esquerra.deixar(getName());
        System.out.println(getName() + " deixa les forquilles");
    }

    public int calcularGana() {
        return gana;
    }

    public void resetGana() {
        iniciGana = 0;
        fiGana = 0;
        gana = 0;
    }

    public Forquilla getEsquerra() {
        return esquerra;
    }

    public Forquilla getDreta() {
        return dreta;
    }
}