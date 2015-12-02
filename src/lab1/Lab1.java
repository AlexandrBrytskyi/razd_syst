package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Brytskyi
 * Date: 16.09.15
 * Time: 10:43
 * To change this template use File | Settings | File Templates.
 */
public class Lab1 {
    double a;
    double b;
    double x;
    double R;
    Double s;


    public Lab1() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a");
        a = Double.parseDouble(reader.readLine());
        System.out.println("Enter b");
        b = Double.parseDouble(reader.readLine());
        System.out.println("Enter x");
        x = Double.parseDouble(reader.readLine());
        countR(x, a, b);
        counts(x, a, b);
        printRez();
        printDate();
    }


    public void countR(double x, double a, double b) {
        R = Math.pow(x, 2) * (x + 1) / b - Math.pow(Math.sin(x + a), 2);
    }

    public void counts(double x, double a, double b) {
        s = Math.sqrt((x * b) / a) + Math.pow(Math.cos(Math.pow(x + b, 3)), 2);
    }

    public void printRez() {
        System.out.println("Vhidni dani:"
                + "\n" + "a = " + a +
                "\n" + "b = " + b +
                "\n" + "x = " + x +
                "\n" + "Results: " +
                "\n" + "R = " + R +
                "\n" + "s = " + s);
    }

    public void printDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-dd");
        Date date = new Date();
        System.out.println(sdf.format(date));
    }

    public static void main(String[] args) throws IOException {
        Lab1 l = new Lab1();
    }


}
