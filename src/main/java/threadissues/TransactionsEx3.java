package threadissues;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class TransactionsEx3 {
  private static LongAdder ai = new LongAdder();

  public static void main(String[] args) throws InterruptedException {
    Runnable incrementer = () -> {
      for (int i = 0; i < 1_000_000_000; i++) {
        ai.increment();
      }
    };

    long start = System.nanoTime();
    System.out.println("Count is " + ai.longValue());
//    incrementer.run();
//    incrementer.run();
    Thread t1 = new Thread(incrementer);
    t1.start();
    Thread t2 = new Thread(incrementer);
    t2.start();
    t1.join(); // wait until t1 has completed/died
    t2.join();
    System.out.println("Count is " + ai.longValue());
    long time = System.nanoTime() - start;
    System.out.println("time was " + (time / 1_000_000_000.0));
  }
}
