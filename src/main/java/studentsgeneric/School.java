package studentsgeneric;

import java.util.ArrayList;
import java.util.List;

interface Criterion<S> {
  boolean test(S s);
}

interface UseA<S> {
  void accept(S s);
}

public class School {
  public static <S> void useAll(Iterable<S> roster, UseA<S> op) {
    for (S s : roster) {
      op.accept(s);
    }
  }

  // arguments to methods constrain your callers
  // more general -> more useful method
  // return types can be more specific (which might... or might not... be useful)
  // return type is a constraint on the implementation
  public static <S> List<S> selectByCriterion(
      Iterable<S> roster, Criterion<S> crit) {
    List<S> rv = new ArrayList<>();
    for (S s : roster) {
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
    System.out.println("use pretty print");
    useAll(roster, s ->
        System.out.println("Student: " + s.getName() + " takes "
            + s.getCourses().size() + " courses and has a grade of "
            + s.getGpa()));

    List<String> names = List.of("Fred", "Jim", "Sheila", "Bob");
    useAll(selectByCriterion(names, s -> s.length() < 6),
        s -> System.out.println("> " + s));
  }
}
