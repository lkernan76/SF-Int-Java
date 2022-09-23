package prodcons;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProdCons {
  public static void main(String[] args) {
    BlockingQueue<int[]> queue = new ArrayBlockingQueue<>(10);
    final int ITEM_COUNT = 10_000;
    Runnable producer = () -> {
      System.out.println("Producer starting");
      try {
        for (int i = 0; i < ITEM_COUNT; i++) {
          int[] data = {0, i};
          if (i < 500) {
            Thread.sleep(1);
          }
          data[0] = i; // now transactionally sound
          if (i == ITEM_COUNT / 2) {
            data[0] = -1; // test the test
          }
          queue.put(data); data = null;
        }
      } catch (InterruptedException ie) {
        System.out.println("Interesting? Someone asked me to shut down");
      }
      System.out.println("Producer ending");
    };

    Runnable consumer = () -> {
      System.out.println("Consumer starting");
      try {
        for (int i = 0; i < ITEM_COUNT; i++) {
          int [] data = queue.take();
          if (data[0] != data[1] || data[0] != i) {
            System.out.println("Problem at index " + i
                + " data is " + Arrays.toString(data));
          }
          if (i > ITEM_COUNT - 500) {
            Thread.sleep(1);
          }
        }
      } catch(InterruptedException ie) {
        System.out.println("Strange, someone requested shutdown of consumer");
      }
      System.out.println("Consumer ending");
    };

    new Thread(producer).start();
    new Thread(consumer).start();
    System.out.println("Threads started...");
  }
}
