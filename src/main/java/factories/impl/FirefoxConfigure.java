package factories.impl;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxConfigure implements IBrowserSettings {


  @Override
  public WebDriver configure() {
    FirefoxOptions options = new FirefoxOptions();
    options.addArguments(("--start-fullscreen"));
    options.addArguments(("--homepage=about:blank"));
    WebDriverManager.firefoxdriver().setup();
    return new FirefoxDriver(options);
  }
}
