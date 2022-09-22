package equality;

import java.util.HashSet;
import java.util.Set;

public class Hashing {
  public static void main(String[] args) {
    Set<String> names = new HashSet<>();
    String s1 = "Fred";
    names.add(s1);
    names.add("Jim");
    names.add("Alice");
    System.out.println("contains Alice? "
        + names.contains(new String("Alice")));

    Set<StringBuilder> names2 = new HashSet<>();
    StringBuilder sb1 = new StringBuilder("Fred");
    names2.add(sb1);
    names2.add(new StringBuilder("Jim"));
    names2.add(new StringBuilder("Alice"));
    System.out.println("contains Alice? "
        + names2.contains(new StringBuilder("Alice")));
    System.out.println("contains original Fred "
      + names2.contains(sb1));
  }
}
