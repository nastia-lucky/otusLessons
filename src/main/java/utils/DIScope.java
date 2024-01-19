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


    private WebDriver driver = new WebDriverFactory().create();
    private Log logger = new Log();
    private DataUtils dateUtils = new DataUtils();
    private Random random = new Random();
    private StandartWaiter waiter = new StandartWaiter(driver, logger);
    private Actions actions = new Actions(driver);
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
