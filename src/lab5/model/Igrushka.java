package lab5.model;

import java.io.Serializable;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: huyti
 * Date: 27.09.15
 * Time: 18:29
 * To change this template use File | Settings | File Templates.
 */
public abstract class Igrushka implements Serializable {

    private String name;
    private int price;
    private MyEntry ageOgr;

    public Igrushka(String name, int price, MyEntry ageOgr) {
        this.name = name;
        this.price = price;
        this.ageOgr = ageOgr;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Map.Entry<Integer, Integer> getAgeOgr() {
        return ageOgr;
    }

    @Override
    public String toString() {
        return "Igrushka " +
                "name='" + name + '\'' +
                ", price=" + (price/100) + "grn " + (price % 100) + "kop" +
                ", ageOgr from " + ageOgr.getKey() + " to " + ageOgr.getValue() + " years " +
                ' ';
    }
}
