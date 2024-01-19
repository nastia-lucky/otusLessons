package pages;

import annotations.Component;
import annotations.Path;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.AbsBaseUtils;
import utils.DIScope;

import javax.inject.Inject;

public abstract class AbsBasePage<T> extends AbsBaseUtils {

    protected By btnOkButton = By.xpath("//button/div[contains(text(),'OK')]");
    private DIScope diScope;


    @Inject
    protected AbsBasePage(DIScope diScope) {
        super(diScope);
        this.diScope = diScope;
    }


    protected String getElementLocator() {
        Class clazz = this.getClass();
        if (clazz.isAnnotationPresent(Component.class)) {
            Component path = (Component) clazz.getDeclaredAnnotation(Component.class);
            return path.value();
        }
        return null;
    }


    private String getPath() {
        Class clazz = this.getClass();
        if (clazz.isAnnotationPresent(Path.class)) {
            Path path = (Path) clazz.getDeclaredAnnotation(Path.class);
            return path.value().endsWith("/") ? path.value() : path.value() + "/";
        }
        return "";
    }


    {
        waiter.waitForElementVisible(By.xpath(getElementLocator()));
    }


    public T open() {
        this.driver.get(baseURL + getPath());
        this.closeCookies();
        return (T) this;
    }

    public void closeCookies() {
        logger.info("Close cookies");
        waiter.waitElementIsClickable(btnOkButton);
        WebElement btnOK = driver.findElement(btnOkButton);
        logger.logClick(btnOkButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", btnOK);
        diScope.getActions().click().build().perform();
        waiter.waitElementDisappear(btnOkButton);
    }


}
