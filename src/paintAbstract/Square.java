package paintAbstract;

import java.awt.*;

public class Square extends Shape {

    public Point p1,p2;

    public Square(){
        this.name = "Square_" + MyTools.getRandomInteger(1000);
        p1 = new Point();
        p2 = new Point();
        this.borderColor = Color.black;
        this.fillColor = Color.yellow;
    }
    public Square(Point p1, Point p2, Color borderColor, Color fillColor){
        this.p1 = p1;
        this.p2 = p2;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }
    @Override
    public void draw(Graphics gr) {
        setPoints();
        if (isFilled){
           gr.setColor(fillColor);
           gr.fillRect(p1.getX(), p1.getY(), p2.getY() - p1.getY() , p2.getX() - p1.getX());
        }
        else {
            gr.setColor(borderColor);
            gr.drawRect(p1.getX(), p1.getY(), p2.getY() - p1.getY() , p2.getX() - p1.getX());
        }
    }

    @Override
    public void move(int xMove, int yMove) {
        p1.setX(xMove + p1.getX());
        p1.setY(yMove + p1.getY());

        p2.setX(xMove + p2.getX());
        p2.setY(yMove + p2.getY());

    }

    @Override
    public void erase() {
        System.out.println(this.name + "is Deleted.");
    }

    @Override
    public boolean hit(Point p) {
        return (p1.getX() <= p.getX() && p.getX() <= p2.getX())
                && (p1.getY() <= p.getY() && p.getY() <= p2.getY());
    }

    public void setPoints(){
        int width = Math.abs(p2.getX() - p1.getX());
        int height = Math.abs(p2.getY() - p1.getY());
        int side = Math.max(width , height);

        if (p2.getX() < p1.getX()){
            int t = p1.getX();
            p1.setX(p2.getX());
            p2.setX(t);
        }

        if (p2.getY() < p1.getY()){
            int t = p1.getY();
            p1.setY(p2.getY());
            p2.setY(t);
        }

        p2.setX(p1.getX() + side);
        p2.setY(p1.getY() + side);
    }
}
