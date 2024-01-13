package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AbsBaseUtils;

public abstract class AbsBasePage<T> extends AbsBaseUtils {

    protected By btnOkButton = By.xpath("//button/div[contains(text(),'OK')]");


    protected AbsBasePage(WebDriver driver) {
        super(driver);
    }

    public T open() {
        this.driver.get(baseURL);
        closeCookies();
        return (T) this;
    }

    public void closeCookies() {
        logger.info("Close cookies");
        waiter.waitElementIsClickable(btnOkButton);
        logger.logClick(btnOkButton);
        driver.findElement(btnOkButton).click();
    }

}
