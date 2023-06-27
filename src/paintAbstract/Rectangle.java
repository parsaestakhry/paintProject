package paintAbstract;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
    // we need at least two points facing each other to build a rectangle
    public Point p1, p2;
    // creating a default constructor
    public Rectangle() {
        // name of the rectangle is a random number generated in MyTools class
        this.name = "Rectangle_" + MyTools.getRandomInteger(1000);
        // since it's an empty constructor to pass the points we need to create an object from Point class
        this.p1 = new Point();
        this.p2 = new Point();
        // setting the border color as black as default
        this.borderColor = Color.black;
        // setting the fill color as yellow as default
        this.fillColor = Color.yellow;
    }
    // since this is not a default constructor we pass the arguments this time
    public Rectangle(Point p1, Point p2, Color borderColor, Color fillColor) {
        this.name = "Rectangle_" + MyTools.getRandomInteger(1000);
        this.p1 = p1;
        this.p2 = p2;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }
    // draw method is dependent on the filling of the rectangle
    public void draw(Graphics gr) {
        setPoints();
        if (isFilled) {
            gr.setColor(fillColor);
            gr.fillRect(p1.getX(), p1.getY(), p2.getX() - p1.getX(), p2.getY() - p1.getY());
        } else {
            // draw method is when the shape is empty inside
            gr.setColor(borderColor);
            gr.drawRect(p1.getX(), p1.getY(), p2.getX() - p1.getX(), p2.getY() - p1.getY());

        }
        System.out.println("Draw Rectangle " + p1 + " --> " + p2);
    }

    public void move(int xMove, int yMove) {
        p1.setX(xMove + p1.getX());
        p1.setY(yMove + p1.getY());

        p2.setX(xMove + p2.getX());
        p2.setY(yMove + p2.getY());
    }

    public void erase() {
        System.out.println(name + " Deleted.");
    }

    public boolean hit(Point p) {
        return (p1.getX() <= p.getX() && p.getX() <= p2.getX())
                && (p1.getY() <= p.getY() && p.getY() <= p2.getY());
    }

    public void setPoints() {
        if (p1.getX() > p2.getX()) {
            int t = p1.getX();
            p1.setX(p2.getX());
            p2.setX(t);
        }

        if (p1.getX() > p2.getY()) {
            int t = p1.getY();
            p1.setY(p2.getY());
            p2.setY(t);
        }

    }
}
