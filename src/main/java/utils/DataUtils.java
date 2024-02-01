package utils;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.Locale;

public class DataUtils {

  public Date getDate(String date) {
    Locale locale = new Locale("ru");
    DateFormatSymbols dfs = DateFormatSymbols.getInstance(locale);
    String[] months = {
        "января", "февраля", "марта", "апреля", "мая", "июня",
        "июля", "августа", "сентября", "октября", "ноября", "декабря"};
    dfs.setMonths(months);
    SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", locale);
    sdf.setDateFormatSymbols(dfs);
    try {
      return sdf.parse(date);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }

  public String resolveDate(String text) {
    String date = null;
    if (!text.contains("года")) {
      String[] array = text.split(" ");
      if (array.length == 5 || array.length == 3) {
        date = array[1] + " " + array[2] + " " + Year.now().getValue();
      }
    } else {
      date = text.substring(2, text.indexOf(" го"));
    }
    return date;
  }
}
