package locking;

import java.util.concurrent.locks.ReentrantLock;

public class TxnExample {
  private static int[] data = {0, 0};

  public static void main(String[] args) {
    ReentrantLock lock = new ReentrantLock();

    Runnable writer = () -> {
      for (int i = 0; ; i++) {
        lock.lock();
        try {
          data[0] = i;
          data[1] = i;
        } finally {
          lock.unlock();
        }
      }
    };
    Runnable reader = () -> {
      int x = 0;
      int y = 0;

      while (true) {
        lock.lock();
        try {
          x = data[0];
          y = data[1];
        } finally {
          lock.unlock();
        }
        if (x != y) System.out.print("!");
      }
    };
    new Thread(reader).start();
    new Thread(writer).start();
    System.out.println("Tasks started");
  }
}
