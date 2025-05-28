// model/ProdusNeperisabil.java
package Model;

public class ProdusNeperisabil extends Produs {
    private int garantieInLuni;

    public ProdusNeperisabil(String cod, String denumire, double pret, int cantitateMinima, Categorie categorie, Distribuitor distribuitor, int garantieInLuni) {
        super(cod, denumire, pret, cantitateMinima, categorie, distribuitor);
        this.garantieInLuni = garantieInLuni;
    }

    public int getGarantieInLuni() {
        return garantieInLuni;
    }

    public void setGarantieInLuni(int garantieInLuni) {
        this.garantieInLuni = garantieInLuni;
    }

    @Override
    public String toString() {
        return super.toString() + " ProdusNeperisabil{garantieInLuni=" + garantieInLuni + "}";
    }
}