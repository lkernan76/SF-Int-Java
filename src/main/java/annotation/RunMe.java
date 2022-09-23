package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
@Target(ElementType.METHOD)
//public @ interface RunMe {
public @interface RunMe {
  int count() default 0;
  String name() default "Unknown";
  String value();
}
