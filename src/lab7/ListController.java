package lab7;

import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
/**
 * User: huyti
 * Date: 19.11.2015
 */
public class ListController {

    Logger LOG = Logger.getLogger(ListController.class);

    private List<Integer> chisla = new LinkedList<Integer>();
    private int sum = 0;
    private int chislo = -1;
    private boolean puttable = true;

    public ListController() {
        try {
            LOG.addAppender(new FileAppender(new HTMLLayout(),"producer-consumerLOG.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void put() throws InterruptedException {
        while (puttable != true) {
            wait();
        }

        chislo++;
        chisla.add(chislo);
        puttable = false;
        notifyAll();
    }

    public synchronized void findSum() throws InterruptedException {
        while (puttable!=false) {
            wait();
        }

        sum += chisla.get(chisla.size() - 1);
        puttable = true;
        notifyAll();
    }

    public void log(String message) {
        LOG.info(message);
    }

    public void setSum(int sum) {

        this.sum = sum;
        notifyAll();
    }

    public void setChislo(int chislo) {
        this.chislo = chislo;
    }

    public int getSum() {
        return sum;
    }

    public int getChislo() {
        return chislo;
    }
}
