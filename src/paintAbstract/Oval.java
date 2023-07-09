package paintAbstract;

import java.awt.*;

public class Oval extends Shape {
    public Point p1,p2;
    public int width,height;

    Rectangle rectangle = new Rectangle();
    public Oval() {
        this.name = "Oval_" + MyTools.getRandomInteger(1000);
        this.p1 = new Point();
        this.p2 = new Point();
        this.borderColor = Color.black;
        this.fillColor = Color.BLUE;
    }
    public Oval (Point p1,Point p2, int width, int height, Color borderColor, Color fillColor){
        this.name = "Oval_" + MyTools.getRandomInteger(1000);
        this.p1 = p1;
        this.p2 = p2;
        this.width = width;
        this.height = height;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }


    @Override
    public void draw(Graphics gr) {
        if (isFilled){
            gr.setColor(fillColor);
            gr.fillOval( p1.getX() , p1.getY(), p2.getX() - p1.getX(), p2.getY() - p1.getY());
        } else {

            gr.setColor(borderColor);
            gr.drawOval(p1.getX() , p1.getY(), p2.getX() - p1.getX(), p2.getY() - p1.getY());
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
        System.out.println(name + " Deleted.");
    }

    @Override
    public boolean hit(Point p) {
        double centerX = p1.getX() + (p2.getX() - p1.getX()) / 2.0;
        double centerY = p1.getY() + (p2.getY() - p1.getY()) / 2.0;

        double normalizedX = (p.getX() - centerX) / (width / 2.0);
        double normalizedY = (p.getY() - centerY) / (height / 2.0);

        return (normalizedX * normalizedX) + (normalizedY * normalizedY) <= 1.0;
    }
}

//    @Override
////    public boolean hit(Point p) {
////        double result = Math.pow(((p.getX() - center.getX()) / (width/2.0)) , 2 ) +
////                Math.pow(((p.getY() - center.getY()) / (height/2.0)) , 2 );
////        return result <= 1;
////    }
//}
