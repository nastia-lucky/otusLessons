package assertions;

public class Assertions {

    private static String assertElementNotDisplayed= "Page with course [%s] is not opened";

    public static void getPageNotOpenedAssert(boolean isOpened,  String course){
        org.junit.jupiter.api.Assertions.assertTrue(isOpened, String.format(assertElementNotDisplayed, course));
    }
}
