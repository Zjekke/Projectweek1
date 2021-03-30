package domain;

public class Punt extends Vorm {
    private int x,y;

    public Punt(int x, int y){
        setX(x);
        setY(y);
    }

    public int compareTo(Punt anderPunt){
        double resultaat = Math.sqrt(Math.pow(this.x - anderPunt.x, 2) + Math.pow(this.y - anderPunt.y, 2));

        return (int)resultaat;
    }

    public boolean equals(Punt anderPunt){
        if(this.x == anderPunt.getX() && this.y == anderPunt.getY()){
            return true;
        }
        return false;
    }

    private void setX(int x){
        if(x < 0){
            throw new NumberFormatException("Foute X");
        }
        this.x = x;
    }

    private void setY(int y){
        if(y < 0){
            throw new NumberFormatException("Foute Y");
        }
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public String toString(){
        return "(" + this.x + ", " + this.y +")";
    }
}
