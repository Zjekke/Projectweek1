package domain;

public class Driehoek {
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

    public Punt getHoekPunt1(){
        return this.punt1;
    }
    public Punt getHoekPunt2(){
        return this.punt2;
    }
    public Punt getHoekPunt3(){
        return this.punt3;
    }
}
