package paintAbstract;

import java.awt.*;

public class Oval extends Shape {
    public Point center;
    public int width,height;

    Rectangle rectangle = new Rectangle();
    public Oval() {
        this.name = "Oval_" + MyTools.getRandomInteger(1000);
        this.center = new Point();
        this.borderColor = Color.black;
        this.fillColor = Color.BLUE;
    }
    public Oval (Point center, int width, int height, Color borderColor, Color fillColor){
        this.name = "Oval_" + MyTools.getRandomInteger(1000);
        this.center = center;
        this.width = width;
        this.height = height;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }


    @Override
    public void draw(Graphics gr) {
        if (isFilled){
            gr.setColor(fillColor);
            gr.drawOval(rectangle.p1.getX() , rectangle.p1.getY(), rectangle.p2.getX() - rectangle.p1.getX(),
                    rectangle.p2.getY() - rectangle.p1.getY());
        } else {
            gr.setColor(borderColor);
            gr.drawOval(rectangle.p1.getX() , rectangle.p1.getY(), rectangle.p2.getX() - rectangle.p1.getX(),
                    rectangle.p2.getY() - rectangle.p1.getY());
        }

    }

    @Override
    public void move(int xMove, int yMove) {
        center.setX(xMove + center.getX());
        center.setY(yMove + center.getY());
    }

    @Override
    public void erase() {
        System.out.println(name + " Deleted.");
    }

    @Override
    public boolean hit(Point p) {
        double result = Math.pow(((p.getX() - center.getX()) / (width/2.0)) , 2 ) +
                Math.pow(((p.getY() - center.getY()) / (height/2.0)) , 2 );
        return result <= 1;
    }
}
