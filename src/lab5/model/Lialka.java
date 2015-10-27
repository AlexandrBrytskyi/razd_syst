package lab5.model;

import java.io.Serializable;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: huyti
 * Date: 27.09.15
 * Time: 18:34
 * To change this template use File | Settings | File Templates.
 */
public class Lialka extends Igrushka   {
    private int razmer;


    public Lialka(String name, int price, MyEntry  ageOgr, int razmer) {
        super(name, price, ageOgr);
        this.razmer = razmer;
    }

    public int getRazmer() {
        return razmer;
    }

    @Override
    public String toString() {
        return super.toString() +
                "razmer=" + razmer +" cm" +
                ' ';
    }
}
