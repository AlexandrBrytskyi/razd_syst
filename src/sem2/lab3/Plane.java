package sem2.lab3;

public class Plane {

    private double fuel;
    private int speed;
    private int height;

    private boolean isStaying;
    private boolean isNearZapravka;
    private boolean hasFuel;
    public static final int MAX_FUEL = 5000;
    public static final int MAX_SPEED = 1000;
    public static final int MAX_HEIGHT = 450;

    public Plane() {
        setStaying(true);
        setNearZapravka(true);
        initFlyControl();
    }

    private void initFlyControl() {
        Thread thread = new Thread(new FlyControl());
        thread.start();
    }

    public boolean zapravit() {
        if (isNearZapravka && isStaying) {
            setFuel(MAX_FUEL);
            hasFuel = true;
            return true;
        }
        return false;
    }

    public int speedGrow(int value) {
        if (speed != 0) value += value * speed / 400;
        if (hasFuel)
            if (speed + value <= MAX_SPEED) {
                speed += value;
            } else {
                speed = MAX_SPEED;
            }
        speedChanged();
        return speed;
    }

    public int speedLow(int value) {
        if (speed != 0) value += value * speed / 400;
        if (speed - value >= 0) {
            speed -= value;
        } else {
            speed = 0;
        }
        speedChanged();
        return speed;
    }

    private void speedChanged() {
        setStaying(speed == 0);
    }

    public int heigthGrow(int value) {
        if (height != 0) value += value * speed / 400;
        if (hasFuel)
            if (speed >= 300) {
                if (height + value <= MAX_HEIGHT) {
                    height += value;
                } else {
                    height = MAX_HEIGHT;
                }
            }
        return height;
    }

    public boolean isHasFuel() {
        return hasFuel;
    }

    public int hiegthLow(int value) {
        if (height != 0) value += value * speed / 400;
        if (height - value >= 0) {
            height -= value;
        } else {
            height = 0;
        }
        return height;
    }

    public boolean isStaying() {
        return isStaying;
    }

    public void setStaying(boolean staying) {
        isStaying = staying;
    }

    public boolean isNearZapravka() {
        return isNearZapravka;
    }

    public void setNearZapravka(boolean nearZapravka) {
        isNearZapravka = nearZapravka;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private class FlyControl implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.currentThread().sleep(1000);
                    minusFuel();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void minusFuel() {
            if (fuel - speed / 3 >= 0) {
                fuel -= speed / 3;
            } else {
                fuel = 0;
                hasFuel = false;
            }
        }
    }
}
