package domain;

public class Punt {
    int x,y;

    public Punt(int x, int y){
        setX(x);
        setY(y);
    }

    private void setX(int x){
        if(x < 0){
            throw new IllegalArgumentException("Foute X");
        }
        this.x = x;
    }

    private void setY(int y){
        if(y < 0){
            throw new IllegalArgumentException("Foute Y");
        }
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
