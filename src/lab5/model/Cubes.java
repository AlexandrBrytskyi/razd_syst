package lab5.model;

import java.io.Serializable;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: huyti
 * Date: 27.09.15
 * Time: 18:36
 * To change this template use File | Settings | File Templates.
 */
public class Cubes extends Igrushka {
    private int kst;

    public Cubes(String name, int price, MyEntry ageOgr, int kst) {
        super(name, price, ageOgr);
        this.kst = kst;
    }

    public int getKst() {
        return kst;
    }

    @Override
    public String toString() {
        return super.toString() +
                "kst=" + kst + " shtuk" +
                ' ';
    }
}
