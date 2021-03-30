package domain;

import java.util.ArrayList;

public class Tekening {
    private String naam;
    private ArrayList<Vorm> vormen;
    public int MIN_X, MAX_X, MIN_Y, MAX_Y;

    public Tekening(String naam){
        vormen = new ArrayList<Vorm>();
        this.naam = setNaam(naam);
    }

    private String setNaam(String naam) {
        if(isValidNaam(naam)){
            return naam;
        }
        throw new IllegalArgumentException("Foute naam");
    }

    public int getAantalVormen(){
        return this.vormen.size();
    }

    public void voegToe(Vorm vorm){
        this.vormen.add(vorm);
    }

    public void verwijder(Vorm vorm){
        this.vormen.removeIf(v -> v.equals(vorm));
    }

    public boolean bevat(Vorm vorm){
        for(Vorm v : this.vormen){
            if(v.equals(vorm)){
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object o){
        Tekening tekening = (Tekening)o;
        if(tekening == null){
            return false;
        }
        for(Vorm v : this.vormen){
            if(!tekening.vormen.contains(v)){
                return false;
            }
        }
        if(this.vormen.size() == tekening.vormen.size()){
            return true;
        }
        return false;
    }

    public Vorm getVorm(int i){
        return vormen.get(i);
    }

    public String toString(){
        String resultaat = "";
        for(Vorm v : this.vormen){
            resultaat += v.toString();
        }
        return resultaat;
    }

    public static boolean isValidNaam(String naam){
        return naam != null && !naam.trim().isEmpty() && naam.length() >= 1;
    }

    public String getNaam(){
        return this.naam;
    }
}
