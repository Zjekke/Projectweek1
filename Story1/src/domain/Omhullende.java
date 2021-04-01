package domain;

import javafx.scene.layout.Pane;

public class Omhullende extends Vorm {
    private int breedte, hoogte;
    private Punt positieLinksBoven;

    public Omhullende(Punt positieLinksBoven, int breedte, int hoogte){
        setBreedteEnHoogte(breedte, hoogte);
        setPositieLinksBoven(positieLinksBoven);
    }

    private void setBreedteEnHoogte(int breedte, int hoogte){
        if(breedte < 0 || hoogte < 0){
            throw new DomainException("foute breedte of hoogte");
        }
        this.breedte = breedte;
        this.hoogte = hoogte;
    }

    private void setPositieLinksBoven(Punt linksBoven){
        if(linksBoven == null){
            throw new DomainException("Fout hoekpunt");
        }
        this.positieLinksBoven = linksBoven;
    }

    public boolean equals(Omhullende omhullende){
        if(omhullende == null){
            return false;
        }
        return this.positieLinksBoven.equals(omhullende.positieLinksBoven) && this.hoogte == omhullende.hoogte && this.breedte == omhullende.breedte;
    }

    public int getMinimumX(){
        return this.positieLinksBoven.getX();
    }

    public int getMaximumX(){
        return this.positieLinksBoven.getX() + breedte;
    }

    public int getMinimumY(){
        return this.positieLinksBoven.getY();
    }

    public int getMaximumY(){
        return this.positieLinksBoven.getY() + hoogte;
    }

    public Punt getLinkerBovenhoek() {
        return this.positieLinksBoven;
    }

    public int getHoogte() {
        return this.hoogte;
    }

    public int getBreedte(){
        return this.breedte;
    }

    @Override
    public Omhullende getOmhullende() throws DomainException {
        return new Omhullende(this.getLinkerBovenhoek(), this.getBreedte(), this.getHoogte());
    }

    @Override
    public void teken(Pane root) {

    }
}
