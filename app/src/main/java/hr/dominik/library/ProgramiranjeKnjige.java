package hr.dominik.library;

public class ProgramiranjeKnjige {

    private String imeKnjige;
    private String pisac;
    private String stranice;
    private String datum;
    private int slika;

    public ProgramiranjeKnjige(String imeKnjige,String pisac,String stranice,String datum, int slika) {
        this.imeKnjige = imeKnjige;
        this.pisac = pisac;
        this.stranice = stranice;
        this.datum = datum;
        this.slika = slika;
    }

    public String getPisac() {
        return pisac;
    }

    public void setPisac(String pisac) {
        this.pisac = pisac;
    }

    public String getStranice() {
        return stranice;
    }

    public void setStranice(String stranice) {
        this.stranice = stranice;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getImeKnjige() {
        return imeKnjige;
    }

    public void setImeKnjige(String imeKnjige) {
        this.imeKnjige = imeKnjige;
    }

    public int getSlika() {
        return slika;
    }

    public void setSlika(int slika) {
        this.slika = slika;
    }
}
