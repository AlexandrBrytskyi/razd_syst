package lab7;

/**
 * User: huyti
 * Date: 19.11.2015
 */
public class Consumer implements Runnable {

    private ListController controller;

    public Consumer(ListController controller) {
        this.controller = controller;
    }

    void countSum() throws InterruptedException {
        controller.findSum();
        controller.log("consumer get " + controller.getChislo() + ", summa = " + controller.getSum());
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {
                countSum();
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }
}
