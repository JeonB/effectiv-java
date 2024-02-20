package chapter3.item10;


import java.awt.Color;

public class ColorPoint extends Point{
    private final Color color;
    public ColorPoint(int x, int y, Color color){
        super(x,y);
        this.color = color;
    }

}
