package pages;

import org.openqa.selenium.WebDriver;
import utils.AbsBaseUtils;

public abstract class AbsBasePage<T> extends AbsBaseUtils {


    protected AbsBasePage(WebDriver driver) {
        super(driver);
    }

    public T open(String url) {
        driver.get(url);
        return (T) this;
    }

}
