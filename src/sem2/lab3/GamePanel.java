package sem2.lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class GamePanel extends JPanel implements Runnable {


    private BufferedImage bg;
    private BufferedImage plane;
    int positionY = 450;
    int positionXBG = 0;
    private Controller controller;


    public GamePanel(BufferedImage plane, BufferedImage bg) {
        super();
        setMinimumSize(new Dimension(890, 500));
        setPreferredSize(new Dimension(890, 500));
        setMaximumSize(new Dimension(890, 500));
        MediaTracker tracker = new MediaTracker(this);
        tracker.addImage(plane, 0);
        tracker.addImage(bg, 1);
        try {
            tracker.waitForAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.plane = plane;
        this.bg = bg;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(bg, positionXBG, 0, this);
        g.drawImage(bg, (890 + positionXBG), 0, this);
        g.drawImage(plane, 100, positionY, this);
    }

    @Override
    public void run() {
        while (true) {
            try {
                repaint();
                setPositionXBG(controller.setStartBGposition((int) (controller.getStartBGposition() - 0.1 * (controller.getCurrentSpeed() / 5))));
                setPositionY(450 - controller.getCurrentHeigth());
                Thread.currentThread().sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionXBG() {
        return positionXBG;
    }

    public void setPositionXBG(int positionXBG) {
        if (positionXBG / 890 <= -1) positionXBG = positionXBG % -890;
        this.positionXBG = positionXBG;
    }
}
