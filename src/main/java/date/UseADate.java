package date;

public class UseADate {
  public static void main(String[] args) {
    Date d = new Date(30, 1, 2022);
//    d.setDay(31);
    d.endOfMonth();
    d.addDays(10);
//    d.day = 42;
//    System.out.println(d.day);
    System.out.println(d.getDay());
    System.out.println(d.getMonth());
  }
}
