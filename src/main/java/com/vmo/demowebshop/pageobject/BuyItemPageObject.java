package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.BooksPageUI;
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

    public BuyItemPageObject verifyUserInDigitalDownloadPage(String expectedTitle) {
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

    public BuyItemPageObject verifyUserIsOnOnePageCheckOut(String expectedTitle) {
        Assert.assertEquals(getTitle(driver), expectedTitle);
        Log.info("verifyUserIsOnOnePageCheckOut success");
        Log.allure("verifyUserIsOnOnePageCheckOut success");
        return this;
    }

    public BuyItemPageObject verifyBillingAddressTabIsExpanding(String nameTab) {
        Assert.assertTrue(getAttributeElement(driver, BuyItemPageUI.EXPANDING_TAB.replace("$", nameTab), "class").contains("active"));
        Log.info("verifyBillingAddressTabIsExpanding success");
        Log.allure("verifyBillingAddressTabIsExpanding success");
        return this;
    }

    public BuyItemPageObject clickOnContinueButton(String nameTab) {
        clickToElement(driver, BuyItemPageUI.CONTINUE_BTN.replace("$", nameTab));
        Log.info("clickOnContinueButton success");
        Log.allure("clickOnContinueButton success");
        return this;
    }

    public BuyItemPageObject SenKeysToBillingAddressInfo(String nameFieldTextBox, String inputText) {
        sendKeyToElement(driver, BuyItemPageUI.BILLING_ADDRESS_TXT.replace("$", nameFieldTextBox), inputText);
        Log.info("SenKeysToBillingAddressInfo success");
        Log.allure("SenKeysToBillingAddressInfo success");
        return this;
    }

    public BuyItemPageObject verifyBillingAddressInfo(String nameFieldTextBox, String expectedText) {
        Assert.assertTrue(getTextElement(driver, BuyItemPageUI.BILLING_ADDRESS_INFO.replace("$", nameFieldTextBox)).contains(expectedText));
        Log.info("verifyBillingAddressInfo success");
        Log.allure("verifyBillingAddressInfo success");
        return this;
    }

    public BuyItemPageObject selectCountryVietNamInDropDown(String itemText) {
        selectItemInDefaultDropdownByText(driver, BooksPageUI.COUNTRY_DROPDOWN, itemText);
        Log.info("selectCountryVietNamInDropDown success");
        Log.allure("selectCountryVietNamInDropDown success");
        return this;
    }

    public BuyItemPageObject verifyRadioButtonPaymentMethodCashIsSelected() {
        Assert.assertTrue(isElementSelected(driver, BuyItemPageUI.RADIO_BUTTON_PAYMENT_METHOD_CASH));
        Log.info("verifyRadioButtonPaymentMethodCashIsSelected success");
        Log.allure("verifyRadioButtonPaymentMethodCashIsSelected success");
        return this;
    }

    public BuyItemPageObject verifyMsgPaymentInfoAppear() {
        Assert.assertTrue(isElementDisplay(driver, BuyItemPageUI.MSG_YOU_WILL_PAID_BY_COD));
        Log.info("verifyMsgPaymentInfoAppear success");
        Log.allure("verifyMsgPaymentInfoAppear success");
        return this;
    }

    public BuyItemPageObject verifyPaymentMethodInfo() {
        Assert.assertTrue(getTextElement(driver, BuyItemPageUI.PAYMENT_METHOD_INFO).contains("Cash On Delivery (COD)"));
        Log.info("verifyPaymentMethodInfo success");
        Log.allure("verifyPaymentMethodInfo success");
        return this;
    }

    public BuyItemPageObject verifyProductInfo() {
        Assert.assertTrue(getTextElement(driver, BuyItemPageUI.PRODUCT_INFO).contains("Music 2"));
        Log.info("verifyProductInfo success");
        Log.allure("verifyProductInfo success");
        return this;
    }

    public BuyItemPageObject verifyTotalProductInfo() {
        String subTotalText = getTextElement(driver, BuyItemPageUI.SUB_TOTAL_PRODUCT);
        float subTotal = Float.parseFloat(subTotalText);
        String paymentMethodAddFeeText = getTextElement(driver, BuyItemPageUI.PAYMENT_METHOD_ADD_FEE);
        float paymentMethodAddFee = Float.parseFloat(paymentMethodAddFeeText);
        String totalText = getTextElement(driver, BuyItemPageUI.TOTAL_PRODUCT);
        float total = Float.parseFloat(totalText);

        Assert.assertEquals(subTotal + paymentMethodAddFee, total);

        Log.info("verifyProductInfo success");
        Log.allure("verifyProductInfo success");
        return this;
    }

    public BuyItemPageObject verifyMsgOrderSuccess(String expectedMsg) {
        Assert.assertEquals(getTextElement(driver, BuyItemPageUI.MSG_ORDER_SUCCESS), expectedMsg);
        Log.info("verifyMsgOrderSuccess success");
        Log.allure("verifyMsgOrderSuccess success");
        return this;
    }

    public BuyItemPageObject clickOnContinueCompleteOrderButton() {
        clickToElement(driver, BuyItemPageUI.CONTINUE_COMPLETE_ORDER_BTN);
        Log.info("clickOnContinueCompleteOrderButton success");
        Log.allure("clickOnContinueCompleteOrderButton success");
        return this;
    }
}

