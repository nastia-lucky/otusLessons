package steps;

import com.google.inject.Inject;
import components.OnlineCourseComponent;
import io.cucumber.java.en.Then;
import utils.DIScope;

public class OnlineCourseComponentsSteps {

  @Inject
  private DIScope diScope;

  @Inject
  public OnlineCourseComponent onlineCourseComponent;


  @Then("I choose online course with price {int}")
  public void openOnlineCoursePageWithPrice(int range) {
    String courseName = onlineCourseComponent.clickGetGetCourseWithPrice(range);
    diScope.setCourseName(courseName);
  }
}
