package factories.impl;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class OperaConfigure implements IBrowserSettings {


  @Override
  public WebDriver configure() {
    OperaOptions options = new OperaOptions();
    options.addArguments(("--start-fullscreen"));
    options.addArguments(("--homepage=about:blank"));
    WebDriverManager.operadriver().setup();
    return new OperaDriver(options);
  }
}
