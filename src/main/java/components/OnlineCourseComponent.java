package components;

import com.google.inject.Inject;
import exceptions.DataDoesNotExistException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Course;
import utils.DIScope;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OnlineCourseComponent extends AbsBaseComponent {

  private final DIScope diScope;


  private final By lblLessonPrice = By.xpath("//div[contains(@class,'price')]");
  private final By lblLessonTitle = By.xpath("//div[contains(@class,'lessons__new-item-title')]");

  @Inject
  public OnlineCourseComponent(DIScope diScope) {
    super(diScope);
    this.diScope = diScope;
  }

  public String clickGetGetCourseWithPrice(int range) {
    waiter.waitNumberOfElementsMoreThan(lblLessonPrice, 1);
    List<WebElement> elements = diScope.getDriver().findElements(lblLessonPrice);
    List<Course> courses = new ArrayList<>();
    for (int i = 0; i < elements.size(); i++) {
      String text = elements.get(i).getText().substring(0, elements.get(i).getText().indexOf(" "));
      courses.add(new Course(Integer.parseInt(text), i));
    }
    Course course;
    switch (range) {
      case 1:
        course = courses
            .stream()
            .max(Comparator.comparing(Course::getPrice))
            .get();
        break;
      case 2:
        course = courses
            .stream()
            .min(Comparator.comparing(Course::getPrice))
            .get();
        break;
      default:
        throw new DataDoesNotExistException();
    }

    WebElement courseTitle = driver.findElements(lblLessonTitle).get(course.getNumber());
    String text = courseTitle.getText();
    logger.info("The course " + text + " with price " + range);
    courseTitle.click();
    return text;
  }

}
