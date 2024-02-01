package pages;

import annotations.Component;
import com.google.inject.Inject;
import org.openqa.selenium.By;
import utils.DIScope;

@Component("//h1")
public class CourseDetailsPage extends AbsBasePage<CourseDetailsPage> {

  protected String titleFormat = "//h1[contains(text(),'%s')]";

  @Inject
  public CourseDetailsPage(DIScope diScope) {
    super(diScope);
  }

  public boolean isCoursePageOpened(String course) {
    logger.info(String.format("Check is course [%s] page opened", course));
    By path = By.xpath(String.format(titleFormat, course));
    waiter.waitForElementVisible(path);
    logger.logTheElementIsDisplayed(path);
    return driver.findElement(path).isDisplayed();
  }


}
