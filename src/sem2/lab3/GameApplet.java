package sem2.lab3;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class GameApplet extends JApplet {
    private JPanel mainPanel;
    private JPanel charackteristicksPanel;
    private JPanel gamePanel;
    private JPanel fuelPanel;
    private JProgressBar fuelProgressBar;
    private JLabel distanceLabel;
    private JLabel heigthLabel;
    private JLabel speedLabel;
    private Controller controller;
    private MediaTracker tracker;
    private GamePanel gamePanell;

    @Override
    public void init() {
        super.init();
        setSize(new Dimension(900, 600));
        try {
            gamePanell = new GamePanel(ImageIO.read(new File("D:\\develop\\razd_system\\src\\sem2\\lab3\\litak.gif")),
                    ImageIO.read(new File("D:\\develop\\razd_system\\src\\sem2\\lab3\\fon.gif")));
            Thread planerThread = new Thread(gamePanell);
            gamePanel.add(gamePanell);
            planerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        add(mainPanel);
        controller = new Controller(gamePanell, this);
        gamePanell.setController(this.controller);
        initBottomPanel();
        addKeyListener(new MultiKeyPressListener());
        setFocusable(true);
        setVisible(true);
    }

    private void initBottomPanel() {
        fuelProgressBar.setMinimum(0);
        fuelProgressBar.setMaximum(5000);
        Thread valuesMonitorThread = new Thread(new ValuesMonitor());
        valuesMonitorThread.start();
    }

    public GamePanel getGamePanell() {
        return gamePanell;
    }

    public static void main(String[] args) {
        new GameApplet();
    }



    private class ValuesMonitor implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.currentThread().sleep(50);
                    fuelProgressBar.setValue((int) controller.getCurrentFuel());
                    speedLabel.setText(String.valueOf(controller.getCurrentSpeed()));
                    heigthLabel.setText(String.valueOf(controller.getCurrentHeigth()));
                    distanceLabel.setText(String.valueOf(-controller.getStartBGposition()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class MultiKeyPressListener implements KeyListener {

        // Set of currently pressed keys
        private Set<Integer> pressed = new HashSet<>();

        @Override
        public synchronized void keyPressed(KeyEvent e) {
            pressed.add(e.getKeyCode());
            for (Integer integer : pressed) {
                doJob(integer);
            }
        }

        private void doJob(Integer keyKode) {
            switch (keyKode) {
                case KeyEvent.VK_UP:
                    controller.heigthGrow();
                    break;
                case KeyEvent.VK_DOWN:
                    controller.heigthLow();
                    break;
                case KeyEvent.VK_RIGHT:
                    controller.speedGrow();
                    break;
                case KeyEvent.VK_LEFT:
                    controller.speedLow();
                    break;
                case KeyEvent.VK_NUMPAD0:
                    controller.zapravit();
                    break;
            }
        }

        @Override
        public synchronized void keyReleased(KeyEvent e) {
            pressed.remove(e.getKeyCode());
        }

        @Override
        public void keyTyped(KeyEvent e) {/* Not used */ }
    }

}
