package src;

import java.util.ArrayList;
import java.util.List;

public class Esdeveniment extends Thread {
    List<Assistent> listaAsitent = new ArrayList<>();
    int aforament = 10;

    public Esdeveniment(int aforament) {
        this.aforament = aforament;
    }

    public void ferReserva(Assistent assistent) {
        if (aforament > 0) {
            listaAsitent.add(new Assistent(null, .getNom()));
        }

    }

    public void cancelaReserva(Assistent assistent) {

    }

}