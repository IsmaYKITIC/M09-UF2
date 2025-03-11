public class Client {
    private int id;
    private String nom;

    public Client(int id) {
        this.id = id;
        this.nom = "Client(" + id + ")";
    }

    public void tallarseElCabell() {
        System.out.println(nom + " tallant-se el cabell");
    }

    public String getNom() {
        return nom;
    }
}