package gui;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Paint;
import java.io.Serializable;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.BasicStroke;
import java.awt.Image;

public class Canvas extends JPanel {
    // public Dimension getPreferredSize(){
    //     return new Dimension(600,500);
    // }
    Image image;
    Canvas(){
        image = new ImageIcon("gui/head.png").getImage();
        this.setPreferredSize(new Dimension(500,500));
    }

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics.create();

        g.setPaint(Color.pink);
        g.setStroke(new BasicStroke(5));
        g.drawRect(350,50,100,100);
        g.drawRect(300,100,100,100);
        g.drawRect(250,150,100,100);
        g.drawRect(200,200,100,100);
        g.drawRect(150,250,100,100);
        g.drawRect(100,300,100,100);

        g.setPaint(Color.black);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        int x=  (this.getWidth() / 4);
            int y = (this.getHeight() / 2);
        g.drawString("Unlock Your Potential", x+5, y+90);

        g.drawImage(image, 400, 180,null );

    }
}
