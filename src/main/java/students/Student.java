package students;

import java.util.*;

public class Student {
  // private is "anywhere within the TOP LEVEL curlies"
  // i.e. nested/inner classes share FULL access to and from
  // the enclosing class AND with SIBLING classes
//  class XXX {
//    private String stuff;
//  }
//  // actual constant x
//  // final -- cannot change the value of the variable
//  final int x = 99;
//  // constant, because cannot reassign st to refer to a
//  // different string object AND String is immutable
//  final String st = "hello";
//  // NOT a constant, StringBuilder is mutable
//  final StringBuilder sb = new StringBuilder("Hello");
  private String name;
  private double gpa;
  // avoid arrays until/unless you know you must have ultimate
  // performance; fixed length once created, which is a nuisance
  // use either a List, or perhaps a Set--these are interfaces
  // need concrete implementation
  // Note that Set implementations place requirements on the
  // types to be added to them (either equals/hashCode for HashSet
  // or "ordering" for TreeSet). Fail in this requirement and you
  // will lose stuff!!
  private Set<String> courses;

  // constructors should be private, provide factories and/or builders instead
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
//  public static Student of(String name, double gpa, String[] courses) {
//    if (student is in the pool of immutable student objects)
//      return that student
//    if (student) is special) return new SpecialStudent(...)
//    else
    return new Student(name, gpa, Set.of(courses));
//    return new Student(name, gpa, new HashSet<>(java.util.List.of(courses)));
//    return new Student(name, gpa, new HashSet<>(Arrays.asList(courses)));
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
//    return Collections.unmodifiableSet(courses);

//    return courses.clone(); // not always available, usually shallow copy!
    // otherwise perhaps make our own "defensive copy"

    // in this case, this is OK, because Set.of(immutable type) is immutable
    return courses;
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
