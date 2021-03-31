package domain;

import java.util.ArrayList;

public class HintWoord {
    private String woord;
    private ArrayList<HintLetter> hintwoord;

    public HintWoord(String woord){
        setWoord(woord);
        hintwoord = new ArrayList<>();

        for(int i = 0;i < woord.length();i++){
            hintwoord.add(new HintLetter(woord.charAt(i)));
        }
    }

    private void setWoord(String woord){
        if(woord == null || woord.trim().isEmpty()){
            throw new DomainException("fout woord");
        }
        this.woord = woord;
    }

    public boolean raad(char letter){
        boolean result = false;
        for(HintLetter hintLetter : this.hintwoord){
            if(hintLetter.raad(letter)){
                result = true;
            }
        }
        return result;
    }

    public boolean isGeraden(){
        for(HintLetter letter : this.hintwoord){
            if(!letter.isGeraden()){
                return false;
            }
        }
        return true;
    }

    public String getWoord(){
        return this.woord;
    }

    public String toString(){
        String string = "";
        for(HintLetter hintLetter : this.hintwoord){
            if(hintLetter.isGeraden()){
                string += hintLetter.getLetter() + " ";
            } else{
                string += "_ ";
            }
        }
        return string.trim();
    }
}
