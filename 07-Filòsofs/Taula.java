public class Taula {
    Filosof[] comensals;
    Forquilla[] forquilles;
    public static final String[] NOMS = { "Descartes", "Plató", "Socrates", "Hume" };

    public Taula() {
        comensals = new Filosof[4];
        forquilles = new Forquilla[4];

        for (int i = 0; i < forquilles.length; i++) {
            forquilles[i] = new Forquilla(i);
        }
        for (int i = 0; i < comensals.length; i++) {
            if (i != comensals.length - 1) {
                comensals[i] = new Filosof(NOMS[i], forquilles[i], forquilles[i + 1]);
            } else {
                comensals[i] = new Filosof(NOMS[i], forquilles[i], forquilles[0]);
            }

        }

    }

    public void showTaula() {

    }

    public void cridaTaula() {
        for (int i = 0; i < comensals.length; i++) {
            comensals[i].start();
        }
    }
}
