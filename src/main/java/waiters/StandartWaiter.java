package waiters;

import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandartWaiter implements IWaiter {

    private WebDriver driver;
    private Log logger;
    private Integer waitingTime = 5;


    public StandartWaiter(WebDriver driver, Log logger) {
        this.driver = driver;
        this.logger = logger;
    }


    @Override
    public boolean waitForCondition(ExpectedCondition condition) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, waitingTime);
        try {
            webDriverWait.until(condition);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }


    public boolean waitForElementVisible(By locator) {
        logger.logWaitElementIsVisible(locator);
        return waitForCondition(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public boolean waitElementIsClickable(By locator) {
        logger.logWaitForElementToBeClickable(locator);
        return waitForCondition(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitNumberOfElementsMoreThan(By locator, Integer elementsNumber) {
        logger.logWaitNumberOfElementsMoreThan(locator, elementsNumber);
        return waitForCondition(ExpectedConditions.numberOfElementsToBeMoreThan(locator, elementsNumber));
    }

    public boolean waitElementDisappear(By locator) {
        return waitForCondition(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

}