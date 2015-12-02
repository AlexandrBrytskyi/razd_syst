package lab7;

/**
 * User: huyti
 * Date: 19.11.2015
 */
public class Test{

    public static void main(String[] args) throws InterruptedException {
        ListController controller = new ListController();

        Thread producerThread = new Thread(new Producer(controller));
        Thread consumerThread = new Thread(new Consumer(controller));

        producerThread.start();
        consumerThread.start();


    }
}
