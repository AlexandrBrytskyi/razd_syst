package lab5.model;

import razd_syst.lab5.service.UserServ;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: huyti
 * Date: 27.09.15
 * Time: 18:42
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Igrushka ball = new Ball("Ball", 200070, new MyEntry(0, 100), 150);
//        Igrushka lialka = new Lialka("Lialka", 5000040, new MyEntry(3, 5), 50);
//        Igrushka konstruktor = new Konstruktor("Konstruktor", 80058, new MyEntry(7, 10), 10);
//
//        System.out.println(ball.toString());
//        System.out.println(lialka.toString());
//        System.out.println(konstruktor.toString());

        UserServ service = new UserServ("D:/igrushki.txt");
//        service.addIgrushka(new Ball("Ball", 200070, new MyEntry(0, 100), 150));
//        service.addIgrushka(new Konstruktor("Konstruktor", 80058, new MyEntry(7, 10), 10));
//        service.addIgrushka(new Lialka("Lialka", 5000040, new MyEntry(3, 5), 50));
//        service.addIgrushka(new Konstruktor("Konstruktor", 8078, new MyEntry(7, 10), 10));
//        service.addIgrushka(new Lialka("Lialka", 5000, new MyEntry(3, 5), 50));
//        service.addIgrushka(new Ball("Ball", 200470, new MyEntry(0, 100), 150));
//        service.addIgrushka(new Konstruktor("Konstruktor", 70058, new MyEntry(7, 10), 10));
        System.out.println(service.showAll().toString());
        System.out.println();
        System.out.println(service.showKonstruktors());
    }
}
