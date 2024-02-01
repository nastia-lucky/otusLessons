package steps;

import com.google.inject.Inject;
import components.CourseComponent;
import io.cucumber.java.en.And;
import utils.DIScope;
import java.text.ParseException;

public class CourseComponentSteps {

  @Inject
  private DIScope diScope;


  @Inject
  public CourseComponent courseComponent;


  @And("I open course page {string}")
  public void clickCourseName(String courseName) {
    courseComponent.openCoursePage(courseName);
  }

  @And("I open course with {int} date")
  public void chooseCourseWithDate(int range) throws ParseException {
    String courseName = null;
    courseName = courseComponent.getCourseWithDate(range);
    diScope.setCourseName(courseName);
    System.out.println(courseName + " My course");
    courseComponent.openCoursePage(courseName);
  }

  @And("I open course with {string} date")
  public void chooseCourseWithDate(String date) {
    String courseName;
    courseName = courseComponent.chooseCourseWithDate(date);
    diScope.setCourseName(courseName);
    courseComponent.openCoursePage(courseName);
  }


}
