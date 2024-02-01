package utils;

import factories.WebDriverFactory;
import io.cucumber.guice.ScenarioScoped;
import logger.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import waiters.StandartWaiter;
import java.util.Random;

@ScenarioScoped
public class DIScope {


  private final WebDriver driver = new WebDriverFactory().create();
  private final Log logger = new Log();
  private final DataUtils dateUtils = new DataUtils();
  private final Random random = new Random();
  private final StandartWaiter waiter = new StandartWaiter(driver, logger);
  private final Actions actions = new Actions(driver);
  private String courseName = null;

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public WebDriver getDriver() {
    return driver;
  }

  public Log getLogger() {
    return logger;
  }

  public DataUtils getDateUtils() {
    return dateUtils;
  }

  public Random getRandom() {
    return random;
  }

  public StandartWaiter getWaiter() {
    return waiter;
  }

  public Actions getActions() {
    return actions;
  }
}
