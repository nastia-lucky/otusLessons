package otus.sliders;

import annotations.Driver;
import assertions.Assertions;
import extensions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import pages.CourseDetailsPage;
import pages.MainPage;
import utils.resolvers.Range;

import java.text.ParseException;

@ExtendWith(UIExtension.class)
public class OtusTest {


    @Driver
    protected WebDriver driver;


    @ParameterizedTest
    @ValueSource(strings = {"Team", "Java"})
    public void filterCourse(String name) {
        MainPage mainPage = new MainPage(driver);
        String courseName =
                mainPage.getCoursesWithSpecifiedName(name);
        CourseDetailsPage courseDetailsPage =
                mainPage.openCoursePage(courseName);
        Assertions.getPageNotOpenedAssert(courseDetailsPage.isCoursePageOpened(name), name);
    }


    @Test
    public void sortByDate() throws ParseException {
        MainPage mainPage = new MainPage(driver);
        String course = mainPage
                .getCourseWithDate(Range.MIN);
        CourseDetailsPage courseDetailsPage =
                mainPage
                        .openCoursePage(course);
        Assertions.getPageNotOpenedAssert(courseDetailsPage.isCoursePageOpened(course), course);
    }


}
