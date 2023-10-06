package com.vmo.nopcommerce.Enviroment;

import com.vmo.nopcommerce.driverFactory.ChromeDriverManager;
import com.vmo.nopcommerce.driverFactory.ChromeHeadlessDriverManager;
import com.vmo.nopcommerce.driverFactory.EdgeDriverManager;
import com.vmo.nopcommerce.driverFactory.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;

public class LocalFactory {
    private WebDriver driver;

    public WebDriver createDriver(String browser) {
        browser = browser.toUpperCase();
        switch (browser) {
            case "CHROME":
                driver = new ChromeDriverManager().getBrowserDriver();
                break;
            case "FIREFOX":
                driver = new FirefoxDriverManager().getBrowserDriver();
                break;
            case "H_CHROME":
                driver = new ChromeHeadlessDriverManager().getBrowserDriver();
                break;
            case "EDGE":
                driver = new EdgeDriverManager().getBrowserDriver();
                break;
        }
        return driver;
    }
}
