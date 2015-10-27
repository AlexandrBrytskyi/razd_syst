package lab6;

/**
 * User: huyti
 * Date: 24.10.2015
 */
public class IntegralCounterController {

    IntegralCounter integralCounter;
    long time = 0;

    public IntegralCounterController(double a, double b, int n, int threds) {
        this.integralCounter = new IntegralCounter(a, b, n, threds);
    }


    public double count() {
        long startTime = 0;
        double res = 0;
        startTime = System.currentTimeMillis();
        res = integralCounter.count();
        time = System.currentTimeMillis() - startTime;
        return res;
    }

    public String getTime() {
        return String.valueOf(time);
    }
}
