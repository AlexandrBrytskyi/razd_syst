package lab5.dao;

import razd_syst.lab5.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: huyti
 * Date: 27.09.15
 * Time: 19:22
 * To change this template use File | Settings | File Templates.
 */
public interface DAO {

    void addNew(Igrushka igrushka) throws IOException;

    ArrayList<Igrushka> showAll();

    ArrayList<Konstruktor> showKonstruktors();

    ArrayList<Ball> showBalls();

    ArrayList<Lialka> showLialka();

    ArrayList<Cubes> showCubes();

    void remove(Igrushka igrushka) throws IOException;

}
