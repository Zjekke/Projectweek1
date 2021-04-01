package domain;

import domain.Punt;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.awt.*;

public class Cirkel extends Vorm implements Drawable{


    private Punt middelPunt;
    private int straal;
    private Omhullende o;

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
        int diagonaal = this.getStraal() *2;
        Punt punt = new Punt(this.middelPunt.getX() - this.getStraal(), this.middelPunt.getY() - this.getStraal());
        o = new Omhullende(punt, diagonaal, diagonaal);
        return new Omhullende(punt, diagonaal, diagonaal);
    }

    public String toString() {
        return "Cirkel: ( Middelpunt: " + this.middelPunt.toString() + ", straal: " + this.straal + " )";
    }

    @Override
    public void teken(Pane root) {
        Circle cirkel = new Circle(this.getMiddelPunt().getX(), this.getMiddelPunt().getY(), this.getStraal());
        cirkel.setFill(Color.TRANSPARENT);
        cirkel.setStroke(Color.BLUE);
        root.getChildren().add(cirkel);
    }
}
