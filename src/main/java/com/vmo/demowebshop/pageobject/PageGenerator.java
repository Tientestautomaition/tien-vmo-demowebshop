package com.vmo.demowebshop.pageobject;

import org.openqa.selenium.WebDriver;

public class PageGenerator {

    public static LoginPageObject getLoginObject(WebDriver driver) {
        return new LoginPageObject(driver);
    }
    public static BookPageObject getBookObject(WebDriver driver) {
        return new BookPageObject(driver);
    }   public static CartPageObject getCartPageObject(WebDriver driver) {
        return new CartPageObject(driver);
    }
  public static BuyItemPageObject getBuyItemPageObject(WebDriver driver) {
        return new BuyItemPageObject(driver);
    }

}
