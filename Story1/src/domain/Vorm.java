package domain;

import java.awt.*;
import java.util.ArrayList;

public abstract class Vorm implements Drawable {
    private Color kleur;
    private boolean zichtbaar;

    public Color getKleur() {
        return kleur;
    }

    public void setKleur(Color kleur) {
        this.kleur = kleur;
    }

    public abstract Omhullende getOmhullende() throws DomainException;

    public String toString(){
        return "(" + this.kleur + ")";
    }

    public Vorm() {
        this.zichtbaar = true;
    }

    public void setZichtbaar(boolean zichtbaar) {
        this.zichtbaar = zichtbaar;
    }

    public boolean isZichtbaar() {
        return this.zichtbaar;
    }







}
