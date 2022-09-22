package date;

public class Date {
  private int day;
  private int month;
  private int year;

  public Date(int day, int month, int year) {
    validate(day, month, year);
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public void validate(int day, int month, int year) {
    if (day < 1 || day > 31 || month < 1 || month > 12) {
      throw new IllegalArgumentException("Bad date elements");
    }
  }

  public int getDay() {
    return day;
  }

  public int getMonth() {
    return month;
  }

  public int getYear() {
    return year;
  }

//  public void endOfMonth() {
//    this.day = 31; // what is it really
//  }

  public Date endOfMonth() {
    return new Date(31, this.month, this.year);
  }

  public Date addDays(int days) {
    int newDay = this.day + days;
    int newMonth = this.month;
    int newYear = this.year;
    if (newDay > /*days in this month...*/ 31) {
      newDay -=31;// what if we added 365 days? or 50,000?
      newMonth++;
      // what about year wrap round??
    }
    return new Date(newDay, newMonth, newYear);
  }

//  public void addDays(int days) {
//    int newDay = this.day + days;
//    if (newDay > /*days in this month...*/ 31) {
//      newDay -=31;
//      this.month++;
//    }
//    this.day = newDay;
//  }
//
//  public void setDay(int day) {
//    validate(day, this.month, this.year);
//    this.day = day;
//  }
}
