package paintAbstract.testGraphics;

import javax.swing.*;
import java.awt.*;

public class myFrame extends JFrame {
    myFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void paint(Graphics graphics){
        graphics.drawLine(2, 2 , 4 , 5);


    }
}
