package lab5.db;


import razd_syst.lab5.model.Igrushka;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * Created with IntelliJ IDEA.
 * User: huyti
 * Date: 27.09.15
 * Time: 19:30
 * To change this template use File | Settings | File Templates.
 */
public class DB {

    private File file;
    private String filePath;
    private LinkedList<Igrushka> set;

    public DB(String filePath) throws ClassNotFoundException {
        this.filePath = filePath;
        this.file = controlPath(this.filePath);
        try {
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file));
            set = (LinkedList<Igrushka>) reader.readObject();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            set = new LinkedList<Igrushka>();
        }
    }

    private File controlPath(String filePath) {
        File res = new File(filePath);
        if (!res.exists()) try {
            res.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void add(Igrushka igrushka) throws IOException {
        set.add(igrushka);
        update();
    }

    public void delete(Igrushka igrushka) throws IOException {
        set.remove(igrushka);
        update();
    }

    public ArrayList<Igrushka> getAll() {
        return new ArrayList<Igrushka>(set);
    }

    public void update() throws IOException {
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file));
        writer.writeObject(set);
        writer.close();
    }


}
