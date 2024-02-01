package pages;

import annotations.Component;
import annotations.Path;
import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DIScope;

@Path("online")
@Component("//h1[contains(text(),'Онлайн-курсы')]")
public class OnlineCoursesPage extends AbsBasePage<OnlineCoursesPage> {

  private final DIScope scope;

  protected By btnOkButton = By.xpath("//button[contains(@class,'cookies__button')]");


  @Inject
  public OnlineCoursesPage(DIScope diScope) {
    super(diScope);
    this.scope = diScope;
  }


  public void closeCookies() {
    logger.info("Close cookies");
    waiter.waitElementIsClickable(btnOkButton);
    logger.logClick(btnOkButton);
    WebElement element = driver.findElement(btnOkButton);
    scope.getActions().moveToElement(element).click().build().perform();
  }

}
