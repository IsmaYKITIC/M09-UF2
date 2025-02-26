public class Taula {
    private Filosof[] comensals;
    private Forquilla[] forquilles;
    private static final String[] NOMS = { "Descartes", "Plató", "Socrates", "Hume" };

    public Taula(int numFilòsofs) {
        comensals = new Filosof[numFilòsofs];
        forquilles = new Forquilla[numFilòsofs];

        for (int i = 0; i < numFilòsofs; i++) {
            forquilles[i] = new Forquilla(i);
        }

        for (int i = 0; i < numFilòsofs; i++) {
            Forquilla esquerra = forquilles[i];
            Forquilla dreta = forquilles[(i + 1) % numFilòsofs];
            comensals[i] = new Filosof(NOMS[i], esquerra, dreta);
        }
    }

    public void showTaula() {
        for (Filosof filosof : comensals) {
            System.out.println("Comensal: " + filosof.getName() +
                    " esq: " + filosof.getEsquerra().getNum() +
                    " dret: " + filosof.getDreta().getNum());
        }
    }

    public void cridarATaula() {
        for (Filosof filosof : comensals) {
            filosof.start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        System.out.println("-----------------------------");
        taula.cridarATaula();
    }
}