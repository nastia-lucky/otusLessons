package assertions;

public class Assertions {

  private static final String ELEMENT_NOT_DISPLAYED = "Page with course [%s] is not opened";

  public static void getPageNotOpenedAssert(boolean isOpened, String course) {
    org.junit.jupiter.api.Assertions.assertTrue(isOpened, String.format(ELEMENT_NOT_DISPLAYED, course));
  }
}
