package annotation;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

public class TestHarness {
  public static void main(String[] args) throws Throwable {
    Properties prop = new Properties();
    prop.load(new FileReader("testme.properties"));

    String uutName = prop.getProperty("testthis");
    System.out.println("about to load class: " + uutName);

    Class<?> theClass = Class.forName(uutName);
    System.out.println("loaded class called " + theClass.getName());
//    Constructor<?> cons = theClass.getConstructor(String.class, Integer.class);
    Constructor<?> cons = theClass.getConstructor();
    Object obj = cons.newInstance();

    System.out.println(obj);

    // gets accessible methods, including inherited
//    Method[] methods = theClass.getMethods();

    // gets methods declared in this class (not inherited)
    // but includes private
    Method[] methods = theClass.getDeclaredMethods();

    for (Method m : methods) {
      System.out.println("> " + m);
      RunMe annot = m.getAnnotation(RunMe.class);
      if (annot != null) {
        System.out.println("*** RunMe Annotation found, count value is "
            + annot.count() + " name is " + annot.name()
            + " value is " + annot.value());
        m.setAccessible(true);
        m.invoke(obj);
      }
    }
  }
}
