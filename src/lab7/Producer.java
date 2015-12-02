package lab7;

/**
 * User: huyti
 * Date: 19.11.2015
 */
public class Producer implements Runnable {

    private ListController controller;

    public Producer(ListController controller) {
        this.controller = controller;

    }

    void addChislo() throws InterruptedException {
        controller.put();
        controller.log("producer added " + controller.getChislo());
    }


    @Override
    public void run() {
        while (true) {
            try {
                addChislo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
