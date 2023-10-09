package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.BuyItemPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BuyItemPageObject extends BasePage {

    public BuyItemPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public BuyItemPageObject openHomepage(String url) {
        openUrl(driver, url);
        return this;
    }

    public BuyItemPageObject verifyTitleHomePage(String expectedTitle) {
        Assert.assertEquals(getTitle(driver), expectedTitle);
        Log.info("Open Home page success");
        Log.allure("Open Home page success");
        return this;
    }
    public BuyItemPageObject clickOnDigitalDownloadTag() {
        clickToElement(driver, BuyItemPageUI.DIGITAL_DOWNLOAD_TAG);
        return this;
    }

    public BuyItemPageObject verifyUserInDigitalDownloadPage (String expectedTitle) {
        Assert.assertEquals(getTitle(driver), expectedTitle);
        Log.info("User in cart page");
        Log.allure("User in cart page");
        return this;
    }
    public BuyItemPageObject clickAddProductToCartAndVerifyAppearMsgAndVerifyQuantityIncreasesSuccess() {
        String cartQuantityText0 = getTextElement(driver, BuyItemPageUI.SHOPPING_CART_QUANTITY).substring(1, 2);
        int cartQuantity0 = Integer.parseInt(cartQuantityText0);

        clickToElement(driver, BuyItemPageUI.ADD_TO_CART_PRODUCT_BTN);
        Log.info("Click on product  success");
        Log.allure("Click on product  success");
        Assert.assertTrue(isElementDisplay(driver, BuyItemPageUI.ADD_TO_CART_SUCCESS_MSG));
        sleepInSecond(4);

        String cartQuantityText1 = getTextElement(driver, BuyItemPageUI.SHOPPING_CART_QUANTITY).substring(1, 2);
        int cartQuantity1 = Integer.parseInt(cartQuantityText1);
        Assert.assertEquals(cartQuantity1 - 1, cartQuantity0);
        Log.info("Verify quantity increases ");
        Log.allure("Verify quantity increases");
        return this;
    }

    public BuyItemPageObject clickOnShoppingCartTag() {
        clickToElement(driver, BuyItemPageUI.SHOPPING_CART_TAG);
        return this;
    }

    public BuyItemPageObject verifyUserInCartPage(String expectedTitle) {
        Assert.assertEquals(getTitle(driver), expectedTitle);
        Log.info("User in cart page");
        Log.allure("User in cart page");
        return this;
    }
    public BuyItemPageObject clickOnCheckboxTermOfService() {
        clickToElement(driver, BuyItemPageUI.CHECKBOX_TERM_OF_SERVICE);
        Log.info("clickOnCheckboxTermOfService success");
        Log.allure("clickOnCheckboxTermOfService success");
        return this;
    }
    public BuyItemPageObject verifyCheckboxTermOfServiceSelected() {
        Assert.assertTrue(isElementSelected(driver, BuyItemPageUI.CHECKBOX_TERM_OF_SERVICE));
        Log.info("verifyCheckboxRemoveProductIsSelected success");
        Log.allure("verifyCheckboxRemoveProductIsSelected success");
        return this;
    }
    public BuyItemPageObject clickOnCheckOutButton() {
        clickToElement(driver, BuyItemPageUI.CHECKBOX_BTN);
        Log.info("clickOnCheckboxTermOfService success");
        Log.allure("clickOnCheckboxTermOfService success");
        return this;
    }
    public BuyItemPageObject verifyUserInCheckOutPage(String expectedUrl) {
        Assert.assertEquals(getCurrentUrl(driver), expectedUrl);
        Log.info("User in Check Out page");
        Log.allure("User in Check Out page");
        return this;
    }
    public BuyItemPageObject clickOnCheckOuAsGuessButton() {
        clickToElement(driver, BuyItemPageUI.CHECKBOX_AS_WEB_BTN);
        Log.info("clickOnCheckOuAsGuessButton success");
        Log.allure("clickOnCheckOuAsGuessButton success");
        return this;
    }
    }

