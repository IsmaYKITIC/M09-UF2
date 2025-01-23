import java.util.Random;

class Treballador extends Thread {
    private final float nouAnualBrut;
    private final int edatIniciTreball;
    private final int edatFiTreball;
    private int edatActual;
    private float cobrat;
    private final Random rnd;

    public Treballador(String nom, float nouAnualBrut, int edatIniciTreball, int edatFiTreball) {
        super(nom);
        this.nouAnualBrut = nouAnualBrut;
        this.edatIniciTreball = edatIniciTreball;
        this.edatFiTreball = edatFiTreball;
        this.edatActual = 0;
        this.cobrat = 0.0f;
        this.rnd = new Random();
    }

    private void cobra() {
        cobrat += nouAnualBrut / 12; // Incrementa una dotzena part del sou brut
    }

    private void pagaImpostos() {
        cobrat -= cobrat * 0.24; // Reté el 24% del cobrat
    }

    @Override
    public void run() {
        for (edatActual = edatIniciTreball; edatActual <= edatFiTreball; edatActual++) {
            cobra();
            pagaImpostos();
            try {
                Thread.sleep(rnd.nextInt(100)); // Simula el pas del temps
            } catch (InterruptedException e) {
                System.err.println(getName() + " ha estat interromput.");
            }
        }
    }

    public float getCobrat() {
        return cobrat;
    }

    public int getEdat() {
        return edatActual;
    }
}

class Administracio {
    private static final int NUM_POBLACIO_ACTIVA = 50;
    private final Treballador[] poblacioActiva;

    public Administracio() {
        poblacioActiva = new Treballador[NUM_POBLACIO_ACTIVA];
        for (int i = 0; i < NUM_POBLACIO_ACTIVA; i++) {
            poblacioActiva[i] = new Treballador("Ciutada-" + i, 25000, 20, 65);
        }
    }

    public void iniciarTreballadors() {
        for (Treballador treballador : poblacioActiva) {
            treballador.start();
        }

        for (Treballador treballador : poblacioActiva) {
            try {
                treballador.join(); // Espera que cada fil acabi
            } catch (InterruptedException e) {
                System.err.println("Error esperant el treballador: " + treballador.getName());
            }
        }

        mostrarEstadistiques();
    }

    private void mostrarEstadistiques() {
        for (Treballador treballador : poblacioActiva) {
            System.out.printf("%s -> edat: %d / total: %.2f\n",
                    treballador.getName(), treballador.getEdat(), treballador.getCobrat());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Administracio administracio = new Administracio();
        administracio.iniciarTreballadors();
    }
}
