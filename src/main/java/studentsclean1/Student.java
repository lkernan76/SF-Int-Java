package studentsclean1;

import java.util.*;

public class Student {
  private String name;
  private double gpa;
  private Set<String> courses;

  private Student(String name, double gpa, Set<String> courses) {
    if (!isValid(name, gpa, courses)) {
      throw new IllegalArgumentException("Bad!");
    }
    this.name = name;
    this.gpa = gpa;
    this.courses = courses;
  }

  public static Student ofParentNameAndMoney(
      String parentName, double donationAmount, Set<String> courses) {
    return null;
  }

  public static Student of(String name, double gpa, String... courses) {
    return new Student(name, gpa, Set.of(courses));
  }

  public static boolean isValid(String name, double gpa, Set<String> courses) {
    return name != null && courses != null && gpa >= 0 && gpa <= 5.0;
  }

  public String getName() {
    return name;
  }

  public double getGpa() {
    return gpa;
  }

  public Set<String> getCourses() {
    return courses;
  }

  // cheat this for primitives by using an array of a single primitive
  public static CriterionOfStudent getSmartCriterion(/*final*/ double threshold) {
    // "closure" -- java takes a copy, which must not be altered/mutate
//    threshold++;
    return s -> s.gpa > threshold;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", gpa=" + gpa +
        ", courses=" + courses +
        '}';
  }
}
