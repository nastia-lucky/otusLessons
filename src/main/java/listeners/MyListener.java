package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AbsBaseUtils;

public class MyListener extends AbsBaseUtils implements ITestListener {


  public void onTestStart(ITestResult iTestResult) {
    logger.logInfo(iTestResult.getName() + " started");
  }

  @Override
  public void onTestSuccess(ITestResult iTestResult) {
    logger.logInfo(iTestResult.getName() + " passed");

  }

  @Override
  public void onTestFailure(ITestResult iTestResult) {
    logger.logInfo(iTestResult.getName() + " test failed");

  }


}
