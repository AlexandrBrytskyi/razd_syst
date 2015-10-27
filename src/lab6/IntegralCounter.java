package lab6;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//
//Створити клас “Обчислювач інтегралів”, який може працювати у багатопотоковому режимі
//        і має метод “обчислити” з параметрами: a, b - кінці інтервалу, n - кількість кроків та f -
//        підинтегральна функція.
public class IntegralCounter {

    Function pidintegFunc;
    double a;
    double b;
    int n;
    int kstOfThreads;
    List<double[]> intervals = new ArrayList<>();
    List<Double> results = Collections.synchronizedList(new LinkedList<>());
    List<Thread> threads = new LinkedList<>();

    public IntegralCounter(double a, double b, int n, int kstOfThreads) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.kstOfThreads = kstOfThreads;
        this.pidintegFunc = new Function();
    }

    public double count() {
        double h = (b - a) / n;
        createIntervals(a, b, n, kstOfThreads);
        for (int i = 0; i < kstOfThreads; i++) {
            Thread thread = new Thread(new Counter(pidintegFunc, intervals.get(i), h));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        double threadsRes = 0;
        for (Double result : results) {
            threadsRes += result;
        }

        return (pidintegFunc.count(a) + pidintegFunc.count(b)) / 2 * h + threadsRes;
    }

    private void createIntervals(double a, double b, int n, int kstOfThreads) {
        double h = (b - a) / n;  //krok
        int size = n / kstOfThreads;
        for (int i = 0; i < kstOfThreads; i++) {
            double[] res = new double[size];
            for (int j = 0; j < res.length; j++) {
                res[j] = a + j * h;
//                System.out.println("x = " + res[j]);
            }
//            System.out.println();
            a = res[res.length - 1] + h;
            intervals.add(res);
        }
    }

    private class Counter implements Runnable {
        Function pidintFunc;
        double[] interval;
        double result = 0;
        double h;

        public Counter(Function pidintFunc, double[] interval, double h) {
            this.pidintFunc = pidintFunc;
            this.interval = interval;
            this.h = h;
        }


        @Override
        public void run() {
            for (double v : interval) {
                result += pidintFunc.count(v) * h;
            }
            results.add(result);
        }
    }
}
