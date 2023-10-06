package com.vmo.nopcommerce.driverFactory;

import com.vmo.nopcommerce.common.GlobalConstants;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class ChromeGridDriverManager implements BrowserFactory{
  @Override
  public WebDriver getBrowserDriver(){
    ChromeOptions options = new ChromeOptions();
    try {
      return new RemoteWebDriver(new URL(GlobalConstants.HUB_REMOTE),options);
    } catch (MalformedURLException e){
      throw new RuntimeException(e);
    }
  }
}
