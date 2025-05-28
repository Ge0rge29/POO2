// model/Distribuitor.java
package Model;

public class Distribuitor {
    private String cod;
    private String nume;
    private String adresa;
    private String telefon;
    private String email;

    public Distribuitor(String cod, String nume, String adresa, String telefon, String email) {
        this.cod = cod;
        this.nume = nume;
        this.adresa = adresa;
        this.telefon = telefon;
        this.email = email;
    }

    public String getCod() { return cod; }
    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }
    public String getAdresa() { return adresa; }
    public void setAdresa(String adresa) { this.adresa = adresa; }
    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Distribuitor{" +
                "cod='" + cod + '\'' +
                ", nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}