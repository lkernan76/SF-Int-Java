package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLClientInfoException;

public class UseMultiCatch {
  public static void main(String[] args)
      throws SQLClientInfoException, FileNotFoundException {
//      throws Exception {
    try {
      System.out.println("In try");
      if (Math.random() > 0.6) throw new SQLClientInfoException();
      System.out.println("part way through try");
      if (Math.random() > 0.6) throw new FileNotFoundException();
      System.out.println("finishing try");
//    } catch (SQLClientInfoException | FileNotFoundException /*| IOException*/ e) {
//      System.out.println("Something broke!");
//      throw e;
//    }

    } catch (Exception e) { // NONONO catches other stuff
      System.out.println("Something broke!");
//      e = null;
      throw e;
    }

//    } catch (SQLClientInfoException se) {
//      System.out.println("Something broke!");
//    } catch (FileNotFoundException fnfe) {
//      System.out.println("Something broke!");
//    }
  }
}
