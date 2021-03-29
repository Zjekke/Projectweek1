package domain;

public class Speler {
    private String naam;
    private int score;

    public Speler(String naam){
        this.naam = setNaam(naam);
        this.score = 0;
    }

    private String setNaam(String naam) {
        if(naam == null || naam.isBlank()){
            throw new DomainException("Naam mag niet null zijn");
        }
        return naam;
    }

    public String getNaam(){
        return naam;
    }
    public int getScore(){
        return score;
    }
    public void addToScore(int i){
        if((score+i) < 0){
            throw new DomainException("score kan niet negztief");
        }
        score += i;
    }

    public boolean equals(Speler speler){
        if(speler != null){
            if(naam.equals(speler.getNaam()) && score == speler.getScore()){
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Speler{" +
                "naam='" + naam + '\'' +
                ", score=" + score +
                '}';
    }
}