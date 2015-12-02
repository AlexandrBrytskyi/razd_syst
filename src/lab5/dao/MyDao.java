package lab5.dao;

import lab5.db.DB;
import lab5.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: huyti
 * Date: 27.09.15
 * Time: 20:29
 * To change this template use File | Settings | File Templates.
 */
public class MyDao implements DAO {

    private DB db;
    String filePath;

    public MyDao(String filePath) throws IOException, ClassNotFoundException {
        db = new DB(filePath);
    }


    @Override
    public void addNew(Igrushka igrushka) throws IOException {
        db.add(igrushka);
    }

    @Override
    public ArrayList<Igrushka> showAll() {
        return db.getAll();
    }

    @Override
    public ArrayList<Konstruktor> showKonstruktors() {
        ArrayList<Igrushka> igrushkas = db.getAll();
        TreeSet<Konstruktor> konstruktorss = new TreeSet<Konstruktor>(new myComparator());
        for (int i = 0; i < igrushkas.size(); i++) {
            if (igrushkas.get(i) instanceof Konstruktor) konstruktorss.add((Konstruktor) igrushkas.get(i));
        }
        ArrayList<Konstruktor> konstruktors = new ArrayList<Konstruktor>(konstruktorss);
        return konstruktors;

    }

    @Override
    public ArrayList<Ball> showBalls() {
        ArrayList<Igrushka> igrushkas = db.getAll();
        TreeSet<Ball> konstruktorss = new TreeSet<Ball>(new myComparator());
        for (int i = 0; i < igrushkas.size(); i++) {
            if (igrushkas.get(i) instanceof Ball) konstruktorss.add((Ball) igrushkas.get(i));
        }
        ArrayList<Ball> konstruktors = new ArrayList<Ball>(konstruktorss);
        return konstruktors;
    }

    @Override
    public ArrayList<Lialka> showLialka() {
        ArrayList<Igrushka> igrushkas = db.getAll();
        TreeSet<Lialka> konstruktorss = new TreeSet<Lialka>(new myComparator());
        for (int i = 0; i < igrushkas.size(); i++) {
            if (igrushkas.get(i) instanceof Lialka) konstruktorss.add((Lialka) igrushkas.get(i));
        }
        ArrayList<Lialka> konstruktors = new ArrayList<Lialka>(konstruktorss);
        return konstruktors;
    }

    @Override
    public ArrayList<Cubes> showCubes() {
        ArrayList<Igrushka> igrushkas = db.getAll();
        TreeSet<Cubes> konstruktorss = new TreeSet<Cubes>(new myComparator());
        for (int i = 0; i < igrushkas.size(); i++) {
            if (igrushkas.get(i) instanceof Cubes) konstruktorss.add((Cubes) igrushkas.get(i));
        }
        ArrayList<Cubes> konstruktors = new ArrayList<Cubes>(konstruktorss);
        return konstruktors;
    }

    @Override
    public void remove(Igrushka igrushka) throws IOException {
        db.delete(igrushka);
    }

    private class myComparator implements Comparator<Igrushka> {

        @Override

        public int compare(Igrushka o1, Igrushka o2) {
            if (!(o1 instanceof Konstruktor)) {
                return -1;
            } else {
                if (o1.getPrice() < o2.getPrice()) return -1;

            }
            return 1;
        }

    }
}
