package com.automation.fresher.demowebshop.feature.Card;

import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.pageobject.BuyItemPageObject;
import com.vmo.demowebshop.pageobject.PageGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("demoWebShop")
@Feature("RemoveProductFromCart")
@Story("ARemoveProductFromCartSuccessfully")
public class BuyItemSuccessfully extends BaseTest {
    BuyItemPageObject BuyItemPage;

    @BeforeMethod
    public void setUp() {
        BuyItemPage = PageGenerator.getBuyItemPageObject(driver);
    }
    @Test()
    public void TC_04_Verify_Buy_Item_Successfully() {
        String FirstName, LastName, Email, City, Address1, ZipPostalCode, PhoneNumber;
        FirstName = "Thuy Tien";
        LastName = "Nguyen";
        Email = "tien22022@gmail.com";
        City = "Ha Noi";
        Address1 = "Thanh Xuan";
        ZipPostalCode = "10000";
        PhoneNumber = "0329149135";
        BuyItemPage.openHomepage("https://demowebshop.tricentis.com/")
                .verifyTitleHomePage("Demo Web Shop")
                .clickOnDigitalDownloadTag()
                .verifyUserInDigitalDownloadPage("Demo Web Shop. Digital downloads")
                .clickAddProductToCartAndVerifyAppearMsgAndVerifyQuantityIncreasesSuccess()
                .clickOnShoppingCartTag()
                .verifyUserInCartPage("Demo Web Shop. Shopping Cart")
                .clickOnCheckboxTermOfService()
                .verifyCheckboxTermOfServiceSelected()
                .clickOnCheckOutButton()
                .verifyUserInCheckOutPage("https://demowebshop.tricentis.com/login/checkoutasguest?returnUrl=%2Fcart")
                .clickOnCheckOuAsGuessButton()
                .verifyUserIsOnOnePageCheckOut("Demo Web Shop. Checkout")
                .verifyBillingAddressTabIsExpanding("billing")
                .SenKeysToBillingAddressInfo("FirstName", FirstName)
                .SenKeysToBillingAddressInfo("LastName", LastName)
                .SenKeysToBillingAddressInfo("Email", Email)
                .selectCountryVietNamInDropDown("Viet Nam")
                .SenKeysToBillingAddressInfo("City", City)
                .SenKeysToBillingAddressInfo("Address1", Address1)
                .SenKeysToBillingAddressInfo("ZipPostalCode", ZipPostalCode)
                .SenKeysToBillingAddressInfo("PhoneNumber", PhoneNumber)
                .clickOnContinueButton("Billing")
                .verifyBillingAddressTabIsExpanding("payment_method")
                .verifyRadioButtonPaymentMethodCashIsSelected()
                .clickOnContinueButton("PaymentMethod")
                .verifyBillingAddressTabIsExpanding("payment_info")
                .verifyMsgPaymentInfoAppear()
                .clickOnContinueButton("PaymentInfo")
                .verifyBillingAddressTabIsExpanding("confirm_order")
                .verifyBillingAddressInfo("name", FirstName + " " + LastName)
                .verifyBillingAddressInfo("email", Email)
                .verifyBillingAddressInfo("phone", PhoneNumber)
                .verifyBillingAddressInfo("city-state-zip", City + " , " + ZipPostalCode)
                .verifyPaymentMethodInfo()
                .verifyProductInfo()
                .verifyTotalProductInfo()
                .clickOnContinueButton("ConfirmOrder")
                .verifyMsgOrderSuccess("Your order has been successfully processed!")
                .clickOnContinueCompleteOrderButton()
                .verifyTitleHomePage("Demo Web Shop");
}}




