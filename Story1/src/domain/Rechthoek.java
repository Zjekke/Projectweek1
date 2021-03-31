package domain;

public class Rechthoek extends Vorm {
    private int hoogte;
    private int breedte;
    private Punt linkerBovenhoek;

    public Rechthoek(Punt linkerBovenhoek, int breedte, int hoogte) {
        setHoogte(hoogte);
        setBreedte(breedte);
        setLinkerBovenhoek(linkerBovenhoek);
    }

    public Punt getLinkerBovenhoek() {
        return this.linkerBovenhoek;
    }

    public int getHoogte() {
        return this.hoogte;
    }

    public int getBreedte() {
        return this.breedte;
    }

    private void setLinkerBovenhoek(Punt punt){
        if(punt == null){
            throw new DomainException("foute linkerbovenhoek");
        }
        this.linkerBovenhoek = punt;
    }

    private void setHoogte(int hoogte){
        if(hoogte <= 0){
            throw new DomainException("Ge kunt er niets van");
        }
        this.hoogte = hoogte;
    }

    public Omhullende getOmhullende(){
        return new Omhullende(this.linkerBovenhoek, this.breedte, this.hoogte);
    }

    private void setBreedte(int breedte){
        if(breedte <= 0){
            throw new DomainException("Foute breedte");
        }
        this.breedte = breedte;
    }

    public boolean equals(Rechthoek r) {
        if (r == null) {
            return false;
        }
        return this.hoogte == r.hoogte && this.breedte == r.breedte && this.linkerBovenhoek.equals(r.linkerBovenhoek);
    }

    public String toString() {
        return "Rechthoek: ( linkerbovenhoek: " + this.linkerBovenhoek.toString() + ", breedte: " + this.breedte + ", hoogte: " + this.hoogte+ " )";
    }

    @Override
    public void teken(Tekening tekening) {

    }
}
