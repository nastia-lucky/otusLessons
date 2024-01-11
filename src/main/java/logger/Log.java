package logger;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class Log {

    public Log() {
    }

    private final Logger logger = Logger.getLogger("My Logger");

    public String logInfo(String message) {
        logger.info(message);
        return message;
    }

    public String logClick(By elementLocator) {
        String click = String.format("Click element located [%s]", elementLocator);
        logger.debug(String.format("Click element located [%s]", elementLocator));
        return click;
    }


    public String logTypeTo(String elementName, By elementLocator, String value) {
        String info = String.format("Type value [%s] to element [%s] located [%s]", value, elementName, elementLocator);
        logger.debug(String.format("Type value [%s] to element [%s] located [%s]", value, elementName, elementLocator));
        return info;
    }

    public String logTheElementIsDisplayed(By elementLocator) {
        String info = String.format("The element by locator [%s] is displayed", elementLocator);
        logger.debug(String.format("The element  by locator [%s] is displayed", elementLocator));
        return info;
    }


    public String logWaitForElementToBeClickable( By elementLocator) {
        String info = String.format("Wait for the element located by [%s] is clickable",  elementLocator);
        logger.debug(String.format("Wait for the element located by [%s] is clickable",  elementLocator));
        return info;
    }


    public String logWaitForElementDisappear(By elementLocator) {
        String info = String.format("Wait for element located [%s] disappear", elementLocator);
        logger.debug(String.format("Wait for element  located [%s] disappear", elementLocator));
        return info;
    }


    public String logClickElementWithSpecifiedText(By elementLocator, String text) {
        String info = String.format("Click element with specified text [%s] located by [%s]", text, elementLocator);
        logger.debug(String.format("Click element with specified text [%s] located by [%s]", text, elementLocator));
        return info;
    }

    public String logWaitElementIsVisible(By elementLocator) {
        String info = String.format("Wait until element located by [%s] is visible", elementLocator);
        logger.debug(String.format("Wait until element located by [%s] is visible", elementLocator));
        return info;
    }


    public void info(String message) {
        logger.info(message);
    }

    //Warn Level Logs
    public void warn(String message) {
        logger.warn(message);
    }

    //Error Level Logs
    public void error(String message) {
        logger.error(message);
    }

    //Fatal Level Logs
    public void fatal(String message) {
        logger.fatal(message);
    }

    //Debug Level Logs
    public void debug(String message) {
        logger.debug(message);
    }

}
