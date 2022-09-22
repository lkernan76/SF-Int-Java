package superiterable;

import java.util.ArrayList;
import java.util.List;
import studentsgeneric.Student;

public class UseSuperIterable {
  public static void main(String[] args) {
    SuperIterable<String> sis = new SuperIterable<>(List.of(
        "Fred", "Jim", "Sheila", "Alice", "Bob"
    ));

//    for (String s : sis) {
//      System.out.println("> " + s);
//    }

    sis
        .filter(s -> s.length() > 4)
//        .map(s -> s.toUpperCase())
        .map(s -> s.length())
        .forEach(s -> System.out.println("> " + s));

    System.out.println("-------------------------");
    List<Student> listRoster = List.of(
        Student.of("Fred", 3.2, "Math", "Physics"),
        Student.of("Jim", 2.2, "Journalism"),
        Student.of("Sheila", 3.8,
            "Math", "Physics", "Astrophysics", "Quantum Mechanics")
    );
    SuperIterable<Student> roster = new SuperIterable<>(listRoster);

    roster
        .flatMap(s -> new SuperIterable<>(s.getCourses()))
        .forEach(ls -> System.out.println(ls));

    System.out.println("----------------------");
//    listRoster.stream()
//        ... do stuff here
  }
}
