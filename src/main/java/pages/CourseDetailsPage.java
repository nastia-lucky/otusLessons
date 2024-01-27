package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CourseDetailsPage extends AbsBasePage<CourseDetailsPage> {

  protected String titleFormat = "//h1[contains(text(),'%s')]";

  public CourseDetailsPage(WebDriver driver) {
    super(driver);
  }

  public boolean isCoursePageOpened(String course) {
    logger.info(String.format("Check is course [%s] page opened", course));
    By path = By.xpath(String.format(titleFormat, course));
    waiter.waitForElementVisible(path);
    logger.logTheElementIsDisplayed(path);
    return driver.findElement(path).isDisplayed();
  }


}
