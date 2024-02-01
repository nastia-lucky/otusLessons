package factories;

import exceptions.BrowserNotSupportedException;
import factories.impl.ChromeConfigure;
import factories.impl.FirefoxConfigure;
import factories.impl.OperaConfigure;
import listeners.Listener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverFactory implements IFactory<EventFiringWebDriver> {

  private final String browserName = System.getProperty("browser", "chrome").toLowerCase();


  @Override
  public EventFiringWebDriver create() {
    EventFiringWebDriver myDriver;
    switch (browserName) {
      case ("chrome"): {
        myDriver = new EventFiringWebDriver(new ChromeConfigure().configure());
        break;
      }
      case ("firefox"): {
        myDriver = new EventFiringWebDriver(new FirefoxConfigure().configure());
        break;
      }
      case ("opera"): {
        myDriver = new EventFiringWebDriver(new OperaConfigure().configure());
        break;
      }
      default:
        throw new BrowserNotSupportedException(browserName);
    }
    myDriver.register(new Listener());
    return myDriver;
  }


}
