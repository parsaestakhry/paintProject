package paintAbstract;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class PaintingArea {

    public ArrayList<Shape> shapeArr;

    public Graphics gr;
    public int width;
    public int height;

    public PaintingArea(Graphics gr, int width, int height) {
        shapeArr = new ArrayList();
        this.gr = gr;
        this.width = width;
        this.height = height;

    }

    

    public void addShape(Shape s) {
        shapeArr.add(s);
        s.draw(gr);
    }//addShape

    public boolean removeShape(int index) {
        return shapeArr.remove(index) != null;
    }//removeShape

    public int indexOf(Shape s) {
        
        return shapeArr.indexOf(s);
    }//indexOf

    public Shape getShapeByPoint(Point p) {
        Shape s = null;
        if (shapeArr != null) {
            for (int i = 0; i < shapeArr.size(); i++) {
                if (shapeArr.get(i).hit(p)) {
                    s = shapeArr.get(i);
                    break;
                }

            }
        }
        return s;
    }//getShapeByPoint

    public boolean moveShape(Point p, int xMove, int yMove) {
        boolean found = false;
        Shape s = getShapeByPoint(p);
        if (s != null) {
            s.move(xMove, yMove);
            found = true;
            reDrawAll();
        }

        return found;
    }//moveShape    

    public void reDrawAll(){
        gr.setColor(Color.white);
        gr.fillRect(0, 0, width, height);
        for (Shape s : shapeArr) {
            s.draw(gr);
        }
    }
    public String getStatus() {
        int lCount = 0, cCount = 0, rCount = 0, tCount=0, oCount = 0, pCount = 0;
        if (shapeArr != null) {

            for (Shape s : shapeArr) {
                if (s instanceof Line) {
                    lCount++;
                } else if (s instanceof Circle) {
                    cCount++;
                } else if (s instanceof Rectangle) {
                    rCount++;
                } else if (s instanceof Triangle) {
                    tCount++;
                } else if (s instanceof Oval) {
                    oCount ++;
                } else if (s instanceof Polygon) {
                    pCount ++;
                }
            }

        }

        return String.format("Lines:%d, Circles:%d, Rectangles:%d, Triangles:%d" ,"Ovals:%d" , "Polygons:%d" ,
                lCount, cCount, rCount,tCount , oCount , pCount);
    }
}
