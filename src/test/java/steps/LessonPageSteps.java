package steps;

import com.google.inject.Inject;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.CourseDetailsPage;
import utils.DIScope;

public class LessonPageSteps {

  @Inject
  private DIScope diScope;

  @Inject
  public CourseDetailsPage courseDetailsPage;


  @Then("I check course {string} page is opened")
  public void isCoursePageOpened(String courseName) {
    courseDetailsPage.isCoursePageOpened(courseName);
  }

  @Then("I check course page is opened")
  public void isCoursePageOpened() {
    Assert.assertTrue(courseDetailsPage.isCoursePageOpened(diScope.getCourseName()),
        "Course details page " + diScope.getCourseName() + " is not opened");
  }


}
