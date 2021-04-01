package domain;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Tekening implements Drawable {
    private String naam;
    private ArrayList<Vorm> vormen;
    public static final int MIN_X = 0;
    public static final int MIN_Y = 0;
    public static final int MAX_X = 399;
    public static final int MAX_Y = 399;

    public Tekening(String naam) {
        vormen = new ArrayList<Vorm>();
        this.naam = setNaam(naam);
    }

    private String setNaam(String naam) {
        if (isValidNaam(naam)) {
            return naam;
        }
        throw new IllegalArgumentException("Foute naam");
    }

    public int getAantalVormen() {
        return this.vormen.size();
    }

    public ArrayList<Vorm> getVormen() {
        return vormen;
    }

    public void voegToe(Vorm vorm) {
        if (vorm.getOmhullende().getMaximumX() > MAX_X || vorm.getOmhullende().getMinimumX() < MIN_X || vorm.getOmhullende().getMaximumY() > MAX_Y || vorm.getOmhullende().getMinimumY() < MIN_Y) {
            throw new DomainException("Foute vorm grootte");
        } else {
            this.vormen.add(vorm);
        }
    }

    public void verwijder(Vorm vorm) {
        this.vormen.removeIf(v -> v.equals(vorm));
    }

    public boolean bevat(Vorm vorm) {
        for (Vorm v : this.vormen) {
            if (v.equals(vorm)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object o) {
        Tekening tekening = (Tekening) o;
        if (tekening == null) {
            return false;
        }
        for (Vorm v : this.vormen) {
            if (!tekening.vormen.contains(v)) {
                return false;
            }
        }
        return this.vormen.size() == tekening.vormen.size();
    }

    public Vorm getVorm(int i) {
        return vormen.get(i);
    }

    public String toString() {
        String resultaat = "";
        for (Vorm v : this.vormen) {
            resultaat += v.toString();
        }
        return resultaat;
    }

    public static boolean isValidNaam(String naam) {
        return naam != null && !naam.trim().isEmpty() && naam.length() >= 1;
    }

    public String getNaam() {
        return this.naam;
    }

    @Override
    public void teken(Pane root) {
        for (Vorm v : vormen) {
            if (v.isZichtbaar()) {
                v.teken(root);
            }
        }
    }
}
