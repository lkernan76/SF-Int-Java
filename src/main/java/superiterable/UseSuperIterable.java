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

    System.out.println(List.of("Fred", "Jim"));

    System.out.println("--------- all students");
    listRoster.stream()
        .forEach(s -> System.out.println(s));

    System.out.println("--------- names of all students");
    listRoster.stream()
        .map(s -> s.getName())
        .forEach(s -> System.out.println(s));

    System.out.println("--------- name takes n courses for all students");
    listRoster.stream()
        .map(s -> s.getName() + " takes " + s.getCourses().size() + " courses")
        .forEach(s -> System.out.println(s));

    System.out.println("--------- name takes n courses for all smart students");
    listRoster.stream()
        .filter(s -> s.getGpa() > 3)
        .map(s -> s.getName() + " takes " + s.getCourses().size() + " courses")
        .forEach(s -> System.out.println(s));

    System.out.println("--------- name takes [course list] for all students");
    listRoster.stream()
        .map(s -> s.getName() + " takes " + s.getCourses())
        .forEach(s -> System.out.println(s));

    System.out.println("--------- all courses");
    listRoster.stream()
        .flatMap(s -> s.getCourses().stream())
        .forEach(s -> System.out.println(s));

    System.out.println("--------- all courses alphabetical");
    listRoster.stream()
        .flatMap(s -> s.getCourses().stream())
        .sorted()
        .forEach(s -> System.out.println(s));

    System.out.println("--------- all courses alphabetical without dups");
    listRoster.stream()
        .flatMap(s -> s.getCourses().stream())
        .distinct()
        .sorted()
        .forEach(s -> System.out.println(s));

    System.out.println("--------- all name-course pairs");
    listRoster.stream()
        // before, we only have three items
        .flatMap(s ->
          s.getCourses().stream()
              .map(c -> s.getName() + " takes " + c)
//              .map(st -> st.toUpperCase())
        )
        //??? here we have no more Student, so no name availble?
        // also, have lost the student boundaries
        .forEach(s -> System.out.println(s));
  }
}
