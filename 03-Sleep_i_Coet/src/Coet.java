
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coet {
    private final Motor[] motors;

    public Coet() {
        motors = new Motor[4];
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor();
            motors[i].setName("Motor " + i);
        }
    }

    public void establirPotencia(int potencia) {
        if (potencia < 0 || potencia > 10) {
            System.out.println("Error: Nivell de potència fora de rang (0-10).");
            return;
        }
        System.out.println("Establint potència a: " + potencia);
        for (Motor motor : motors) {
            motor.setPotenciaDesitjada(potencia);
        }
    }

    public void iniciar() {
        for (Motor motor : motors) {
            motor.start();
        }
    }

    public static void main(String[] args) {
        Coet nau = new Coet();
        nau.iniciar();

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int potencia = -1;

        System.out.println("Introdueix el nivell de potència objectiu (0 per sortir):");

        while (potencia != 0) {
            try {
                String entrada = lector.readLine();
                potencia = Integer.parseInt(entrada);

                if (potencia != 0) {
                    nau.establirPotencia(potencia);
                }
            } catch (IOException e) {
                System.out.println("Error al llegir l'entrada: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Entrada incorrecta. Introdueix un nombre enter vàlid.");
            }
        }

        System.out.println("Apagant els motors...");
        nau.establirPotencia(0);
    }
}
