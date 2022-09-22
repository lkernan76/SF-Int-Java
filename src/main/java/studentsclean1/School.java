package studentsclean1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface CriterionOfStudent {
  boolean test(Student s);
}

public class School {
  public static void showAllStudents(List<Student> roster) {
    for (Student s : roster) {
      System.out.println("> " + s);
    }
    System.out.println("--------------------");
  }

  public static List<Student> selectStudentsByCriterion(
      List<Student> roster, CriterionOfStudent crit) {
    List<Student> rv = new ArrayList<>();
    for (Student s : roster) {
      if (crit.test(s)) {
        rv.add(s);
      }
    }
    return rv;
  }

  public static void main(String[] args) {
    List<Student> roster = new ArrayList<>(List.of(
        Student.of("Fred", 3.2, "Math", "Physics"),
        Student.of("Jim", 2.2, "Journalism"),
        Student.of("Sheila", 3.8,
            "Math", "Physics", "Astrophysics", "Quantum Mechanics")
    ));
    showAllStudents(roster);

    showAllStudents(selectStudentsByCriterion(
        roster, s -> s.getCourses().size() < 3
    ));
  }
}
