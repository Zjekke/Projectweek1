package domain;

public class LijnStuk extends Vorm {
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
        if(lijn.startPunt.equals(this.startPunt) && lijn.eindPunt.equals((this.eindPunt))){
            return true;
        }
        return false;
    }

    @Override
    public Omhullende getOmhullende() throws DomainException {
        int oHoogte = Math.abs(this.getEindPunt().getY() - this.getStartPunt().getY());
        int oBreedte = Math.abs(this.getEindPunt().getX() - this.getStartPunt().getX());
        int omhulX = Math.min(this.getEindPunt().getX(), this.getStartPunt().getX());
        int omhulY = Math.min(this.getEindPunt().getY(), this.getStartPunt().getY());
        o = new Omhullende(new Punt(omhulX,omhulY), oBreedte, oHoogte);
        return new Omhullende(new Punt(omhulX,omhulY), oBreedte, oHoogte);
    }

    @Override
    public String toString() {
        return "LijnStuk{" +
                "startPunt=" + startPunt +
                ", eindPunt=" + eindPunt +
                '}';
    }

    @Override
    public void teken(Tekening tekening) {

    }
}