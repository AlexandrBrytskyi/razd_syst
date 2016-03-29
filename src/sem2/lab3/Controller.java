package sem2.lab3;


public class Controller {

    private Plane plane;
    private GamePanel gamePanel;
    private GameApplet gameApplet;
    private int startBGposition = 0;

    public Controller(GamePanel gamePanel, GameApplet gameApplet) {
        this.gamePanel = gamePanel;
        this.gameApplet = gameApplet;
        createPlane();
        initCoordSetter();
    }

    private void initCoordSetter() {
        Thread coordSetter = new Thread(new CoordinatesSetter());
        coordSetter.start();
    }

    public Plane createPlane() {
        plane = new Plane();
        return plane;
    }

    public boolean zapravit() {
        return plane.zapravit();
    }

    public int speedGrow() {
        return plane.speedGrow(2);
    }

    public int speedLow() {
        return plane.speedLow(2);
    }


    public int heigthGrow() {
        return plane.heigthGrow(2);
    }

    public int heigthLow() {
        return plane.hiegthLow(2);
    }

    public double getCurrentFuel() {
        return plane.getFuel();
    }

    public int getCurrentSpeed() {
        return plane.getSpeed();
    }

    public int getCurrentHeigth() {
        return plane.getHeight();
    }

    public int getStartBGposition() {
        return startBGposition;
    }

    public int setStartBGposition(int startBGposition) {
        this.startBGposition = startBGposition;
        return this.startBGposition;
    }

    private class CoordinatesSetter implements Runnable {

//        speed = 0 positionBG = 0;
//        speed = 1000 bositionBG = 400;
//        koef = 400/1000 = 0,4;

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.currentThread().sleep(100);
                    lookSpeed();
                    if (!plane.isHasFuel()) paday();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        private void paday() {
            plane.speedLow(2);
        }

        private void lookSpeed() {
            if (plane.getSpeed() <= 300) {
                heigthLow();
            }
        }
    }

}
