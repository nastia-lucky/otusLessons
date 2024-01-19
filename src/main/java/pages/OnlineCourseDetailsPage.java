package pages;

import annotations.Component;
import com.google.inject.Inject;
import org.openqa.selenium.By;
import utils.DIScope;

@Component("//div[contains(text(),'Подготовительный онлайн курс')]")
public class OnlineCourseDetailsPage extends AbsBasePage<OnlineCourseDetailsPage> {


    private String titleFormat = "//h3[contains(text(),'%s')]";

    @Inject
    public OnlineCourseDetailsPage(DIScope diScope) {
        super(diScope);
    }

    public boolean isOnlineCoursePageOpened(String course) {
        logger.info(String.format("Check is online course [%s] page opened", course));
        By path = By.xpath(String.format(titleFormat, course));
        waiter.waitForElementVisible(path);
        logger.logTheElementIsDisplayed(path);
        return driver.findElement(path).isDisplayed();
    }


}
