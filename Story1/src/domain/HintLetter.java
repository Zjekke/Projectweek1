package domain;

public class HintLetter {
    private char letter;
    private boolean isGeraden;

    public HintLetter(char letter){
        this.isGeraden = false;
        this.letter = letter;
    }

    public char getLetter(){
        return this.letter;
    }

    public boolean raad(char letter){
        if(Character.toLowerCase(this.letter) == Character.toLowerCase(letter)){
            if(this.isGeraden){
                return false;
            } else{
                this.isGeraden = true;
                return true;
            }
        } else{
            return false;
        }
    }

    public char toChar(){
        if(this.isGeraden){
            return this.letter;
        } else{
            return '_';
        }
    }

    public boolean isGeraden(){
        return this.isGeraden;
    }
}
