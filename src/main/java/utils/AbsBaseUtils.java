package utils;

import logger.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import waiters.StandartWaiter;

import java.util.Random;

public abstract class AbsBaseUtils {

    protected WebDriver driver;
    protected Log logger = new Log();
    protected DataUtils dateUtils = new DataUtils();
    protected Random random = new Random();
    protected StandartWaiter waiter;
    protected String baseURL = System.getProperty("url", "https://otus.ru/");
    protected Actions actions;


    protected AbsBaseUtils(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        waiter = new StandartWaiter(driver, logger);
    }


    protected AbsBaseUtils() {
    }

}
