package steps;

import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import pages.MainPage;

public class MainPageSteps {

    @Inject
    public MainPage mainPage;

    @Given("Main page is opened")
    public void openMainPage() {
        mainPage.open();
    }

}
