package domain;

public class LijnStuk {
    private Punt startPunt;
    private Punt eindPunt;

    public LijnStuk(Punt punt1, Punt punt2){
        this.startPunt = setStartPunt(punt1);
        this.eindPunt = setEindPunt(punt2);
    }

    private Punt setEindPunt(Punt punt) {
        if(punt == null || punt.equals(startPunt)){
            throw new DomainException("Fout punt");
        }
        return punt;
    }

    private Punt setStartPunt(Punt punt) {
        if(punt == null || punt.equals(eindPunt)){
            throw new DomainException("Fout punt");
        }
        return punt;
    }

    public Punt getStartPunt(){
        return startPunt;
    }
    public Punt getEindPunt(){
        return eindPunt;
    }

    public boolean equals(LijnStuk lijn){
        if(lijn.startPunt.equals(this.startPunt) && lijn.eindPunt.equals((this.eindPunt))){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "LijnStuk{" +
                "startPunt=" + startPunt +
                ", eindPunt=" + eindPunt +
                '}';
    }
}