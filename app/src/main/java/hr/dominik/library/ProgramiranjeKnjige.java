package hr.dominik.library;

public class ProgramiranjeKnjige {

    private String imeKnjige;
    private String pisac;
    private String stranice;
    private String godina;
    private int slika;

    public ProgramiranjeKnjige(){

    }

    public ProgramiranjeKnjige(String imeKnjige, String pisac, String stranice, String godina, int slika) {
        this.imeKnjige = imeKnjige;
        this.pisac = pisac;
        this.stranice = stranice;
        this.godina = godina;
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

    public String getGodina() {
        return godina;
    }

    public void setGodina(String godina) {
        this.godina = godina;
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
