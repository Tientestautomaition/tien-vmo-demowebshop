package com.vmo.nopcommerce.driverFactory;

import com.vmo.nopcommerce.common.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxGridDriverManager implements BrowserFactory {
  @Override
  public WebDriver getBrowserDriver() {
    FirefoxOptions options = new FirefoxOptions();
    try {
      return new RemoteWebDriver(new URL(GlobalConstants.HUB_REMOTE), options);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }
}