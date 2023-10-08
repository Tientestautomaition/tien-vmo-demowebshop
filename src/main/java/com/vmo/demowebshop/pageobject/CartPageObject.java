package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.BooksPageUI;
import com.vmo.demowebshop.interfaces.CartPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public CartPageObject verifyAddProductToCart(String expectedTitle) {
        clickToElement(driver,CartPageUI.ADD_TO_CART_PRODUCT1_BTN);
        clickToElement(driver,CartPageUI.ADD_TO_CART_PRODUCT2_BTN);
        clickToElement(driver,CartPageUI.ADD_TO_CART_PRODUCT3_BTN);
        return this;
    }
    public CartPageObject verifyAppearMsgAddProductToCartSuccess() {
        Assert.assertTrue(isElementDisplay(driver,CartPageUI.ADD_TO_CART_SUCCESS_MSG));
        return this;
    }
    public CartPageObject hoverOnShoppingCartTag() {
       clickToElement(driver, CartPageUI.SHOPPING_CART_TAG);
        return this;
    }
    public CartPageObject verifyUserInCartPage() {
        Assert.assertTrue(isElementDisplay(driver,CartPageUI.SHOPPING_CARD_TITLE));
        return this;
    }
    public CartPageObject clickOnCheckboxRemoveProduct(){
        List<WebElement> listElements = getListWebElements(driver, CartPageUI.CHECKBOX_PRODUCT_REMOVE_ON_CART);
        List<String> listXpathCheckBox = new ArrayList<>();


        uncheckToDefaultCheckbox(driver,)
        return this;
    }
}
