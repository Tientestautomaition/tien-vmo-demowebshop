package com.vmo.nopcommerce.Enviroment;

import com.vmo.nopcommerce.driverFactory.*;
import org.openqa.selenium.WebDriver;

public class GridFactory {
    private WebDriver driver;

    public WebDriver createGridDriver(String browser) {
        browser = browser.toUpperCase();
        switch (browser) {
            case "CHROME":
                driver = new ChromeGridDriverManager().getBrowserDriver();
                break;
            case "FIREFOX":
                driver = new FirefoxGridDriverManager().getBrowserDriver();
                break;
            case "H_CHROME":
                driver = new ChromeGridHeadlessDriverManager().getBrowserDriver();
                break;
            case "EDGE":
                driver = new EdgeGridDriverManager().getBrowserDriver();
                break;
        }
        return driver;
    }
}
