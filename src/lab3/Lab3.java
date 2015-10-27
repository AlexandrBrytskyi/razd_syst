package lab3;

import java.text.Format;
import java.text.NumberFormat;

/**
 * Created with IntelliJ IDEA.
 * User: huyti
 * Date: 26.09.15
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 */
public class Lab3 {
    private double a = 1.5;
    private double xMin = 0.8;
    private double xMax = 2;
    private final double shag = 0.005;
    public double[] masX;
    public double[] masY;


    public double countFunct(double x) {
        if (x < 1.7) return Math.PI * Math.pow(x, 2) - 7 / Math.pow(x, 2);
        if (x > 1.7) return Math.log(x + 7 * Math.sqrt(x));
        return a * Math.pow(x, 3) + 7 * Math.sqrt(x);
    }

    public int findAmountOfshag() {
        return (int) ((xMax - xMin) / shag);
    }

    public double[] generateMasX() {
        masX = new double[findAmountOfshag()];
        double currentX = xMin;
        int i = 0;
        while (i < findAmountOfshag()) {
            masX[i] = currentX;
            currentX += shag;
            i++;
        }
        return masX;
    }

    public double[] generateMasY() {
        masY = new double[masX.length];
        int i = 0;
        while (i < findAmountOfshag()) {
            masY[i] = countFunct(masX[i]);
            i++;
        }
        return masY;
    }

    public int findMinY() {
        int min = 0;
        for (int i = 0; i < masY.length; i++) {
            if (masY[i] < masY[min]) min = i;
        }
        return min;
    }

    public int findMaxY() {
        int max = 0;
        for (int i = 0; i < masY.length; i++) {
            if (masY[i] > masY[max]) max = i;
        }
        return max;
    }

    public double findSumY() {
//        double sum = 0;
//        for (double d : masY) {
//            sum += d;
//        }
        return masY[findMinY()] + masY[findMaxY()];
    }

    public double findAverage() {
        double sum = 0;
        for (double d : masY) {
            if (d < 0) sum += d;
        }
        return sum;
    }


    public void printMass(double[] masX, double[] masY) {

        for (int i = 0; i < masX.length; i++) {
            double x = masX[i];
            NumberFormat formatter = NumberFormat.getNumberInstance();
            String s = formatter.format(x);
            System.out.println("x = " + s + ", y = " + masY[i] + "index = " + i);
        }
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getxMin() {
        return xMin;
    }

    public void setxMin(double xMin) {
        this.xMin = xMin;
    }

    public double getxMax() {
        return xMax;
    }

    public void setxMax(double xMax) {
        this.xMax = xMax;
    }

    public static void main(String[] args) {
        Lab3 l = new Lab3();
        System.out.println("Amount of steps = " + l.findAmountOfshag());
        System.out.println("Generating arrays of x and y");
        double[] masX = l.generateMasX();
        double[] masY = l.generateMasY();
        System.out.println("min index = " + l.findMinY() + ", value = " + masY[l.findMinY()]);
        System.out.println("max index = " + l.findMaxY() + ", value = " + masY[l.findMaxY()]);
        System.out.println("sum y = " + l.findSumY());
        System.out.println("avarage y = " + l.findAverage());
        System.out.println("print all x and y");
        l.printMass(masX, masY);
    }

    public double findSumDodatn() {
        double sum = 0;
        for (double d : masY) {
            if (d > 0) sum += d;
        }
        return sum;
    }
}
