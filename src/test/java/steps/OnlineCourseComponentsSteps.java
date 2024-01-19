package steps;

import com.google.inject.Inject;
import components.OnlineCourseComponent;
import io.cucumber.java.en.Then;
import utils.DIScope;
import utils.resolvers.Range;

public class OnlineCourseComponentsSteps {

    @Inject
    private DIScope diScope;

    @Inject
    public OnlineCourseComponent onlineCourseComponent;


    @Then("I choose online course with price ???????")
    public void openOnlineCoursePageWithPrice(Range range) {
        String courseName = onlineCourseComponent.clickGetgetCourseWithPrice(range);
        diScope.setCourseName(courseName);
    }
}
