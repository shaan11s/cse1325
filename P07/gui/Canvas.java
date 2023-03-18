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
        this.setPreferredSize(new Dimension(500,400));
    }

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics.create();

        //Draw Rectangles
        int x1 = 350;
        int y1 = 50;
        g.setStroke(new BasicStroke(5));
        for(int i=0; i<10; i++){
            if(i<1){g.setPaint(Color.pink);}
            else{g.setPaint(Color.orange);}
            g.drawRect(x1,y1,100,100);
            x1-=20;
            y1+=20;
        }

        //Draw Slogan
        g.setPaint(Color.black);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        int x=  (this.getWidth() / 4);
            int y = (this.getHeight() / 2);
        g.drawString("Unlock Your Potential", x+7, y+140);

        //Draw Image
        g.drawImage(image, 400, 180,null );

    }
}
