package domain;

import java.util.ArrayList;
import java.util.List;

public class WoordenLijst {
    private List<String> woorden;

    public WoordenLijst() {
        this.woorden = new ArrayList<>();
    }

    public List<String> getWoorden() {
        return this.woorden;
    }

    public int getAantalWoorden() {
        return this.woorden.size();
    }


    public void voegToe(String s) {
        if (s == null || s.trim().isEmpty()) {
            throw new DomainException("Woord mag niet leeg zijn!");
        }
        if (this.woorden.contains(s)) {
            throw new DomainException("De woordenlijst bevat dit woord al.");
        }
        this.woorden.add(s);
    }

    public String getRandomWoord() {
        int randomIndex = (int)(Math.random() * this.woorden.size());
        return this.woorden.get(randomIndex);
    }

    @Override
    public String toString() {
        String result = "De woordenlijst bevat de volgende woorden: " + "\n";
        for (String s : this.woorden) {
            result += s + "\n";
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof WoordenLijst) {
            WoordenLijst woordenLijst = (WoordenLijst) obj;
            if (woordenLijst.getWoorden().size() != this.getWoorden().size()) {
                return false;
            }
            for (String s : this.getWoorden()) {
                if (!woordenLijst.getWoorden().contains(s)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
