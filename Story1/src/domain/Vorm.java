package domain;

import java.awt.*;
import java.util.ArrayList;

public abstract class Vorm implements Drawable {
    private Color kleur;

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





}
