// model/Stoc.java
package Model;

public class Stoc {
    private Produs produs;
    private int cantitate;
    private String locatie;

    public Stoc(Produs produs, int cantitate, String locatie) {
        this.produs = produs;
        this.cantitate = cantitate;
        this.locatie = locatie;
    }

    public Produs getProdus() {
        return produs;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public void adaugaCantitate(int cantitate) {
        this.cantitate += cantitate;
    }

    public boolean scadeCantitate(int cantitate) {
        if (this.cantitate >= cantitate) {
            this.cantitate -= cantitate;
            return true;
        }
        return false;
    }

    public boolean esteSubLimitaMinima() {
        return cantitate < produs.getCantitateMinima();
    }

    @Override
    public String toString() {
        return "Stoc{" +
                "produs=" + produs.getDenumire() +
                ", cantitate=" + cantitate +
                ", locatie='" + locatie + '\'' +
                '}';
    }
}