package domain;

public class Rechthoek extends Vorm {
    private int hoogte;
    private int breedte;
    private Punt linkerBovenhoek;

    public Rechthoek(Punt linkerBovenhoek, int hoogte, int breedte) {
        this.hoogte = hoogte;
        this.breedte = breedte;
        this.linkerBovenhoek = linkerBovenhoek;
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

    public boolean equals(Rechthoek r) {
        if (r == null) {
            return false;
        }
        return this.hoogte == r.hoogte && this.breedte == r.breedte && this.linkerBovenhoek.equals(r.linkerBovenhoek);
    }

    public String toString() {
        return "Rechthoek: ( linkerbovenhoek: " + this.linkerBovenhoek.toString() + ", breedte: " + this.breedte + ", hoogte: " + this.hoogte+ " )";
    }
}
