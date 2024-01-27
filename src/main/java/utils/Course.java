package utils;

import java.util.Date;

public class Course {

  private final Date date;
  private final int number;


  public Course(Date date, int number) {
    this.date = date;
    this.number = number;
  }

  public Date getDate() {
    return date;
  }

  public int getNumber() {
    return number;
  }


}
