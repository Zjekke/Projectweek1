package domain;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class LijnStuk extends Vorm implements Drawable{
    private Punt startPunt;
    private Punt eindPunt;

    private Omhullende o;

    public LijnStuk(Punt punt1, Punt punt2){
        setStartEnEindPunt(punt1, punt2);
    }

    private void setStartEnEindPunt(Punt startPunt, Punt eindPunt){
        if(startPunt == null || eindPunt == null || eindPunt.equals(startPunt)){
            throw new DomainException("Fout punt");
        }
        this.eindPunt = eindPunt;
        this.startPunt = startPunt;
    }

    public Punt getStartPunt(){
        return startPunt;
    }
    public Punt getEindPunt(){
        return eindPunt;
    }

    public boolean equals(LijnStuk lijn){
        if(lijn == null){
            return false;
        }
        return lijn.startPunt.equals(this.startPunt) && lijn.eindPunt.equals((this.eindPunt));
    }

    @Override
    public Omhullende getOmhullende() {
        int laagsteX = Math.min(startPunt.getX(),eindPunt.getX());
        int hoogsteX = Math.max(startPunt.getX(),eindPunt.getX());
        int laagsteY = Math.min(startPunt.getY(),eindPunt.getY());
        int hoogsteY = Math.max(startPunt.getY(),eindPunt.getY());
        return new Omhullende(new Punt(laagsteX, laagsteY), hoogsteX - laagsteX, hoogsteY - laagsteY);
    }

    @Override
    public String toString() {
        return "LijnStuk{" +
                "startPunt=" + startPunt +
                ", eindPunt=" + eindPunt +
                '}';
    }

    @Override
    public void teken(Pane root) {

        Line lijn = new Line(this.getStartPunt().getX(), this.getStartPunt().getY(), this.getEindPunt().getX(), this.getEindPunt().getY());
        lijn.setFill(this.getKleur());
        lijn.setStrokeWidth(5);
        root.getChildren().add(lijn);

    }
}