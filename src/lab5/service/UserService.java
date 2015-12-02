package lab5.service;

import lab5.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: huyti
 * Date: 27.09.15
 * Time: 19:13
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {


    List<Igrushka> showAll();

    void addIgrushka(Igrushka igrushka) throws IOException;

    ArrayList<Konstruktor> showKonstruktors();

    ArrayList<Ball> showBalls();

    ArrayList<Lialka> showLialka();

    ArrayList<Cubes> showCubes();

    void remove(Igrushka igrushka) throws IOException;

}
