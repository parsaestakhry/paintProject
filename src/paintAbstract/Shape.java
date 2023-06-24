package paintAbstract;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {

    public String name;
    public Color borderColor;
    public Color fillColor;
    public boolean isFilled = false;

    public abstract void draw(Graphics gr);

    public abstract void move(int xMove, int yMove);

    public abstract void erase();

    public abstract boolean hit(Point p);
}
