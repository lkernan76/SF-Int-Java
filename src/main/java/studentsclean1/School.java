package studentsclean1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

interface CriterionOfStudent {
  boolean test(Student s);
  static CriterionOfStudent negate(CriterionOfStudent crit) {
    return s -> !crit.test(s);
  }
}

interface UseAStudent {
  void accept(Student s);
}

public class School {
  public static void showAllStudents(List<Student> roster) {
    for (Student s : roster) {
      System.out.println("> " + s);
    }
    System.out.println("--------------------");
  }

  public static void useAllStudents(List<Student> roster, UseAStudent op) {
    for (Student s : roster) {
      op.accept(s);
    }
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

//  public static List<Something> selectSomethingByCriterion(
//      List<Something> roster, CriterionOfSomething crit) {
//    List<Something> rv = new ArrayList<>();
//    for (Something s : roster) {
//      if (crit.test(s)) {
//        rv.add(s);
//      }
//    }
//    return rv;
//  }

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

    // lab solutions:
    // smart
    showAllStudents(selectStudentsByCriterion(
        roster, s -> s.getGpa() > 3.0));
    // not smart
    showAllStudents(selectStudentsByCriterion(
        roster, s -> s.getGpa() <= 3.0));
    // first half of alphabet
    showAllStudents(selectStudentsByCriterion(
        roster, s -> s.getName().toUpperCase().charAt(0) <= 'M'));

    showAllStudents(selectStudentsByCriterion(
        roster, s -> s.getName().compareTo("M") < 0));

    // smart but not enthusiastic
    showAllStudents(selectStudentsByCriterion(
        roster, s -> s.getGpa() > 3.0 && s.getCourses().size() < 3
    ));

    // sorting
    // Java 7 and older used Collections.sort(List<X>, Comparator<X>)
    // since Java 8
    // myList.sort(Comparator)
    Comparator<Student> order =
//        (Student s1, Student s2) -> Double.compare(s1.getGpa(), s2.getGpa());
        (s1, s2) -> Double.compare(s1.getGpa(), s2.getGpa());
//        (var s1, var s2) -> Double.compare(s1.getGpa(), s2.getGpa());
    System.out.println("order by grade");
    roster.sort(order);
    System.out.println(roster);
    System.out.println("order by reverse enthusiasm");
    roster.sort((s1, s2) ->
        Integer.compare(s2.getCourses().size(), s1.getCourses().size()));
    System.out.println(roster);


    System.out.println("use student simple print");
    useAllStudents(roster, s -> System.out.println(s));

    System.out.println("use pretty print");
    useAllStudents(roster, s ->
        System.out.println("Student: " + s.getName() + " takes "
            + s.getCourses().size() + " courses and has a grade of "
            + s.getGpa()));

    System.out.println("Smart by built-in criterion");
    CriterionOfStudent crit = Student.getSmartCriterion(3.5);
    CriterionOfStudent opposite = CriterionOfStudent.negate(crit);
    useAllStudents(
        selectStudentsByCriterion(roster, crit),
        s -> System.out.println("smart by own criterion: " + s));
    System.out.println("Not smart by built-in criterion");
    useAllStudents(
        selectStudentsByCriterion(roster, s -> !crit.test(s)),
        s -> System.out.println("smart by own criterion: " + s));
    boolean x = true;
//    boolean y = !crit;
  }
}
