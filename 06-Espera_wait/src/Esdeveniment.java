package src;

import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
    private final List<Assistent> llistaAssistents = new ArrayList<>();
    private int placesDisponibles;

    public Esdeveniment(int aforament) {
        this.placesDisponibles = aforament;
    }

    public synchronized void ferReserva(Assistent assistent) {
        while (placesDisponibles == 0 && !Thread.currentThread().isInterrupted()) {
            try {
                System.out.println(assistent.getNom() + " està esperant una plaça...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(assistent.getNom() + " ha estat interromput mentre esperava una plaça.");
                return;
            }
        }
        if (!Thread.currentThread().isInterrupted()) {
            llistaAssistents.add(assistent);
            placesDisponibles--;
            System.out.println(assistent.getNom() + " ha fet una reserva. Places disponibles: " + placesDisponibles);
        }
    }

    public synchronized void cancelaReserva(Assistent assistent) {
        if (llistaAssistents.contains(assistent)) {
            llistaAssistents.remove(assistent);
            placesDisponibles++;
            System.out.println(
                    assistent.getNom() + " ha cancel·lat una reserva. Places disponibles: " + placesDisponibles);
            notifyAll();
        } else {
            System.out.println(assistent.getNom()
                    + " no ha pogut cancel·lar una reserva inexistent. Places disponibles: " + placesDisponibles);
        }
    }
}