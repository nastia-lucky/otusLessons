package steps;

import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import pages.OnlineCoursesPage;

public class OnlineCoursesSteps {


  @Inject
  private OnlineCoursesPage onlineCoursesPage;

  @Given("Online Courses page is opened")
  public void openMainPage() {
    onlineCoursesPage.open();
  }
}
