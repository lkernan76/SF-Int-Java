package statefulstream;

import java.util.List;
import java.util.stream.Stream;

/* fancy "math" names to be aware of
 - data structure/access thing which has a "map" method
   (and conforms to some math rules) -- called "Functor"
 - data structure/access thing which has a "flatMap" method
   (and conforms to some math rules) -- called "Monad"
 - group of [ data type, an associative binary operation on
   that data type, and an identity value of that type for that
   operation ] -- "Monoid"
 */

public class Ex {
  public static void main(String[] args) {
    List<String> names = List.of("Fred", "Jim", "Sheila");
    Stream<String> ss = names.stream();
    ss.forEach(s -> System.out.println("Hello " + s));
    System.out.println("all printed");
    // fails!! this stream's "state" is "at the end"
    ss.forEach(s -> System.out.println("Hello " + s));
  }
}
