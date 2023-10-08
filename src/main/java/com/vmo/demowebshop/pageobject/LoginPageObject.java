package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.LoginPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageObject extends BasePage {

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPageObject OpenHomepage(String url) {
        openUrl(driver, url);
        return this;
    }

    public LoginPageObject verifyTitleHomePage(String expectedTitle) {
        Assert.assertEquals(getTitle(driver), expectedTitle);
        Log.info("Open Home page success");
        Log.allure("Open Home page success");
        return this;
    }

    public LoginPageObject clickToLoginTag() {
        clickToElement(driver, LoginPageUI.LOGIN_TAG);
        return this;
    }

    public LoginPageObject verifyTitleLoginPage(String expectedTitle) {
        Assert.assertEquals(getTitle(driver), expectedTitle);
        Log.info("Open Login page success");
        Log.allure("Open Login page success");
        return this;
    }

    public LoginPageObject sendKeysToUserNameTextBox(String username) {
        sendKeyToElement(driver, LoginPageUI.USERNAME_TXT, username);
        Log.info("Send Key To User name success");
        Log.allure("Send Key To  User name success");
        return this;
    }

    public LoginPageObject sendKeysToPasswordTextBox(String password) {
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TXT, password);
        Log.info("Send Key To Password success");
        Log.allure("Send Key To Password success");
        return this;
    }

    public LoginPageObject clickToLoginButton() {
        clickToElement(driver, LoginPageUI.LOGIN_BTN);
        Log.info("Click on button Login success");
        Log.allure("Click on button Login success");
        return this;
    }

        public LoginPageObject verifyExpectedMsg(String expectedMsg) {
        boolean login1MsgUndisplayed = isElementUndisplayed(driver, LoginPageUI.LOGIN1_MSG);
        boolean login2MsgUndisplayed = isElementUndisplayed(driver, LoginPageUI.LOGIN2_MSG);
        boolean login2MsDisplayed = isElementDisplay(driver, LoginPageUI.LOGIN2_MSG);

        if (login1MsgUndisplayed && login2MsgUndisplayed) {
            Assert.assertTrue(isElementDisplay(driver,LoginPageUI.LOGOUT_TAG));
        }else if (login2MsDisplayed) {
                Assert.assertEquals(getTextElement(driver, LoginPageUI.LOGIN2_MSG), expectedMsg);

            } else {
                Assert.assertEquals(getTextElement(driver, LoginPageUI.LOGIN1_MSG), expectedMsg);
            }
          Log.info("Verify expected message success");
        Log.allure("Verify expected message success");
        return this;
    }
//    public LoginPageObject verifyExpectedMsg(String expectedMsg) {
//        boolean login1MsgUndisplayed = isElementUndisplayed(driver, LoginPageUI.LOGIN1_MSG);
//        boolean login2MsgUndisplayed = isElementUndisplayed(driver, LoginPageUI.LOGIN2_MSG);
//        boolean login2MsDisplayed = isElementDisplay(driver, LoginPageUI.LOGIN2_MSG);
//
//        Assert.assertTrue((login1MsgUndisplayed && login2MsgUndisplayed) || login2MsDisplayed);
//        Assert.assertEquals(login2MsDisplayed ? getTextElement(driver, LoginPageUI.LOGIN2_MSG) : getTextElement(driver, LoginPageUI.LOGIN1_MSG), expectedMsg);
//        Log.info("Verify expected message success");
//        Log.allure("Verify expected message success");
//        return this;
//    }
}