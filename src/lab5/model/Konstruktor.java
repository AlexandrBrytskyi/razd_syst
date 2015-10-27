package lab5.model;

import java.io.Serializable;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: huyti
 * Date: 27.09.15
 * Time: 18:41
 * To change this template use File | Settings | File Templates.
 */
public class Konstruktor extends Igrushka {
    private int kstKonstrukziy;

    public Konstruktor(String name, int price, MyEntry  ageOgr, int kstKonstrukziy) {
        super(name, price, ageOgr);
        this.kstKonstrukziy = kstKonstrukziy;
    }

    public int getKstKonstrukziy() {
        return kstKonstrukziy;
    }

    @Override
    public String toString() {
        return super.toString() +
                "kstKonstrukziy=" + kstKonstrukziy + " shtuk" +
                ' ';
    }
}
