// model/Raport.java
package Model;

public class Raport {
    private String id;
    private String data;
    private String tip;
    private String continut;

    public Raport(String id, String data, String tip, String continut) {
        this.id = id;
        this.data = data;
        this.tip = tip;
        this.continut = continut;
    }

    public String getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getContinut() {
        return continut;
    }

    public void setContinut(String continut) {
        this.continut = continut;
    }

    @Override
    public String toString() {
        return "Raport{" +
                "id='" + id + '\'' +
                ", data='" + data + '\'' +
                ", tip='" + tip + '\'' +
                ", continut='" + continut + '\'' +
                '}';
    }
}
