package threadissues;

public class TransactionsEx1 {
  // volatile handles VISIBILITY NOT transactions
  private static volatile long count = 0;

  public static void main(String[] args) throws InterruptedException {
    Runnable incrementer = () -> {
      for (int i = 0; i < 1_000_000_000; i++) {
        count++; // CPU performs: read, increment register, write
      }
    };

    System.out.println("Count is " + count);
//    incrementer.run();
//    incrementer.run();
    Thread t1 = new Thread(incrementer);
    t1.start();
    Thread t2 = new Thread(incrementer);
    t2.start();
//    Thread.sleep(1_000);
    t1.join(); // wait until t1 has completed/died
    t2.join();
    System.out.println("Count is " + count);
  }
}
