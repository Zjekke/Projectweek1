package domain;
import javafx.scene.paint.Color;
import java.awt.*;

public abstract class Vorm implements Drawable {
    private Color kleur;
    private boolean zichtbaar;

    public Color getKleur() {
        return this.kleur;
    }

    public void setKleur(Color kleur) {
        this.kleur = kleur;
    }

    public abstract Omhullende getOmhullende() throws DomainException;

    public String toString(){
        return "(" + this.kleur + ")";
    }

    public Vorm() {
        this.zichtbaar = false;
    }

    public void setZichtbaar(boolean zichtbaar) {
        this.zichtbaar = zichtbaar;
    }

    public boolean isZichtbaar() {
        return this.zichtbaar;
    }







}
