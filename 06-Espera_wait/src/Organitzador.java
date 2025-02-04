package src;

public class Organitzador {
    public static void main(String[] args) {
        Esdeveniment esdeveniment = new Esdeveniment(5);
        Assistent[] assistents = new Assistent[10];

        // Creem i iniciem els assistents
        for (int i = 0; i < assistents.length; i++) {
            assistents[i] = new Assistent(esdeveniment, "Assistent-" + i);
            assistents[i].start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Assistent assistent : assistents) {
            assistent.interrupt();
        }

        for (Assistent assistent : assistents) {
            try {
                assistent.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Tots els assistents han estat aturats. Programa finalitzat.");
    }
}
