package threadissues;

public class Stopper {
  private static volatile boolean stop = false;

  public static void main(String[] args) throws InterruptedException {
    Runnable stopper = () -> {
      System.out.println(Thread.currentThread().getName()
          + " stopper starting");
      while (!stop)
        /*System.out.print(".");*/; // testing isn't good enough!
      System.out.println(Thread.currentThread().getName()
          + " stopper stopping");
    };
    Thread t = new Thread(stopper);
    t.start();
    System.out.println(Thread.currentThread().getName()
        + " launched the stopper");
    Thread.sleep(1_000);
    System.out.println(Thread.currentThread().getName()
        + " about to set stop flag");
    stop = true;
    System.out.println(Thread.currentThread().getName()
        + " exiting main method");
  }
}
