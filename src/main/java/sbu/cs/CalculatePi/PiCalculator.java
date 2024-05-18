package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PiCalculator {
    public static BigDecimal pi;
    public static class piCal implements Runnable {
        int i;
        MathContext mc = new MathContext(1000);

        public piCal(int i) {
            this.i = i;
        }

        public void run() {
            BigDecimal x = new BigDecimal(1);
            BigDecimal y = new BigDecimal(1);
            for (int j = 1; j < i; j++) {
                x = x.multiply(new BigDecimal(2 * j - 1));
                y = y.multiply(new BigDecimal(2 * j));
                y = y.multiply(new BigDecimal(4));
            }
            for (int ii = i; ii < (i + 1000); ii++) {
                x = x.multiply(new BigDecimal(2 * ii - 1));
                y = y.multiply(new BigDecimal(2 * ii));
                y = y.multiply(new BigDecimal(4));

                BigDecimal save = new BigDecimal(3);
                BigDecimal yy = y;
                yy = yy.multiply(new BigDecimal(2 * ii + 1), mc);

                BigDecimal jadid = x;
                jadid = jadid.divide(yy, mc);
                save = save.multiply(jadid, mc);
                addToPi(save);
            }
        }
    }


    public static synchronized void addToPi(BigDecimal value){
        pi = pi.add(value);
    }

    public static String calculate(int floatingPoint)
    {
        pi = new BigDecimal(3);

//        ExecutorService threadPool = Executors.newFixedThreadPool(4);
//
//        for (int i = 0; i <= 10; i++) {
//            piCal task = new piCal((i * 1000) + 1);          // accuracy, try 200 and see the difference!
//            threadPool.execute(task);
//        }
//
//        threadPool.shutdown();

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            piCal pc = new piCal(i * 1000 + 1);
            Thread thread = new Thread(pc);
            threadList.add(thread);
            thread.start();
        }
        for (Thread i: threadList) {
            try {
                i.join();
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        return pi.toString().substring(0, floatingPoint + 2);
    }

    public static void main(String[] args) {
    }
}
