package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
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
        System.out.println("pi: " + pi);
    }

    public static String calculate(int floatingPoint)
    {
        pi = new BigDecimal(3);
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        for (int i = 0; i <= 100; i++) {
            piCal task = new piCal((i * 1000) + 1);          // accuracy, try 200 and see the difference!
            threadPool.execute(task);
        }
        threadPool.shutdown();
        pi = pi.setScale(floatingPoint, RoundingMode.HALF_DOWN);
        return pi.toString();
    }

    public static void main(String[] args) {
        System.out.println(calculate(10));
//        System.out.println("3.14159265358979323846264338327950288419716939937510582097494459230781640628620899862803482534211706798214808651328230664709384460955058223172535940812848111745028410270193852110555964462294895493038196442881097566593344612847564823378678316527120190914564856692346034861045432664821339360726024914127372458700660631558817488152092096282925409171536436" +
//                "  7892590360 0113305305 4882046652 1384146951 9415116094" +
//                "  3305727036 5759591953 0921861173 819326117");
    }
}
