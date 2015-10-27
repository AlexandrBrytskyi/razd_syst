package lab5.model;

import java.io.Serializable;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: huyti
 * Date: 27.09.15
 * Time: 18:39
 * To change this template use File | Settings | File Templates.
 */
public class Ball extends Igrushka{
    private int vaga;

    public Ball(String name, int price, MyEntry ageOgr, int vaga) {
        super(name, price, ageOgr);
        this.vaga = vaga;
    }

    public int getVaga() {
        return vaga;
    }

    @Override
    public String toString() {
        return super.toString() +
                "vaga=" + vaga + " gram" +
                ' ';
    }
}
