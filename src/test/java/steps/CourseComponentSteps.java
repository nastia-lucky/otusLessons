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
    public void chooseCourseWithDate(int range) {
        String courseName = null;
        try {
            courseName = courseComponent.getCourseWithDate(range);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        diScope.setCourseName(courseName);
        courseComponent.openCoursePage(courseName);
    }

    @And("I open course with {string} date")
    public void chooseCourseWithDate(String date) {
        String courseName = null;
        courseName = courseComponent.chooseCourseWithDate(date);
        diScope.setCourseName(courseName);
        courseComponent.openCoursePage(courseName);
    }


}
