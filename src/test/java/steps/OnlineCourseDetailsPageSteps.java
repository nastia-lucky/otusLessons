package steps;

import com.google.inject.Inject;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.OnlineCourseDetailsPage;
import utils.DIScope;

public class OnlineCourseDetailsPageSteps {

  @Inject
  private DIScope diScope;

  @Inject
  public OnlineCourseDetailsPage onlineCourseDetailsPage;


  @Then("I check online course page is opened")
  public void isCoursePageOpened() {
    Assert.assertTrue(onlineCourseDetailsPage.isOnlineCoursePageOpened(diScope.getCourseName()),
        "Online course page " + diScope.getCourseName() + " is not opened");
  }


}
