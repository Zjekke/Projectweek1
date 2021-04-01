package domain;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.scene.paint.Color;

import java.awt.*;

public class Driehoek extends Vorm {
    private Punt punt1, punt2, punt3;

    public Driehoek(Punt punt1, Punt punt2, Punt punt3){
        this.punt1 = setPunt(punt1);
        this.punt2 = setPunt(punt2);
        this.punt3 = setPunt(punt3);
    }

    private Punt setPunt(Punt punt){
        if(punt == null){
            throw new DomainException("Ongeldig punt.");
        }
        return punt;
    }

    public boolean liggenOp1Lijn(Punt punt1, Punt punt2, Punt punt3){
        return (punt1.getX() == punt2.getX() && punt2.getX() == punt3.getX()) || (punt1.getY() == punt2.getY() && punt2.getY() == punt3.getY());
    }

    public boolean equals(Driehoek anderDriehoek){
        return this == anderDriehoek;
    }

    @Override
    public Omhullende getOmhullende() throws DomainException {
        int hoogsteY = Math.max(punt1.getY(),Math.max(punt2.getY(),punt3.getY()));
        int laagsteY = Math.min(punt1.getY(),Math.min(punt2.getY(),punt3.getY()));
        int linkseX = Math.min(punt1.getX(),Math.min(punt2.getX(),punt3.getX()));
        int rechtseX = Math.max(punt1.getX(),Math.max(punt2.getX(),punt3.getX()));

        int breedte = rechtseX - linkseX;
        int hoogte = hoogsteY - laagsteY;

        return new Omhullende(new Punt(linkseX,laagsteY),breedte,hoogte);
    }

    public String toString(){
        return "(" + this.punt1 + ", " + this.punt2 + ", " + this.punt3 + ")";
    }

    public Punt getHoekPunt1(){
        return this.punt1;
    }
    public Punt getHoekPunt2(){
        return this.punt2;
    }
    public Punt getHoekPunt3(){
        return this.punt3;
    }

    @Override
    public void teken(Pane root) {

        int[] hoekInts = {this.getHoekPunt1().getX(), this.getHoekPunt1().getY(), this.getHoekPunt2().getX(), this.getHoekPunt2().getY(), this.getHoekPunt3().getX(), this.getHoekPunt3().getY()};

        double[] hoekDoubles = new double[hoekInts.length];

        for(int i=0; i<hoekInts.length; i++) {
            hoekDoubles[i] = hoekInts[i];
        }

        Polyline driehoek = new Polyline(hoekDoubles);
        driehoek.setFill(this.getKleur());
        driehoek.setStroke(Color.BLACK);

        root.getChildren().add(driehoek);

    }
}
