package date;

public class UseAssert {
  public static void main(String[] args) {
    // keyword since Java 1.4
    // used to document and prove "invariants"
    // code related to "assert" (the keyword, not the libraries!)
    // is removed during classloading by default
    // be sure there a NO SIDE-EFFECTS in assert statements!
    assert 10 > 12 : "That's exepcted";

    System.out.println("All done");
  }
}
