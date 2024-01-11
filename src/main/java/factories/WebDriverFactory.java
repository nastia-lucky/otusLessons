package factories;

import exceptions.BrowserNotSupportedException;
import factories.impl.ChromeConfigure;
import factories.impl.FirefoxConfigure;
import factories.impl.OperaConfigure;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverFactory implements IFactory<EventFiringWebDriver> {

    private String browserName = System.getProperty("browser", "chrome").toLowerCase();

    @Override
    public EventFiringWebDriver create() {
        switch (browserName) {
            case ("chrome"): {
                return new EventFiringWebDriver(new ChromeConfigure().configure());
            }
            case ("firefox"): {
                return new EventFiringWebDriver(new FirefoxConfigure().configure());
            }
            case ("opera"): {
                return new EventFiringWebDriver(new OperaConfigure().configure());
            }
            default:
                throw new BrowserNotSupportedException(browserName);
        }
    }
}
