package utils;

import com.google.inject.Inject;
import logger.Log;
import org.openqa.selenium.WebDriver;
import waiters.StandartWaiter;

public abstract class AbsBaseUtils {

    protected String baseURL = System.getProperty("url", "https://otus.ru/");
    protected WebDriver driver;
    protected Log logger;
    protected StandartWaiter waiter;


    @Inject
    public  AbsBaseUtils(DIScope diScope) {
        this.driver = diScope.getDriver();
        this.logger = diScope.getLogger();
        this.waiter = diScope.getWaiter();
    }


    protected AbsBaseUtils() {
    }

}
