package poolvsenum;

import java.util.*;

enum ECourse {
  MATH, PHYSICS, CHEMISTRY;
  // fields, constructors, etc. all allowed here
  // constructors MUST be private (and are by default)
}

class PooledCourse {
  private static final Map<String, PooledCourse> COURSE_POOL = new HashMap<>();
  static {
    COURSE_POOL.put("MATH", new PooledCourse("MATH"));
    COURSE_POOL.put("PHYSICS", new PooledCourse("PHYSICS"));
    COURSE_POOL.put("CHEMISTRY", new PooledCourse("CHEMISTRY"));
  }

  private String name;

  // Constructor must be private, only to be
  // used with caution
  private PooledCourse(String name) {
    this.name = name;
  }

  // access to this might need to be controlled to
  // ensure that it's not used egregiously, e.g.
  // creating courses without the permission of the
  // faculty!
  public static PooledCourse of(String name) {
    name = name.toUpperCase();
    PooledCourse course = COURSE_POOL.get(name);
    if (name == null) {
      course = new PooledCourse(name);
      COURSE_POOL.put(name, course);
    }
    return course;
  }

  @Override
  public String toString() {
    return name;
  }
}

public class PoolVsEnum {
  public static void showAnECourse(ECourse ec) {
    System.out.println("Enum type course is " + ec);
  }

  public static void showASCourse(String sc) {
    System.out.println("String type course is " + sc);
  }

  public static void showAPCourse(PooledCourse pc) {
    System.out.println("Pooled course is " + pc);
  }

  public static void main(String[] args) {
    // using a String allows any valid String,
    // and prevents us restricting the argument to
    // something sensible
    showASCourse("Math");
    showASCourse("This is not a course!");

    // type safety prevents us calling this with
    // anything other than an ECourse instance
    // and the enum prevents any instances other than
    // those explicitly called out in the source
    showAnECourse(ECourse.CHEMISTRY);

    // pooled course also has type safety, and identity
    showAPCourse(PooledCourse.of("math"));
    PooledCourse p1 = PooledCourse.of("Math");
    PooledCourse p2 = PooledCourse.of("math");
    System.out.println(p1 == p2);
  }
}
