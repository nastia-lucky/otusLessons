package factories.impl;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeConfigure implements IBrowserSettings {


    @Override
    public WebDriver configure() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(("--start-fullscreen"));
        chromeOptions.addArguments(("--homepage=about:blank"));
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }
}
