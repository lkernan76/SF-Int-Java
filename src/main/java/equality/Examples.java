package equality;

public class Examples {
  public static void main(String[] args) {
    String s1 = new String("Hello");
    String s2 = new String("Hello");
    String s3 = new String("Bonjour");
    // == represents identity of the EXPRESSION
    // and expressions of non-primitive type
    // are REFERENCES, so, for non-primitives
    // == amounts to "same object in memory"
    System.out.println(s1 == s2);
    System.out.println(s1 == s3);

    System.out.println(s1.equals(s2));
    System.out.println(s1.equals(s3));

    StringBuilder sb1 = new StringBuilder("Hello");
    StringBuilder sb2 = new StringBuilder("Hello");
    StringBuilder sb3 = new StringBuilder("Bonjour");
    System.out.println(sb1.equals(sb2));
    System.out.println(sb1.equals(sb3));
  }
}
