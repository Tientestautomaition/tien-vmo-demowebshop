package com.vmo.nopcommerce.driverFactory;

import com.vmo.nopcommerce.common.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class ChromeGridHeadlessDriverManager implements BrowserFactory {
  @Override
  public WebDriver getBrowserDriver(){
    ChromeOptions options = new ChromeOptions();
    options.setHeadless(true);
    try {
      return new RemoteWebDriver(new URL(GlobalConstants.HUB_REMOTE),options);
    } catch (MalformedURLException e){
      throw new RuntimeException(e);
    }
  }
}