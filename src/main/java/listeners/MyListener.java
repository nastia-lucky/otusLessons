package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AbsBaseUtils;

public class MyListener extends AbsBaseUtils implements ITestListener {


  public void onTestStart(ITestResult result) {
    logger.logInfo(result.getTestName() + " started");
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    logger.logInfo(result.getTestName() + " passed");

  }

  @Override
  public void onTestFailure(ITestResult result) {
    logger.logInfo(result.getTestName() + " test failed");
  }


}
