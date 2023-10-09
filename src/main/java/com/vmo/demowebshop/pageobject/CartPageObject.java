package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.CartPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPageObject extends BasePage {

    public CartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public CartPageObject openHomepage(String url) {
        openUrl(driver, url);
        return this;
    }

    public CartPageObject verifyTitleHomePage(String expectedTitle) {
        Assert.assertEquals(getTitle(driver), expectedTitle);
        Log.info("Open Home page success");
        Log.allure("Open Home page success");
        return this;
    }
    public CartPageObject verifyAppearMsgAddProductToCartSuccess() {
        String cartQuantityText0 = getTextElement(driver, CartPageUI.SHOPPING_CART_QUANTITY).substring(1, 2);
        int cartQuantity0 = Integer.parseInt(cartQuantityText0);

        clickToElement(driver, CartPageUI.ADD_TO_CART_PRODUCT_BTN);
        Log.info("Click on product 1 success");
        Log.allure("Click on product 1 success");
        Assert.assertTrue(isElementDisplay(driver, CartPageUI.ADD_TO_CART_SUCCESS_MSG));
        sleepInSecond(4);

        String cartQuantityText1 = getTextElement(driver, CartPageUI.SHOPPING_CART_QUANTITY).substring(1, 2);
        int cartQuantity1 = Integer.parseInt(cartQuantityText1);
        Assert.assertEquals(cartQuantity1 - 1, cartQuantity0);

        clickToElement(driver, CartPageUI.ADD_TO_CART_PRODUCT_BTN);
        Log.info("Click on product 2 success");
        Log.allure("Click on product 2 success");
        Assert.assertTrue(isElementDisplay(driver, CartPageUI.ADD_TO_CART_SUCCESS_MSG));
        sleepInSecond(4);

        String cartQuantityText2 = getTextElement(driver, CartPageUI.SHOPPING_CART_QUANTITY).substring(1, 2);
        int cartQuantity2 = Integer.parseInt(cartQuantityText2);
        Assert.assertEquals(cartQuantity2 - 1, cartQuantity1);

        clickToElement(driver, CartPageUI.ADD_TO_CART_PRODUCT_BTN);
        Log.info("Click on product 2 success");
        Log.allure("Click on product 2 success");
        Assert.assertTrue(isElementDisplay(driver, CartPageUI.ADD_TO_CART_SUCCESS_MSG));
        sleepInSecond(4);

        String cartQuantityText3 = getTextElement(driver, CartPageUI.SHOPPING_CART_QUANTITY).substring(1, 2);
        int cartQuantity3 = Integer.parseInt(cartQuantityText3);
        Assert.assertEquals(cartQuantity3 - 1, cartQuantity2);
        Log.info("Verify increases product ");
        Log.allure("Verify increases product");
        return this;
    }

    public CartPageObject clickOnShoppingCartTag() {
        clickToElement(driver, CartPageUI.SHOPPING_CART_TAG);
        return this;
    }

    public CartPageObject verifyUserInCartPage(String expectedTitle) {
        Assert.assertEquals(getTitle(driver), expectedTitle);
        Log.info("User in cart page");
        Log.allure("User in cart page");
        return this;
    }

    public CartPageObject clickOnCheckboxRemoveProduct() {
        clickToElement(driver, CartPageUI.CHECKBOX_PRODUCT_REMOVE_ON_CART);
        Log.info("clickOnCheckboxRemoveProduct success");
        Log.allure("clickOnCheckboxRemoveProduct success");
        return this;
    }

    public CartPageObject verifyCheckboxRemoveProductIsSelected() {
        Assert.assertTrue(isElementSelected(driver, CartPageUI.CHECKBOX_PRODUCT_REMOVE_ON_CART));
        Log.info("verifyCheckboxRemoveProductIsSelected success");
        Log.allure("verifyCheckboxRemoveProductIsSelected success");
        return this;
    }

    public CartPageObject clickOnUpdateToCartAndVerifyDecreasesQuantity() {
        String cartQuantityText0 = getTextElement(driver, CartPageUI.SHOPPING_CART_QUANTITY).substring(1, 2);
        int cartQuantity0 = Integer.parseInt(cartQuantityText0);

        clickToElement(driver, CartPageUI.UPDATE_TO_CART_BTN);
        sleepInSecond(2);
        String cartQuantityText1 = getTextElement(driver, CartPageUI.SHOPPING_CART_QUANTITY).substring(1, 2);
        int cartQuantity1 = Integer.parseInt(cartQuantityText1);
        Assert.assertEquals(cartQuantity0 -3  , cartQuantity1);
        Log.info("clickOnUpdateToCartAndVerifyDecreasesQuantity success");
        Log.allure("clickOnUpdateToCartAndVerifyDecreasesQuantity success");
        return this;
    }
}
