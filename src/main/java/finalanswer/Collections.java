package finalanswer;

import studentsgeneric.Student;

import java.util.List;
import java.util.stream.Collectors;

public class Collections {
  public static String getLetterGrade(Student s) {
    if (s.getGpa() > 3.5) return "A";
    if (s.getGpa() > 3) return "B";
    return "C";
  }
  public static void main(String[] args) {
    List<Student> listRoster = List.of(
        Student.of("Fred", 3.2, "Math", "Physics"),
        Student.of("Fred1", 3.3, "Math", "Physics"),
        Student.of("Fred2", 3.1, "Math", "Physics"),
        Student.of("Jim", 2.2, "Journalism"),
        Student.of("Jimmy", 2.3, "Journalism"),
        Student.of("James", 2.1, "Journalism"),
        Student.of("Sheila", 3.8,
            "Math", "Physics", "Astrophysics", "Quantum Mechanics")
    );

    var results = listRoster.stream()
//        .collect(Collectors.groupingBy(s -> Collections.getLetterGrade(s)));
        .collect(Collectors.groupingBy(Collections::getLetterGrade));

    results.entrySet().stream()
        .forEach(e -> System.out.println("Students with grade " + e.getKey()
        + " are " + e.getValue()));

    var results2 = listRoster.stream()
        .collect(Collectors.groupingBy(s -> Collections.getLetterGrade(s),
//            Collectors.mapping(s -> s.getName(), Collectors.toList())
//            Collectors.mapping(s -> s.getName(), Collectors.joining(", "))
            Collectors.mapping(Student::getName, Collectors.joining(", "))
        ));
    results2.entrySet().stream()
        .forEach(e -> System.out.println("Students with grade " + e.getKey()
            + " are " + e.getValue()));

    int x;
    int y;

  }
}
