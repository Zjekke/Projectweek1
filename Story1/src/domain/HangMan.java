package domain;

public class HangMan {
    private Speler speler;
    private TekeningHangMan tekeningHangMan;
    private HintWoord hintwoord;
    private WoordenLijst woordenLijst;
    private boolean gewonnen;

    public HangMan(Speler speler, WoordenLijst woordenLijst) {
        if (speler == null || woordenLijst == null) {
            throw new DomainException("Verkeerde input");
        }
        else if (woordenLijst.getAantalWoorden() == 0) {
            throw new DomainException("Woordenlijst is leeg");
        }
        this.speler = speler;
        this.woordenLijst = woordenLijst;
        this.tekeningHangMan = new TekeningHangMan();
        this.hintwoord = new HintWoord(woordenLijst.getRandomWoord());
        this.gewonnen = false;
    }

    public Speler getSpeler() {
        return speler;
    }

    public String getHint() {
        return this.hintwoord.toString();
    }

    public TekeningHangMan getTekening() {
        return tekeningHangMan;
    }


    public boolean raad(char c) {
        boolean success = this.hintwoord.raad(c);
        if (!success) {
            try {
                this.tekeningHangMan.zetVolgendeZichtbaar();
            }
            catch (DomainException exception) {
                exception.printStackTrace();
            }
        }
        this.gewonnen = isGewonnen();
        return success;
    }

    public boolean isGameOver() {
        return this.tekeningHangMan.getAantalOnzichtbaar() == 0;
    }

    public boolean isGewonnen() {
        return this.hintwoord.isGeraden();
    }
}
