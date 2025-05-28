// model/Categorie.java
package Model;

public class Categorie {
    private String cod;
    private String nume;
    private String descriere;

    public Categorie(String cod, String nume, String descriere) {
        this.cod = cod;
        this.nume = nume;
        this.descriere = descriere;
    }

    public String getCod() { return cod; }
    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }
    public String getDescriere() { return descriere; }
    public void setDescriere(String descriere) { this.descriere = descriere; }

    @Override
    public String toString() {
        return "Categorie{" +
                "cod='" + cod + '\'' +
                ", nume='" + nume + '\'' +
                ", descriere='" + descriere + '\'' +
                '}';
    }
}