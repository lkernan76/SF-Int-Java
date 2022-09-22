package students;

import java.util.ArrayList;
import java.util.List;

interface CriterionOfStudent {
  boolean test(Student s);
}
// ... an object BECAUSE OF the behavior it contains
// if you want something to vary at runtime, it must be a variable
// foundational to several of "Gang of Four" Design patterns.
class SmartStudentCriterion implements CriterionOfStudent {
  private double threshold;
  public SmartStudentCriterion(double threshold) {
    this.threshold = threshold;
  }
  @Override
  public boolean test(Student s) {
    return s.getGpa() > threshold;
  }
}

class EnthusiasticStudentCriterion implements CriterionOfStudent {
  @Override
  public boolean test(Student s) {
    return s.getCourses().size() > 2;
  }
}

public class School {
  public static void showAllStudents(List<Student> roster) {
    // AVOID THIS FORM OF LOOP for anything "Iterable" or array
//    for (int i = 0; i < roster.size(); i++) {
//
//    }

    for (Student s : roster) {
      System.out.println("> " + s);
    }
    System.out.println("--------------------");
  }

//  public static void setThreshold(double threshold) {
//    School.threshold = threshold;
//  }
//  private static double threshold = 3.0;

  // if the "behavioral object" is stored for later use...
  // GoF refers to this as the Strategy pattern
//  private static CriterionOfStudent crit = new SmartStudentCriterion(3.5);

  // A method that takes an argument that is present FOR ITS BEHAVIOR
  // GoF calls this a "Command" Pattern
  // In FP, it's simply one variant of a "Higher Order Function"
//  public static void showStudentsByCriterion(
//      List<Student> roster, CriterionOfStudent crit) {
////      List<Student> roster) {
//    for (Student s : roster) {
//      if (crit.test(s)) {
//        System.out.println("> " + s);
//      }
//    }
//    System.out.println("--------------------");
//  }

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

//  public static void showAllSmartStudents(
//      List<Student> roster, double threshold) {
////      List<Student> roster) {
//    for (Student s : roster) {
//      if (s.getGpa() > threshold) {
//        System.out.println("> " + s);
//      }
//    }
//    System.out.println("--------------------");
//  }
//
//  public static void showAllEnthusiasticStudents(
//      List<Student> roster, int threshold) {
//    for (Student s : roster) {
//      if (s.getCourses().size() > threshold) {
//        System.out.println("> " + s);
//      }
//    }
//    System.out.println("--------------------");
//  }
//
  public static void main(String[] args) {
//    Student s = Student.of("Fred", 3.2, new String[]{"Math", "Physics"});
//    Student s = Student.of("Fred", 3.2, "Math", "Physics");

    List<Student> roster = List.of(
        Student.of("Fred", 3.2, "Math", "Physics"),
        Student.of("Jim", 2.2, "Journalism"),
        Student.of("Sheila", 3.8,
            "Math", "Physics", "Astrophysics", "Quantum Mechanics")
    );
    showAllStudents(roster);
//    showAllSmartStudents(roster, 3.2);
//    showAllSmartStudents(roster, 2.0);
//    showAllEnthusiasticStudents(roster, 2);
//    showAllSmartStudents(roster);
//    School.threshold = 2.0;
//    showAllSmartStudents(roster);

//    showStudentsByCriterion(roster, new SmartStudentCriterion(3.0));
//    showStudentsByCriterion(roster, new SmartStudentCriterion(2.0));
//    showStudentsByCriterion(roster, new EnthusiasticStudentCriterion());

    showAllStudents(selectStudentsByCriterion(
        roster, new SmartStudentCriterion(3.0)));
    showAllStudents(selectStudentsByCriterion(
        roster, new SmartStudentCriterion(2.0)));
    showAllStudents(selectStudentsByCriterion(
        roster, new EnthusiasticStudentCriterion()));

//    showAllStudents(selectStudentsByCriterion(
//        // anonymous inner class can:
//        // - be a child of a class
//        // - implement multiple methods
//        // - has a "this" of its own
//        roster, new CriterionOfStudent() {
//      @Override
//      public boolean test(Student s) {
//        return s.getCourses().size() < 3;
//      }
//    }));
//    showAllStudents(selectStudentsByCriterion(roster,
//        // context here demands an instance of CriterionOfStudent
//        // and, CriterionOfStudent is an interface (cannot need constructor args)
//        // and, CriterionOfStudent has exactly ONE abstract method
//        // and, that's the only method we want to implement
//        // so, compiler knows that the "missing piece" must be
//        // the test method.. which must take a Student and return boolean
///*        new CriterionOfStudent() {
//      @Override
//      public boolean test*/(Student s) -> {
//        return s.getCourses().size() < 3;
//      }
//    /*}*/));
    CriterionOfStudent unenthusiastic = s -> s.getCourses().size() < 3;
    showAllStudents(selectStudentsByCriterion(roster,
//      (Student s) -> { return s.getCourses().size() < 3;}
//      (s) -> { return s.getCourses().size() < 3;}
//      s -> { return s.getCourses().size() < 3;}
      unenthusiastic
    ));
  }
}
