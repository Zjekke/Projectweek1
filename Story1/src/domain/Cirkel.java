package domain;

import domain.Punt;

import java.awt.*;

public class Cirkel extends Vorm {


    private Punt middelPunt;
    private int straal;

    public Cirkel(Punt middelPunt, int straal) {
        if (middelPunt == null) {
            throw new IllegalArgumentException("middelpunt is verplicht");
        }
        this.middelPunt = middelPunt;
        if (straal == 0 || straal < 0) {
            throw new IllegalArgumentException("straal moet groter zijn dan 0");
        }
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

    @Override
    public Omhullende getOmhullende() throws DomainException {
        return null;
    }

    public String toString() {
        return "Cirkel: ( Middelpunt: " + this.middelPunt.toString() + ", straal: " + this.straal + " )";
    }

    @Override
    public void teken(Tekening tekening) {

    }
}
