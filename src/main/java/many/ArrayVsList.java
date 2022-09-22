package many;

import java.util.ArrayList;
import java.util.List;

public class ArrayVsList {
  public static void main(String[] args) {
    String [] names = {"Fred", "Jim", null, null};
    String [] anotherCopyOfNames = names;
    int count = 2;
    int limit = 4;
    names[2] = "Alice"; count++;
    names[3] = "Bob"; count++;

    String [] moreNames = new String[6];
    System.arraycopy(names, 0, moreNames, 0, limit);
    names = moreNames;
    limit = 6;

    System.out.println("fourth element [3] is " + names[3]);
    names[4] = "Maverick";
    count = 5;

//    System.out.println("anotherCopyOfNames[4] is " + anotherCopyOfNames[4]);

    List<String> lNames = new ArrayList<>();
    List<String> lNames2 = lNames;
    lNames.add("Fred");
    lNames.add("Jim");
    lNames.add("Alice");
    lNames.add("Bob");
    lNames.add("Maverick");

    System.out.println(lNames2.get(4));
  }
}
