package Story1.src.domain;

public class Cirkel {


    private Punt middelPunt;
    private int straal;

    public Cirkel(Punt middelPunt, int straal) {
        this.middelPunt = middelPunt;
        this.straal = straal;
    }

    public Punt getMiddelPunt() {
        return middelPunt;
    }

    public void setMiddelPunt(Punt middelPunt) {
        this.middelPunt = middelPunt;
    }

    public int getStraal() {
        return straal;
    }

    public void setStraal(int straal) {
        this.straal = straal;
    }


    public boolean isZelfde(Cirkel c) {
        if (c == null) {
            return false;
        }
        return this.middelPunt.equals(c.middelPunt) && this.straal == c.straal;
    }

    public String toString() {
        return "Cirkel: ( Middelpunt: " + this.middelPunt.toString() + ", straal: " + this.straal + " )";
    }
}
