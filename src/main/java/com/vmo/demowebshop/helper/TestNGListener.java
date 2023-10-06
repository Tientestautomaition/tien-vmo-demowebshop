package com.vmo.nopcommerce.helper;

import com.vmo.nopcommerce.common.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

  @Override
  public void onTestStart(ITestResult result) {
    System.out.println("_______Test Start_________");
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    Log.info("---------- " + result.getName() + " SUCCESS test ----------");
    Object testClass = result.getInstance();
    WebDriver webDriver = ((BaseTest) testClass).getDriver();
    saveScreenShot(webDriver);
  }

  @Override
  public void onStart(ITestContext context) {
    System.out.println("_______Test On Start_________");
  }

  @Override
  public void onFinish(ITestContext context) {
    System.out.println("_______Test Finish_________");
  }


  @Attachment()
  public static byte[] saveScreenShot(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }
  @Override
  public void onTestFailure(ITestResult result) {
    Log.info("---------- " + result.getName() + " FAILED test ----------");
    Object testClass = result.getInstance();
    WebDriver webDriver = ((BaseTest) testClass).getDriver();
    saveScreenShot(webDriver);
  }
}

