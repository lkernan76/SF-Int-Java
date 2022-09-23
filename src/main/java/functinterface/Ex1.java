package functinterface;

interface Y {
//  void doXStuff();
}
@FunctionalInterface
interface X extends Y {
  void doStuff();
  default void doOtherStuff() {}
  static void doMoreStuff() {}
  private void doEvenMoreStuff() {}
}

public class Ex1 {
  public static void main(String[] args) {
    X x = () -> {};
  }
}
