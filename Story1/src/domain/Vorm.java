package domain;

import java.awt.*;
import java.util.ArrayList;

public class Vorm {
    private Color kleur;

    public Color getKleur() {
        return kleur;
    }

    public void setKleur(Color kleur) {
        this.kleur = kleur;
    }
    /*
    public Omhullende getOmhullende() {
        return Omhullende;
    }
    */

    public String toString(){
        return "(" + this.kleur + ")";
    }





}
