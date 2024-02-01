package components;

import com.google.inject.Inject;
import exceptions.DataDoesNotExistException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CourseDetailsPage;
import utils.Course;
import utils.DIScope;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CourseComponent extends AbsBaseComponent {


  protected DIScope diScope;


  @Inject
  public CourseComponent(DIScope diScope) {
    super(diScope);
    this.diScope = diScope;
  }

  protected By lblCoursePath = By.xpath("//h5[@class]");
  protected By lblCourseStartDate = By.xpath("//a[@href]//span[contains(text(),'С ')]");
  protected String lblCourseStringFormat = "//h5[contains(text(),'%s')]";


  public String getCourseWithDate(int number) {
    logger.logInfo(String.format("Get course with date [%s]", number));
    waiter.waitForElementVisible(lblCourseStartDate);
    List<WebElement> datesLabel = driver.findElements(lblCourseStartDate);
    List<Course> courses = new ArrayList<>();
    waiter.waitNumberOfElementsMoreThan(lblCourseStartDate, 10);
    for (int i = 0; i < datesLabel.size(); i++) {
      String text = datesLabel.get(i).getText();
      Date date = diScope.getDateUtils().getDate(diScope.getDateUtils().resolveDate(text));
      courses.add(new Course(date, i));
    }
    Course course;
    switch (number) {
      case 1:
        course = courses
            .stream()
            .max(Comparator.comparing(Course::getDate))
            .get();
        break;
      case 2:
        course = courses
            .stream()
            .min(Comparator.comparing(Course::getDate))
            .get();
        break;
      default:
        throw new DataDoesNotExistException();
    }

    return driver.findElements(lblCoursePath).get(course.getNumber()).getText();
  }

  public CourseDetailsPage openCoursePage(String courseName) {
    logger.info(String.format("Open course [%s] page ", courseName));
    By xpath = By.xpath(String.format(lblCourseStringFormat, courseName));
    waiter.waitElementIsClickable(xpath);
    WebElement element = driver.findElement(xpath);
    diScope.getActions().moveToElement(element).click().build().perform();
    logger.logClick(xpath);
    return new CourseDetailsPage(diScope);
  }

  public String chooseCourseWithDate(String providedDate) {
    logger.logInfo(String.format("Get course with date the same or more than", providedDate));
    waiter.waitForElementVisible(lblCourseStartDate);
    List<WebElement> datesLabel = driver.findElements(lblCourseStartDate);
    List<Course> courses = new ArrayList<>();
    waiter.waitNumberOfElementsMoreThan(lblCourseStartDate, 10);
    for (int i = 0; i < datesLabel.size(); i++) {
      String text = datesLabel.get(i).getText();
      Date date = diScope.getDateUtils().getDate(diScope.getDateUtils().resolveDate(text));
      courses.add(new Course(date, i));
    }
    List<Course> coursesWithProvidedDate = courses.stream()
        .filter(course -> course.getDate().after(diScope.getDateUtils().getDate(diScope.getDateUtils().resolveDate(providedDate))))
        .collect(Collectors.toList());

    return diScope.getDriver().findElements(lblCoursePath).get(coursesWithProvidedDate.get(0).getNumber()).getText();
  }


}
