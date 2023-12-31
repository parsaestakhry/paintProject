package paintAbstract;

import java.awt.Color;
import java.awt.Graphics;
// circle class is an inheritor of the shape class
public class Circle extends Shape {
    // creating a variable from Point class called center
    // which will be representing the center point of the circle
    public Point center;
    // radius is the distance between the center and the point that hits the circle
    public int radius;
    // a default constructor
    public Circle() {
        this.name = "Circle_" + MyTools.getRandomInteger(1000);
        this.center = new Point();
        this.radius = 1;
        this.borderColor = Color.BLACK;
        this.fillColor = Color.white;
    }
    // this constructor lets us initialize the variables
    public Circle(Point center, int radius, Color borderColor, Color fillColor) {
        this.name = "Circle_" + MyTools.getRandomInteger(1000);
        this.center = center;
        this.radius = radius;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    public void draw(Graphics gr) {
        if (isFilled) {
            //if the fill boolean is true then we will fill the oval
            // oval is another type of circle
            gr.setColor(fillColor);
            //
            gr.fillOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
        } else {
            gr.setColor(borderColor);
            gr.drawOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);

        }

        System.out.println("Draw Circle  Center:" + center + " Radius:" + radius);
    }

    public void move(int xMove, int yMove) {
        center.setX(xMove + center.getX());
        center.setY(yMove + center.getY());

    }

    public void erase() {
        System.out.println(name + " Deleted.");
    }

    public boolean hit(Point p) {
        return center.distance(p) <= radius;
    }

}
