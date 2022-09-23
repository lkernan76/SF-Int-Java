package exceptions;

import java.io.*;

public class Example {
  public static void main(String[] args)/* throws bigimportantexcpetion */{
//    try {
//      FileReader input = new FileReader("data.txt");
//      FileWriter output = new FileWriter("newdata.txt");
//      // copy file...
//
//    } catch (FileNotFoundException fnfe) {
//      System.out.println("file not found");
//    } catch (IOException fnfe) {
//      System.out.println("open for write failed");
//    } finally {
//      System.out.println("in finally.");
//      output.close();
//      input.close();
//    }

    // try to fix it (and only partially succeed)
//    FileReader input = null;
//    FileWriter output = null;
//    try {
//      input = new FileReader("data.txt");
//      output = new FileWriter("newdata.txt");
//      // copy file...
//      // throw bigimportantexception (to the caller)
//
//    } catch (FileNotFoundException fnfe) {
//      System.out.println("file not found");
//    } catch (IOException fnfe) {
//      System.out.println("open for write failed");
//    } finally {
//      System.out.println("in finally.");
//      if (output != null) {
//        try {
//          output.close();
//        } catch (IOException ioe) {
//          System.out.println("oops, didn't close output properly");
//        }
//      }
//      if (input != null) {
//        try {
//          input.close();
//        } catch (IOException ioe) {
//          System.out.println("oops, didn't close input properly");
//        }
//      }
//    }
    try (// declare the "resources"
         // -- these must be effectively final and
         // implement AutoCloseable (you can declare your own
         // AutoCloseable types, and they work properly)
      FileReader input = new FileReader("data.txt");
      FileWriter output = new FileWriter("newdata.txt");
      BufferedReader br = new BufferedReader(input);
      PrintWriter pw = new PrintWriter(output);
    ) {
      // copy file...
      // throw bigimportantexception (to the caller)
      String line;
      while ((line = br.readLine()) != null) {
        pw.println(line);
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("file not found");
    } catch (IOException fnfe) {
      System.out.println("open for write failed");
    } // auto-generated finally will (try to) close all "resources"
    // in reverse order of their mention in the resource block
    // if anything fails to close, we DO NO LOSE any currently
    // active exception, close exceptions are added as "suppressed"
    // exceptions to the thrown live exception
  }
}
