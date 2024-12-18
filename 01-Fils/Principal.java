public class Principal {
    private static boolean tornJuan = true; // Control del torn per alternança estricta

    public static void main(String[] args) {
        // Comportament 1: Execució intercalada
        System.out.println("Comportament 1: Execució intercalada");
        executarHilosIntercalats();

        // Comportament 2: Primer Pepe, després Juan
        System.out.println("\nComportament 2: Primer Pepe, després Juan");
        executarPrimerPepeDespresJuan();

        // Comportament 3: Execució alternada estricta
        System.out.println("\nComportament 3: Execució alternada estricta");
        executarHilosAlternatsEstricta();
    }

    private static void executarHilosIntercalats() {
        Thread juan = new Thread(() -> executarIntercalat("Juan"));
        Thread pepe = new Thread(() -> executarIntercalat("Pepe"));

        System.out.println("Termina thread main");

        juan.start();
        pepe.start();

        try {
            juan.join();
            pepe.join();
        } catch (InterruptedException e) {
            System.err.println("Error en esperar els fils: " + e.getMessage());
        }
    }

    private static void executarPrimerPepeDespresJuan() {
        Thread pepe = new Thread(() -> executarIntercalat("Pepe"));
        Thread juan = new Thread(() -> executarIntercalat("Juan"));

        System.out.println("Termina thread main");

        // Establir prioritats
        pepe.setPriority(Thread.MAX_PRIORITY);
        juan.setPriority(Thread.MIN_PRIORITY);

        pepe.start();
        juan.start();

        try {
            pepe.join();
            juan.join();
        } catch (InterruptedException e) {
            System.err.println("Error en esperar els fils: " + e.getMessage());
        }
    }

    private static void executarHilosAlternatsEstricta() {
        System.out.println("Termina thread main");

        Object lock = new Object();
        Thread juan = new Thread(() -> executarAlternancaEstricta("Juan", lock, true));
        Thread pepe = new Thread(() -> executarAlternancaEstricta("Pepe", lock, false));

        juan.start();
        pepe.start();

        try {
            juan.join();
            pepe.join();
        } catch (InterruptedException e) {
            System.err.println("Error en esperar els fils: " + e.getMessage());
        }
    }

    private static void executarIntercalat(String nom) {
        for (int i = 1; i <= 9; i++) {
            System.out.println(nom + " " + i);

            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Termina el fil " + nom);
    }

    private static void executarAlternancaEstricta(String nom, Object lock, boolean esTornInicial) {
        for (int i = 1; i <= 9; i++) {
            synchronized (lock) {
                while ((esTornInicial && !tornJuan) || (!esTornInicial && tornJuan)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(nom + " " + i);
                tornJuan = !tornJuan;
                lock.notifyAll();
            }
        }
        System.out.println("Termina el fil " + nom);
    }
}
