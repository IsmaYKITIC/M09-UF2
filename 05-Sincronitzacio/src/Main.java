package src;

public class Main {
    public static void main(String[] args) {
        Associacio iticBCN = new Associacio(1000);
        iticBCN.iniciaCompteTempsSocis(iticBCN.getSocis());
        iticBCN.esperaPeriodeSocis();
        iticBCN.mostraBalancComptes();
    }

}
