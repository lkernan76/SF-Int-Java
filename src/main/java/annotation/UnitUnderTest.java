package annotation;

//@RunMe
public class UnitUnderTest {
//  @RunMe
  private String name = "Some Name!";

  @RunMe(count=99, name="Albert", value="another value")
  public void testThis() {
    System.out.println("testThis");
  }

  @RunMe("the value")
  private void testThat() {
    System.out.println("testThat");
  }

  private void butDoNotTestThisOne() {
    System.out.println("oops, not supposed to test this!");
  }

  @Override
  public String toString() {
    return "UnitUnderTest{" +
        "name='" + name + '\'' +
        '}';
  }
}
