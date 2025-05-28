// model/Produs.java
package Model;

public class Produs {
    private String cod;
    private String denumire;
    private double pret;
    private int cantitateMinima;
    private Categorie categorie;
    private Distribuitor distribuitor;

    public Produs(String cod, String denumire, double pret, int cantitateMinima, Categorie categorie, Distribuitor distribuitor) {
        this.cod = cod;
        this.denumire = denumire;
        this.pret = pret;
        this.cantitateMinima = cantitateMinima;
        this.categorie = categorie;
        this.distribuitor = distribuitor;
    }

    public String getCod() { return cod; }
    public String getDenumire() { return denumire; }
    public void setDenumire(String denumire) { this.denumire = denumire; }
    public double getPret() { return pret; }
    public void setPret(double pret) { this.pret = pret; }
    public int getCantitateMinima() { return cantitateMinima; }
    public void setCantitateMinima(int cantitateMinima) { this.cantitateMinima = cantitateMinima; }
    public Categorie getCategorie() { return categorie; }
    public void setCategorie(Categorie categorie) { this.categorie = categorie; }
    public Distribuitor getDistribuitor() { return distribuitor; }
    public void setDistribuitor(Distribuitor distribuitor) { this.distribuitor = distribuitor; }

    @Override
    public String toString() {
        return "Produs{" +
                "cod='" + cod + '\'' +
                ", denumire='" + denumire + '\'' +
                ", pret=" + pret +
                ", cantitateMinima=" + cantitateMinima +
                ", categorie=" + categorie.getNume() +
                ", distribuitor=" + distribuitor.getNume() +
                '}';
    }
}
