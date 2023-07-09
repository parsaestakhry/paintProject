package paintAbstract;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Triangle extends Shape {

    public Point p1, p2, p3;

    public Triangle() {
        this.name = "Triangle_" + MyTools.getRandomInteger(1000);
        this.p1 = new Point();
        this.p2 = new Point();
        this.p3 = new Point();
        this.borderColor = Color.black;
        this.fillColor = Color.red;
    }

    public Triangle(Point p1, Point p2, Point p3, Color borderColor, Color fillColor) {
        this.name = "Triangle_" + MyTools.getRandomInteger(1000);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }
    // todo


    public void draw(Graphics gr) {
        if (isFilled){
            gr.setColor(fillColor);
            gr.fillPolygon(new int[] {p1.getX() , p2.getX() , p3.getX()} , new int[] {p1.getY() , p2.getY() , p3.getY()} , 3);
        }
        else {
            gr.setColor(borderColor);
            gr.drawPolygon(new int[] {p1.getX() , p2.getX() , p3.getX()} , new int[] {p1.getY() , p2.getY() , p3.getY()} , 3);
        }
        System.out.println("Draw Triangle " + p1 + " --> " + p2 + " --> " + p3);
    }

    public void move(int xMove, int yMove) {
        p1.setX(xMove + p1.getX());
        p1.setY(yMove + p1.getY());

        p2.setX(xMove + p2.getX());
        p2.setY(yMove + p2.getY());

        p3.setX(xMove + p3.getX());
        p3.setY(yMove + p3.getY());
    }

    public void erase() {
        System.out.println(name + " Deleted.");
    }
    // todo
    public boolean hit(Point p) {
       double totalArea = calculateTriangleArea(p1 , p2 , p3);
       double areaP12 = calculateTriangleArea(p , p1 , p2);
       double areaP23 = calculateTriangleArea(p , p2 , p3);
       double areaP31 = calculateTriangleArea(p , p3 , p1 );

        return (areaP12 + areaP23 + areaP31) == totalArea;

    }
    private static double calculateTriangleArea(Point a ,Point b , Point c){
        return 0.5 * Math.abs((a.getX() * (b.getY() - c.getY())) + (b.getX()  * (c.getY() - a.getY())) + (c.getX() * (a.getY() - b.getY())));
    }
}
