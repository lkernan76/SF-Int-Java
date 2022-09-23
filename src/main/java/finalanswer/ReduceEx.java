package finalanswer;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

class Average {
  private double sum;
  private long count;

  public Average(double sum, long count) {
    this.sum = sum;
    this.count = count;
  }

  public Average merge(Average other) {
    return new Average(this.sum + other.sum, this.count + other.count);
  }

  public OptionalDouble get() {
    if (count > 0) {
      return OptionalDouble.of(sum / count);
    } else {
      return OptionalDouble.empty();
    }
  }
}

public class ReduceEx {
  public static void main(String[] args) {
    int result = IntStream.rangeClosed(1, 10)
        .reduce(0, (a, b) -> a + b);
    System.out.println("sum is " + result);

    OptionalInt oi = IntStream.rangeClosed(1, 10)
        .reduce((a, b) -> a + b);
    oi.ifPresent(s -> System.out.println("Sum is " + s));

    ThreadLocalRandom.current().doubles(100_000_000, -1, +1)
        .mapToObj(v -> new Average(v, 1))
//        .reduce(new Average(0, 0), (a1, a2) -> a1.merge(a2))
        .reduce(new Average(0, 0), Average::merge)
        .get().ifPresent(a -> System.out.println("Average is " + a));
  }
}
