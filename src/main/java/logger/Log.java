package logger;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class Log {

  public Log() {
  }

  private static final Logger LOGGER = Logger.getLogger("My Logger");

  public static String logInfo(String message) {
    LOGGER.info(message);
    return message;
  }

  public  String logClick(By elementLocator) {
    String click = String.format("Click element located [%s]", elementLocator);
    LOGGER.debug(String.format("Click element located [%s]", elementLocator));
    return click;
  }


  public String logTheElementIsDisplayed(By elementLocator) {
    String info = String.format("The element by locator [%s] is displayed", elementLocator);
    LOGGER.debug(String.format("The element  by locator [%s] is displayed", elementLocator));
    return info;
  }


  public String logWaitForElementToBeClickable(By elementLocator) {
    String info = String.format("Wait for the element located by [%s] is clickable", elementLocator);
    LOGGER.debug(String.format("Wait for the element located by [%s] is clickable", elementLocator));
    return info;
  }


  public String logWaitElementIsVisible(By elementLocator) {
    String info = String.format("Wait until element located by [%s] is visible", elementLocator);
    LOGGER.debug(String.format("Wait until element located by [%s] is visible", elementLocator));
    return info;
  }

  public String logWaitNumberOfElementsMoreThan(By elementLocator, Integer elementsNumber) {
    String info = String.format("Wait until  number of elements located by [%s] is more than [%s]", elementLocator, elementsNumber);
    LOGGER.debug(String.format("Wait until  number of elements located by [%s] is more than [%s]", elementLocator, elementsNumber));
    return info;
  }


  public void info(String message) {
    LOGGER.info(message);
  }

  //Warn Level Logs
  public void warn(String message) {
    LOGGER.warn(message);
  }

  //Error Level Logs
  public void error(String message) {
    LOGGER.error(message);
  }

  //Fatal Level Logs
  public void fatal(String message) {
    LOGGER.fatal(message);
  }

  //Debug Level Logs
  public void debug(String message) {
    LOGGER.debug(message);
  }

}
