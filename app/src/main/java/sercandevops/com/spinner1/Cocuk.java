package sercandevops.com.spinner1;

public class Cocuk {

    private int id;
    private String cocukAdi;
    private int ana_id;


    public Cocuk(){
        
    }
    public Cocuk(int id, String cocukAdi, int ana_id) {
        this.id = id;
        this.cocukAdi = cocukAdi;
        this.ana_id = ana_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCocukAdi() {
        return cocukAdi;
    }

    public void setCocukAdi(String cocukAdi) {
        this.cocukAdi = cocukAdi;
    }

    public int getAna_id() {
        return ana_id;
    }

    public void setAna_id(int ana_id) {
        this.ana_id = ana_id;
    }
}
