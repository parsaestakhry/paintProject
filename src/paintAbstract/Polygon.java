package paintAbstract;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Polygon extends Shape {
    public Point[] points = new Point[1];

    public Polygon(){
        this.name = "Polygon_" + MyTools.getRandomInteger(1000);
        this.borderColor = Color.red;
        this.fillColor = Color.BLUE;
    }

    public Polygon(Point[] points, Color borderColor, Color fillColor){
        this.name = "Polygon_" + MyTools.getRandomInteger(1000);
        this.points = points;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }
    @Override
    public void draw(Graphics gr) {
        int[] xArray = new int[0];
        for (Point p : points) {
            xArray = Arrays.copyOf(xArray,xArray.length + 1);
            xArray[xArray.length - 1] = p.getX();
        }
        int[] yArray = new int[0];
        for (Point p : points) {
            yArray = Arrays.copyOf(yArray,yArray.length + 1);
            yArray[yArray.length - 1] = p.getY();
        }
        if (isFilled){
            gr.setColor(fillColor);
            gr.fillPolygon(xArray,yArray,xArray.length);
        }
        else {
            gr.setColor(fillColor);
            gr.drawPolygon(xArray,yArray,xArray.length);
        }
        System.out.println("polygon drawn");
    }

    @Override
    public void move(int xMove, int yMove) {
        for (Point p : points){
            p.setX(xMove + p.getX());
            p.setY(yMove + p.getY());
        }
    }

    @Override
    public void erase() {
        System.out.println(name + " Deleted.");
    }

    @Override
    public boolean hit(Point p) {
        Point point = new Point((points[0].getX() + points[2].getX()) / 2 , (points[0].getY() + points[2].getY())/ 2);
        for (int i = 0; i < points.length - 2; i++) {
            Triangle triangle = new Triangle(point, points[i] , points[i + 1] , borderColor , fillColor);
            if (triangle.hit(p)){
                return true;
            }
            Triangle triangle1 = new Triangle(point ,points[points.length - 1] , points[0] , borderColor , fillColor);
            if (triangle.hit(p)){
                return true;
            }
        }
        return false;
    }
}
