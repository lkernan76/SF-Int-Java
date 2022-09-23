package parstream;

import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Ex1 {
  private static long counter = 0;
  private static long counter2 = 0;
  public static void main(String[] args) {
    DoubleStream.generate(() -> Math.random())
        .parallel()
        .limit(10_000)
        .map(d -> {
          counter++;
          return d;
        })
        .forEach(d -> System.out.println(d));
    System.out.println("Count is " + counter);


    long c2 = List.of(1,2,3,4,5,6,7,8,9,10).stream()
        .map(d -> {
          counter2++;
          return d;
        })
        .count();
    System.out.println("c2 value is " + c2);
    System.out.println("counter2 value is " + counter2);

  }
}
