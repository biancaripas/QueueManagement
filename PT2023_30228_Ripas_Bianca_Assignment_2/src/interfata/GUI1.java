package interfata;

import simulator.Simulator;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class GUI1 extends JPanel {

    public void coloreaza() {
        this.setBackground(Color.PINK);
        this.repaint();
    }
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        int x = 70;
        int i=0;
        int j=0;
        for ( i = 0; i < Simulator.cozi.length; i++) {
            int y = 70;
            if(Simulator.cozi[i].getSize()==0)
            {
                paintCasa(graphics, x, y);
            }else{
                paintCasa2(graphics,x,y);
            }
            for ( j = 0; j < Simulator.cozi[i].getSize(); j++) {
                y += 70;
                if(j==0)
                {
                    paintClient2(graphics,x,y);
                }else {
                    paintClient(graphics, x, y);
                }}
            x += 140;
        }
    }

    private void paintClient(Graphics color1, int x, int y) {
        Random color = new Random();
        Color randomColor = new Color(color.nextFloat(), color.nextFloat(), color.nextFloat());
        color1.setColor(randomColor);
        color1.fillRect(x, y, 40, 40);
        repaint();
    }
    private void paintClient2(Graphics color1, int x, int y) {
        color1.setColor(Color.ORANGE);
        color1.fillRect(x, y, 40, 40);
        repaint();
    }
    private void paintCasa(Graphics color, int x, int y) {
        color.setColor(Color.RED);
        color.fillRect(x, y, 120, 50);
        repaint();
    }
    private void paintCasa2(Graphics color1, int x, int y) {
        color1.setColor(Color.GREEN);
        color1.fillRect(x, y, 120, 50);
        repaint();
    }


}

