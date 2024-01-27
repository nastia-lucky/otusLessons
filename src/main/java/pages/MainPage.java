package pages;

import exceptions.DataDoesNotExistException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Course;
import utils.resolvers.Range;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class MainPage extends AbsBasePage<MainPage> {

  protected By lblCoursePath = By.xpath("//h5[@class]");
  protected By lblCourseStartDate = By.xpath("//a[@href]//span[contains(text(),'С ')]");
  protected String lblCourseStringFormat = "//h5[contains(text(),'%s')]";


  public MainPage(WebDriver driver) {
    super(driver);
  }


  public String getCoursesWithSpecifiedName(String courseName) {
    logger.logInfo(String.format("Get course with specific name [%s]", courseName));
    waiter.waitForElementVisible(lblCoursePath);
    List<WebElement> courses = driver.findElements(lblCoursePath);
    List<String> coursesNames =
        courses
            .stream()
            .filter(element -> element.getText().contains(courseName))
            .map(element -> element.getText())
            .collect(Collectors.toList());
    if (coursesNames.isEmpty()) {
      throw new DataDoesNotExistException();
    }
    return coursesNames.get(random.nextInt(coursesNames.size()));

  }

  public String getCourseWithDate(Range range) throws ParseException {
    logger.logInfo(String.format("Get course with date [%s]", range));
    waiter.waitForElementVisible(lblCourseStartDate);
    List<WebElement> datesLabel = driver.findElements(lblCourseStartDate);
    List<Course> courses = new ArrayList<>();
    waiter.waitNumberOfElementsMoreThan(lblCourseStartDate, 10);
    for (int i = 0; i < datesLabel.size(); i++) {
      String text = datesLabel.get(i).getText();
      Date date = dateUtils.getDate(dateUtils.resolveDate(text));
      courses.add(new Course(date, i));
    }
    Course course;
    switch (range) {
      case MAX:
        course = courses
            .stream()
            .max(Comparator.comparing(Course::getDate))
            .get();
        break;
      case MIN:
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
    actions.moveToElement(element).click().build().perform();
    logger.logClick(xpath);
    return new CourseDetailsPage(driver);
  }


}
