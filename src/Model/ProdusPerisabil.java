package Model;

public class ProdusPerisabil extends Produs {
    private String dataExpirare;

    public ProdusPerisabil(String cod, String denumire, double pret, int cantitateMinima, Categorie categorie, Distribuitor distribuitor, String dataExpirare) {
        super(cod, denumire, pret, cantitateMinima, categorie, distribuitor);
        this.dataExpirare = dataExpirare;
    }

    public String getDataExpirare() {
        return dataExpirare;
    }

    public void setDataExpirare(String dataExpirare) {
        this.dataExpirare = dataExpirare;
    }

    @Override
    public String toString() {
        return super.toString() + " ProdusPerisabil{dataExpirare='" + dataExpirare + "'}";
    }
}