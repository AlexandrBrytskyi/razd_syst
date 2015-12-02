package lab5.service;


import lab5.dao.DAO;
import lab5.dao.MyDao;
import lab5.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: huyti
 * Date: 27.09.15
 * Time: 20:35
 * To change this template use File | Settings | File Templates.
 */
public class UserServ implements UserService {

    private DAO dao;


    public UserServ(String filePath) throws IOException, ClassNotFoundException {
        dao = new MyDao(filePath);
    }

    @Override
    public List<Igrushka> showAll() {
        return dao.showAll();
    }

    @Override
    public void addIgrushka(Igrushka igrushka) throws IOException {
        dao.addNew(igrushka);
    }

    @Override
    public ArrayList<Konstruktor> showKonstruktors() {
        return dao.showKonstruktors();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ArrayList<Ball> showBalls() {
        return dao.showBalls();
    }

    @Override
    public ArrayList<Lialka> showLialka() {
        return dao.showLialka();
    }

    @Override
    public ArrayList<Cubes> showCubes() {
        return dao.showCubes();
    }

    @Override
    public void remove(Igrushka igrushka) throws IOException {
        dao.remove(igrushka);
    }


}
