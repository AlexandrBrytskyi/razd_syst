package sem2.lab4;

import javax.swing.*;
import java.awt.*;


public class Lab4Applet extends JApplet {
    private JPanel mainPanel;
    private JLabel label;
    private int x = 0;
    private int y = 380;
    private static final int LABEL_WIDTH = 160;
    private static final int LABEL_HEIGTH = 30;

    @Override
    public void init() {
        super.init();
        setSize(new Dimension(500, 500));
        mainPanel.setLayout(null);
        label.setBounds(x, y, LABEL_WIDTH, LABEL_HEIGTH);
        add(mainPanel);
        setVisible(true);
        makeRepaintThread();
    }

    private void makeRepaintThread() {
        Thread coordinatesCounter = new Thread(new CoordinatesCounter());
        coordinatesCounter.start();
    }

    public static void main(String[] args) {
        new Lab4Applet();
    }

    private class CoordinatesCounter implements Runnable {
        int delx;
        int dely;
        double koef;
        boolean isGoingUp = true;

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.currentThread().sleep(10);
                    setXoordinates();
                    label.setBounds(x, y, LABEL_WIDTH, LABEL_HEIGTH);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void setXoordinates() {
            delx = getWidth() - 160;
            dely = getHeight();
            koef = Double.valueOf(delx) / Double.valueOf(dely);
            if (x <= (mainPanel.getSize().getWidth() - 160) && isGoingUp) {
                x++;
                if (x == mainPanel.getSize().getWidth() - 160) {
                    isGoingUp = false;
                    isGoingUpChanged();
                }
            } else {
                x--;
                if (x == 0) {
                    isGoingUp = true;
                    isGoingUpChanged();
                }
            }
            y = (int) (dely - ((Math.abs(1 - koef) + 1) * x + 30));
        }

        private void isGoingUpChanged() {
            changeRegister();
        }

        private void changeRegister() {
            String newString = "";
            for (char c : label.getText().toCharArray()) {
                double random = (Math.random() * 50);
                if ((int) random % 2 == 0) {
                    newString += Character.toLowerCase(c);
                } else {
                    newString += Character.toUpperCase(c);
                }
            }
            label.setText(newString);
        }
    }
}
