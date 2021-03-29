package domain;

public class Speler {
    String naam;

    public Speler(String naam){
        setNaam(naam);
    }

    private void setNaam(String naam){
        this.naam = naam;
    }

    public String getNaam(){
        return this.naam;
    }
}