import java.util.Random;

public class Motor extends Thread {
    private int potenciaActual = 0;
    private int potenciaDesitjada = 0;
    private boolean operatiu = true;

    public void setPotenciaDesitjada(int potenciaDesitjada) {
        this.potenciaDesitjada = potenciaDesitjada;
    }

    @Override
    public void run() {
        Random generadorAleatori = new Random();

        while (operatiu) {
            if (potenciaActual == potenciaDesitjada) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(getName() + ": Interromput. Finalitzant.");
                    operatiu = false;
                }
                continue;
            }

            if (potenciaDesitjada == 0 && potenciaActual == 0) {
                System.out.println(getName() + ": Motor apagat");
                operatiu = false;
                break;
            }

            if (potenciaActual < potenciaDesitjada) {
                potenciaActual++;
                System.out.println(
                        getName() + ": Incrementant. Desitjada: " + potenciaDesitjada + " Actual: " + potenciaActual);
            } else if (potenciaActual > potenciaDesitjada) {
                potenciaActual--;
                System.out.println(
                        getName() + ": Decrementant. Desitjada: " + potenciaDesitjada + " Actual: " + potenciaActual);
            }

            try {
                Thread.sleep(1000 + generadorAleatori.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println(getName() + ": Interromput durant l'ajust. Finalitzant.");
                operatiu = false;
            }
        }
    }
}
