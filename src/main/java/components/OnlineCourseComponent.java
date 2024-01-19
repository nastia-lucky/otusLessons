package components;

import com.google.inject.Inject;
import exceptions.DataDoesNotExistException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Course;
import utils.DIScope;
import utils.resolvers.Range;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OnlineCourseComponent extends AbsBaseComponent {

    private DIScope diScope;


    private By lblLessonPrice = By.xpath("//div[contains(@class,'price')]");
    private By lblLessonTitle = By.xpath("//div[contains(@class,'lessons__new-item-title')]");
    private String formatTitle = "//div[contains(@text(),'%s')]";

    @Inject
    public OnlineCourseComponent(DIScope diScope) {
        super(diScope);
        this.diScope = diScope;
    }

    public String clickGetgetCourseWithPrice(Range range) {
        waiter.waitNumberOfElementsMoreThan(lblLessonPrice, 1);
        List<WebElement> elements = diScope.getDriver().findElements(lblLessonPrice);
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            String text = elements.get(i).getText().substring(0, elements.get(i).getText().indexOf(" "));
            courses.add(new Course(Integer.parseInt(text), i));
        }
        Course course;
        switch (range) {
            case MAX:
                course = courses
                        .stream()
                        .max(Comparator.comparing(Course::getPrice))
                        .get();
                break;
            case MIN:
                course = courses
                        .stream()
                        .min(Comparator.comparing(Course::getPrice))
                        .get();
                break;
            default:
                throw new DataDoesNotExistException();
        }

        WebElement courseTitle = driver.findElements(lblLessonTitle).get(course.getNumber());
        String text = courseTitle.getText();
        logger.info("The course " + text + " with price " + range);
        courseTitle.click();
        return text;
    }

}
