package hr.dominik.library;

public class ProgramiranjeKnjige {

    private String ime;
    private int slika;

    public ProgramiranjeKnjige(String ime, int slika) {
        this.ime = ime;
        this.slika = slika;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getSlika() {
        return slika;
    }

    public void setSlika(int slika) {
        this.slika = slika;
    }
}
