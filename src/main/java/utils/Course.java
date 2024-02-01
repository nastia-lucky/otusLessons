package utils;

import java.util.Date;

public class Course {

  private Date date;
  private final int number;
  private int price;


  public Course(Date date, int number) {
    this.date = date;
    this.number = number;
  }

  public Course(int price, int number) {
    this.price = price;
    this.number = number;
  }

  public Date getDate() {
    return date;
  }

  public int getNumber() {
    return number;
  }

  public int getPrice() {
    return price;
  }


}
